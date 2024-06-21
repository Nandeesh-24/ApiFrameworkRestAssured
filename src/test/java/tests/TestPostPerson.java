package tests;

import helpers.PersonServiceHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPostPerson {

    PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testCreatePerson(){
        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);

        Assert.assertNotNull(id,"Person id is not null");
    }
}
