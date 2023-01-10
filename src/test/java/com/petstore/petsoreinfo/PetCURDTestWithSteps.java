package com.petstore.petsoreinfo;

import com.petstore.model.PetPojo;
import com.petstore.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


@RunWith(SerenityRunner.class)
public class PetCURDTestWithSteps extends TestBase {


    static int id= 0;
    static String name= "Vim";
    static String status= "available";
    static int petId;

    @Steps
    PetSteps petSteps;

    @Title("This will create a new PetID")
    @Test
    public void test001() {

        PetPojo petPojo = new PetPojo();
        List<String> categoryList = new ArrayList<String>();
        categoryList.add("id");
        categoryList.add("name");

        List<String> tags = new ArrayList<String>();
        tags.add("id");
        tags.add("name");





    }

    @Title("Verify if the Pet ID was added to the application")
    @Test
    public void test002() {
        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .pathParam("id", "10")
                .get("/v2/pet/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Title("Update the Pet ID information and verify the updated information")
    @Test
    public void test003() {
        PetPojo petPojo = new PetPojo();
        HashMap<String, Object> pet = new HashMap<String, Object>();
        pet.put("id", "0");
        pet.put("name", "Zxcvbv");


        List<String> name = new ArrayList<String>();
        name.add("Qwerty");

        List<HashMap<String, Object>> petList = new ArrayList<HashMap<String, Object>>();
        petList.add(pet);


        petPojo.setId(0);
        petPojo.setCategory(pet);
        petPojo.setName("Asdfgf");
        petPojo.setPhotoUrls(name);

        petPojo.setStatus("available");

        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(petPojo)
                .put("v2/pet");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Title("Delete the Pet ID and verify if the Pet ID is deleted!")
    @Test
    public void test004() {
        Response response = (Response) given()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .pathParam("id", "10")
                .delete("/v2/pet/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}
