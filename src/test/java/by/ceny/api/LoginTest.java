package by.ceny.api;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @DisplayName("unregistered user")
    @Test
    public void test1() {
        given().
                body(LoginRequest.getBodyRequestFull()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all().
                statusCode(200).body("errors", Matchers.hasItem("Email или пароль указаны некорректно"))
                .body("data.success", equalTo(false))
                .body("data.status", equalTo(0))
                .body("data.fields", empty());
    }

    @DisplayName("no data in body")
    @Test
    public void test2() {
        given().
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all().
                statusCode(200).
                body("errors.pass", Matchers.equalTo("Укажите пароль")).
                body("errors.email", Matchers.equalTo("Email адрес указан некорректно"))
                .body("data.success", Matchers.equalTo(false))
                .body("data.status", Matchers.equalTo(0))
                .body("data.fields", Matchers.hasItems("pass", "email"));
    }

    @DisplayName("no email in body")
    @Test
    public void test3() {
        given().
                body(LoginRequest.getBodyRequestNoEmail()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all().
                statusCode(200).
                body("errors.email", Matchers.equalTo("Email адрес указан некорректно"))
                .body("data.success", Matchers.equalTo(false))
                .body("data.status", Matchers.equalTo(0))
                .body("data.fields", Matchers.hasItems("email"));
    }

    @DisplayName("no pass in body")
    @Test
    public void test4() {
        given().
                body(LoginRequest.getBodyRequestNoPassword()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all().
                statusCode(200).body("errors.pass", Matchers.equalTo("Укажите пароль"))
                .body("data.success", equalTo(false))
                .body("data.status", equalTo(0))
                .body("data.fields", Matchers.hasItem("pass"));
    }

    @DisplayName("inccorrect symbols in body")
    @Test
    public void test5() {
        given().
                body(LoginRequest.getBodyRequestInccorrectSymbols()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all().
                statusCode(200).body("errors.email", Matchers.equalTo("Email адрес указан некорректно"))
                .body("data.success", equalTo(false))
                .body("data.status", equalTo(0))
                .body("data.fields", Matchers.hasItems("email"));
    }

    @DisplayName("unregistered user")
    @Test
    public void test6() {
        given().
                body(LoginRequest.getBodyRequestFull()).
                headers(LoginRequest.getHeaderForBadRequest()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all().
                statusCode(400);
    }
}
