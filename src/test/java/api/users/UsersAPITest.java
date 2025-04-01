package api.users;

import api.BaseTest;
import org.testng.annotations.Test;
import utils.FileReaderUtil;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersAPITest extends BaseTest {

    @Test
    public void testGetAllUsers() {
        given()
            .spec(requestSpec)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void testGetSingleUser() {
        given()
            .spec(requestSpec)
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("username", notNullValue());
    }

    @Test
    public void testCreateUser() throws IOException {
        String userJson = FileReaderUtil.readFile("test-data/users/create-user.json");

        given()
            .spec(requestSpec)
            .body(userJson)
        .when()
            .post("/users")
        .then()
            .statusCode(200)
            .body("id", notNullValue());
    }

    @Test
    public void testUpdateUser() throws IOException {
        String updateData = FileReaderUtil.readFile("test-data/users/update-user.json");

        given()
            .spec(requestSpec)
            .body(updateData)
        .when()
            .put("/users/1")
        .then()
            .statusCode(200)
            .body("username", equalTo("updated_user"));
    }

    @Test
    public void testDeleteUser() {
        given()
            .spec(requestSpec)
        .when()
            .delete("/users/1")
        .then()
            .statusCode(200);
    }
}