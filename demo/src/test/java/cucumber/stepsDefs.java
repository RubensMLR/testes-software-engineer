package cucumber;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class stepsDefs {

    @Quando("que eu faço um POST em {word} passando o seguinte docstring:")
    public void queEuFaçoUmPOSTEmVConsultaEnderecoPassandoOSeguinteDocstring(String endPoint, Map<String,String> reqBody) {
        given().
            body(reqBody);
    }

    @Então("o controller me retorna o json de acordo com contrato.")
    public void oControllerMeRetornaOJsonDeAcordoComContrato(String endPoint) {
        when().
            post(endPoint).
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Então("o controller deve me retornar um erro.")
    public void oControllerDeveMeRetornarUmErro(String endPoint) {
        when().
            post(endPoint).
        then().
            statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }
}
