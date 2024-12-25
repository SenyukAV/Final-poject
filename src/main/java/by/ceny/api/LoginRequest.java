package by.ceny.api;

import by.ceny.ui.domain.SiteData;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginRequest {

    public static final String URL_LOGIN = "https://edc.sale/ru/user/login";
    public static Map<String, String> getHeader() {
        Map<String, String> haveHeader = new HashMap<>();
        haveHeader.put("accept", "application/json, text/javascript, */*; q=0.01");
        haveHeader.put("Accept-Encoding", "gzip, deflate, br");
        haveHeader.put("Connection", "keep-alive");
        haveHeader.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        haveHeader.put("sec-fetch-mode", "cors");
        haveHeader.put("sec-ch-ua", "\"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"");
        return haveHeader;
    }

    public static Map<String, String> getHeaderForBadRequest() {
        Map<String, String> haveHeader = new HashMap<>();
        haveHeader.put("Host", " ");
        haveHeader.put("accept", "application/json, text/javascript, */*; q=0.01");
        haveHeader.put("Accept-Encoding", "gzip, deflate, br");
        haveHeader.put("Connection", "keep-alive");
        haveHeader.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        haveHeader.put("sec-fetch-mode", "cors");
        haveHeader.put("sec-ch-ua", "\"Chromium\";v=\"130\", \"Google Chrome\";v=\"130\", \"Not?A_Brand\";v=\"99\"");
        return haveHeader;
    }

    public static String getBodyRequestFull() {
        return "back=https%3A%2F%2Fedc.sale%2Fru%2Fby%2F&email=" + new SiteData().getEmailData().getEmail() + "&pass=" + new SiteData().getPasswordlData().getPassword() + "&uufp=22adbd9c609048fb66132d8ca79451c6&";
    }

    public static String getBodyRequestNoEmail() {
        return "back=https%3A%2F%2Fedc.sale%2Fru%2Fby%2F&pass=" + new SiteData().getPasswordlData().getPassword() + "&uufp=22adbd9c609048fb66132d8ca79451c6&";
    }

    public static String getBodyRequestNoPassword() {
        return "back=https%3A%2F%2Fedc.sale%2Fru%2Fby%2F&email=k%" + new SiteData().getEmailData().getEmail() + "&uufp=22adbd9c609048fb66132d8ca79451c6&";
    }

    public static String getBodyRequestInccorrectSymbols() {
        return "back=https%3A%2F%2Fedc.sale%2Fru%2Fby%2F&email=!^)k%40gmail.com&pass=!^)qwerrt&uufp=22adbd9c609048fb66132d8ca79451c6&";
    }

    public static ValidatableResponse normalRequest() {
        return given().
                body(LoginRequest.getBodyRequestFull()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all();
    }


    public static ValidatableResponse noDataInBody() {
        return given().
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all();
    }

    public static ValidatableResponse noEmailInBody() {
        return given().
                body(LoginRequest.getBodyRequestNoEmail()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all();
    }

    public static ValidatableResponse bodyRequestNoPassword() {
        return given().
                body(LoginRequest.getBodyRequestNoPassword()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all();
    }

    public static ValidatableResponse bodyRequestInccorrectSymbols() {
        return given().
                body(LoginRequest.getBodyRequestNoPassword()).
                headers(LoginRequest.getHeader()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all();
    }

    public static ValidatableResponse headerForBadRequest() {
        return given().
                body(LoginRequest.getBodyRequestFull()).
                headers(LoginRequest.getHeaderForBadRequest()).
                when().
                post(LoginRequest.URL_LOGIN).
                then().
                log().all();
    }
}
