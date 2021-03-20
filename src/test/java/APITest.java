import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mapping.PageRequestModel;
import mapping.PersonRequestModel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {
    @BeforeClass
    void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test(description = "Получение списка пользователей.")
    public void getUsers() {
        PageRequestModel pageRequestModel = given()
                .when().get("/api/users?page=2")
                .then().statusCode(200).extract().body().as(PageRequestModel.class);
        Assert.assertNotNull(pageRequestModel);

        //System.out.println(page);
    }

    @Test(description = "Создание пользователя и проверка ответа.")
    public void createPerson() {
        PersonRequestModel sendPerson = new PersonRequestModel("morpheus", "leader");
        PersonRequestModel receivedPerson = given()
                .contentType(ContentType.JSON).body(sendPerson)
                .when().post("/api/users")
                .then().statusCode(201).extract().body().as(PersonRequestModel.class);
        Assert.assertEquals(sendPerson.getName(), receivedPerson.getName());
        Assert.assertEquals(sendPerson.getJob(), receivedPerson.getJob());

        //System.out.println(receivedPerson);
    }
}
