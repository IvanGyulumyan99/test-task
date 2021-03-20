import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mapping.Page;
import mapping.Person;
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
        Page page = given()
                .when().get("/api/users?page=2")
                .then().statusCode(200).extract().body().as(Page.class);
        Assert.assertNotNull(page);

        System.out.println(page);
    }

    @Test(description = "Создание пользователя и проверка ответа.")
    public void createPerson() {
        Person sendPerson = new Person("morpheus", "leader");
        Person receivedPerson = given()
                .contentType(ContentType.JSON).body(sendPerson)
                .when().post("/api/users")
                .then().statusCode(201).extract().body().as(Person.class);
        Assert.assertEquals(sendPerson, receivedPerson);

        System.out.println(receivedPerson);
    }
}
