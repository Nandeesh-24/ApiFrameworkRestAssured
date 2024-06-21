package tests;

import helpers.PersonServiceHelper;
import model.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestGetPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGetAllPerson(){
        List<Person> personList = personServiceHelper.getAllPersons();
        Assert.assertNotNull(personList,"Person list is not empty");
    }


    @Test
    public void testGetPerson(){
        Person person = personServiceHelper.getPerson(1);
        Assert.assertNotNull(person,"Person is not null");
    }
}
