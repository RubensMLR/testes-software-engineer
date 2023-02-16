package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    @Given("Eu passo o cep para o controller")
    public void euPassoOCepParaOController() {
        System.out.println("euPassoOCepParaOController");
    }

    @And("o controller valida se o cep é valido")
    public void oControllerValidaSeOCepÉValido() {
        System.out.println("oControllerValidaSeOCepÉValido");
    }
    @When("o cep for válido o controller recupera as informaçoes do endereço")
    public void oCepForVálidoOControllerRecuperaAsInformaçoesDoEndereço() {
        System.out.println("oCepForVálidoOControllerRecuperaAsInformaçoesDoEndereço");
    }

    @Then("o controller fará um parser no formado do contrato especificado.")
    public void oControllerFaráUmParserNoFormadoDoContratoEspecificado() {
        System.out.println("oControllerFaráUmParserNoFormadoDoContratoEspecificado");
    }
}
