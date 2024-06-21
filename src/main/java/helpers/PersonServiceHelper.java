package helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Person;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import utils.ConfigManager;

import java.lang.reflect.Type;
import java.util.List;

public class PersonServiceHelper {

    //methods to fetch data from endpoints

    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    private static final String PORT = ConfigManager.getInstance().getString("port");


    public PersonServiceHelper(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Person> getAllPersons(){
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        Type type = new TypeReference<List<Person>>(){}.getType();

        return response.as(type);
    }

    public Person getPerson(int id){
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .get(EndPoints.GET_SINGLE_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        Type type = new TypeReference<Person>(){}.getType();

        return response.as(type);
    }

    public Response createPerson(){

        Person person = new Person();

        person.setId("3");
        person.setFirstName("a");
        person.setLastName("j");
        person.setPhoneNumbers("380987654567");
        person.setAddress("dskjsdjcn,sdksjdh");

        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(person)
                .post(EndPoints.CREATE_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,"Created");

        return response;
    }
}
