package org.example.api;

import io.qameta.allure.Step;
import org.example.random.RandomGenerator;
import static io.restassured.RestAssured.given;


public class ApiMethods extends RandomGenerator {
    private String token;

    @Step("Создали пользователя")
    public String createUser(CreateUserPojo createUserJson) {
        token = given()
                .header("Content-type", "application/json")
                .body(createUserJson)
                .when().post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then().extract().body().path("accessToken");
        return token;
    }

    @Step("Авторизовались пользователем")
    public String loginUser(String email, String password) {
        LoginUserPojo loginUserJson = new LoginUserPojo(email, password);
        token = given()
                .header("Content-type", "application/json")
                .body(loginUserJson)
                .when().post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then().extract().body().path("accessToken");
        return token;
    }

    @Step("Удалили пользователя")
    public void deleteUser(String token) {
         given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .when().delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then();
    }
}
