package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import stepdefinitions.FormularioSteps;

public class RegistroSteps {

    @Steps
    FormularioSteps formulario;

    @Given("que el usuario accede al formulario de registro")
    public void accederFormulario() {
        formulario.abrirFormulario();
    }

    @When("ingresa datos válidos en todos los campos")
    public void datosValidos() {
        formulario.completarFormularioValido();
    }

    @When("completa todos los campos usando datos aleatorios")
    public void datosConFaker() {
        formulario.completarFormularioConFaker();
    }

    @When("deja vacio todos los campos")
    public void enviarCamposVacios() {
        formulario.enviarFormulario();
    }

    @When("ingresa un solo carácter en el campo First Name")
    public void nombreUnCaracter() {
        formulario.ingresarNombreUnCaracter();
    }

    @When("selecciona el género {string} y el hobby {string}")
    public void seleccionarGeneroYHobby(String genero, String hobby) {
        formulario.seleccionarGeneroYHobby(genero, hobby);
    }

    @When("ingresa un email sin arroba")
    public void emailInvalido() {
        formulario.ingresarEmailSinArroba();
    }

    @And("completa el resto del formulario con datos válidos")
    public void completarResto() {
        formulario.completarRestoConDatosValidos();
    }

    @And("hace clic en el botón Submit")
    public void enviarFormulario() {
        formulario.enviarFormulario();
    }

    @Then("el sistema muestra el mensaje {string}")
    public void validarMensaje(String mensaje) {
        Assert.assertEquals(mensaje, formulario.obtenerMensajeModal());
    }

    @Then("el sistema no permite enviar el formulario")
    public void validarFormularioNoEnviado() {
        formulario.validarFormularioNoEnviado();  // Aquí llamas al método que hiciste
    }

}
