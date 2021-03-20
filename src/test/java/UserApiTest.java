import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mappings.CreateUserResponse;
import mappings.GetUsersResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserApiTest {

    private static final String BASE_URL = "https://reqres.in";
    private static final String API_USERS = "/api/users";
    private static final String QUERY_PARAM_PAGE = "page";

    @BeforeClass
    void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test(description = "Получение списка пользователей.")
    public void getUsers() {
        GetUsersResponse getUsersResponse =
                given()
                    .queryParam(QUERY_PARAM_PAGE, 2)
                .when().get(API_USERS)
                .then().statusCode(HttpStatus.SC_OK)
                    .extract().body().as(GetUsersResponse.class);
        assertNotNull(getUsersResponse);
    }

    @Test(description = "Создание пользователя и проверка ответа.")
    public void createUser() {
        String name = "morpheus";
        String job = "leader";

        JsonObject requestPayload = new JsonObject();
        requestPayload.addProperty("name", name);
        requestPayload.addProperty("job", job);

        CreateUserResponse createdUser =
                given()
                    .contentType(ContentType.JSON).body(requestPayload)
                .when().post(API_USERS)
                .then().statusCode(HttpStatus.SC_CREATED)
                    .extract().body().as(CreateUserResponse.class);

        assertEquals(createdUser.getName(), name);
        assertEquals(createdUser.getJob(), job);
    }
}
