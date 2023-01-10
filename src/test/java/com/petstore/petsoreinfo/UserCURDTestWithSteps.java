package com.petstore.petsoreinfo;

import io.restassured.response.Response;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.studentinfo.UserSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;


@RunWith(SerenityRunner.class)
public class UserCURDTestWithSteps extends TestBase {



    @Steps
    UserSteps userSteps;

    @Title("This will create a new student")
    @Test
    public void test001() {

        UserPojo userPojo = new UserPojo();
        userPojo.setId(2);
        userPojo.setUserName("Vil1");
        userPojo.setFirstName("Vil");
        userPojo.setLastName("Rav");
        userPojo.setEmail("Abcd1234@gmail.com");
        userPojo.setPassword(1234);
        userPojo.setPhone(74555555);
        userPojo.setUserStatus(1);

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(userPojo)
                .post("");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Title("Verify if the student was added to the application")
    @Test
    public void test002() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/Vil1")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()

                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        UserPojo userPojo = new UserPojo();

        userPojo.setFirstName("Vil");
        userPojo.setLastName("Rav");


        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/Vil1")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(userPojo)
                .put("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/Vil1")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
