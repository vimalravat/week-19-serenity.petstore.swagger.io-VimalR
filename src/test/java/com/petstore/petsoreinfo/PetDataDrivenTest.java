package com.petstore.petsoreinfo;

import com.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;


@Concurrent(threads = "8x")
@UseTestDataFrom("src/test/java/resources/testdata/petinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class PetDataDrivenTest extends TestBase {

    private int id;

    private HashMap<String,Object> category;

    private String name ;

    private List<String> photoUrls;

    private List<String> tags;

    private String status;
    @Steps
    PetSteps petSteps;

    @Title("Data driven test for adding multiple students to the application")
    @Test
    public void createMultiplePetId() {


    }

}


