package com.petstore.petsoreinfo;

import com.petstore.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;


/*@Concurrent(threads = "8x")
@UseTestDataFrom("src/test/java/resources/testdata/petinfo.csv")
@RunWith(SerenityParameterizedRunner.class)*/
public class UserDataDrivenTest extends TestBase {

    private int id;

    private String userName;

    private String firstName;

    private String lastName;
    private String email;
    private int password;
    private long phone;
    private int userStatus;
    @Steps
    UserSteps userSteps;

    @Title("Data driven test for adding multiple students to the application")
    @Test
    public void createMultipleStudents() {

    }

}


