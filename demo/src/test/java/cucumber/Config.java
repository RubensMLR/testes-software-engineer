package cucumber;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class Config {

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.requestSpecification = new RequestSpecBuilder().
                addHeader("Authorization", getToken()).
                setContentType(ContentType.JSON).
                build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                build();
    }

    private String getToken(){
        return "token";
    }
}
