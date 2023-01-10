package com.petstore.petsoreinfo;

import com.petstore.constants.EndPoints;
import com.petstore.model.PetPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class PetSteps {
    @Step("Creating pet id : {0}, category: {1}, name: {2}, photoUrls: {3}, tags: {4} and status: {5}")
    public ValidatableResponse createPetId(int id, List<String> category, String name,
                                             String status, List<String> tags) {

        PetPojo petPojo = new PetPojo();
        petPojo.setId(id);
        petPojo.setCategory((HashMap<String, Object>) category);
        petPojo.setName(name);

        petPojo.setTags(tags);
        petPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(petPojo)
                .post("/pet")
                .then();
    }

    @Step("Getting the PetId information with Id: {0}")
    public HashMap<String, Object> getStudentInfoByFirstName(String firstName) {
        String p1 = "findAll{it.firstName == '";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PET_ID)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + firstName + p2);
    }

    @Step("Update the Pet ID information with petId: {0}, Creating pet id : {1}, category: {2}, name: {3}, photoUrls: {4}, tags: {5} and status: {6}")
    public ValidatableResponse updatePetId(int petId, int id, HashMap<String,Object> category, String name,
                                             List<HashMap<String, Object>> tags, String status) {
        PetPojo petPojo = new PetPojo();
        petPojo.setId(id);
        petPojo.setCategory(category);
        petPojo.setName(name);


        petPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", petId)
                .body(petPojo)
                .when()
                .put(EndPoints.UPDATE_PET_BY_ID)
                .then();
    }

    @Step("Deleting PetId information : {0}")
    public ValidatableResponse deletePetId(int petId) {
        return SerenityRest.given().log().all()
                .pathParam("id", petId)
                .when()
                .delete(EndPoints.DELETE_PET_BY_ID)
                .then();
    }

    @Step("Getting PetId information: {0}")
    public ValidatableResponse getPetIdById(int petId){
        return SerenityRest.given().log().all()
                .pathParam("id", petId)
                .when()
                .get(EndPoints.GET_SINGLE_PET_ID_BY_ID)
                .then();
    }
}
