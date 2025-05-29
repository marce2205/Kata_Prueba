package stepdefinitions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementClickInterceptedException;
import pages.DatosFaker;
import org.junit.Assert;
import net.serenitybdd.core.Serenity;


import java.time.Duration;
import java.util.List;

public class FormularioSteps extends UIInteractions {

    @Step("Abrir formulario")
    public void abrirFormulario() {
        getDriver().get("https://demoqa.com/automation-practice-form");
        getDriver().manage().window().maximize();
    }

    @Step("Completar formulario con datos válidos")
    public void completarFormularioValido() {
        find(By.id("firstName")).type(DatosFaker.nombre());
        find(By.id("lastName")).type(DatosFaker.apellido());
        find(By.id("userEmail")).type(DatosFaker.email());
        seleccionarGenero("Male");
        find(By.id("userNumber")).type(DatosFaker.telefono());
        seleccionarHobby("Sports");
        seleccionarEstadoYCiudad();
    }

    @Step("Completar formulario con datos aleatorios")
    public void completarFormularioConFaker() {
        find(By.id("firstName")).type(DatosFaker.nombre());  // Cambia por tu método faker real
        find(By.id("lastName")).type(DatosFaker.apellido());
        find(By.id("userEmail")).type(DatosFaker.email());
        seleccionarGenero("Male");
        find(By.id("userNumber")).type(DatosFaker.telefono());
        seleccionarHobby("Sports");
        seleccionarEstadoYCiudad();
    }

    @Step("Ingresar nombre con un solo caracter")
    public void ingresarNombreUnCaracter() {
        find(By.id("firstName")).type("A");
    }
    @Step("Validar mensaje de error de email inválido")
    public boolean validarErrorEmail() {
        List<WebElementFacade> errores = findAll(By.id("userEmail-error"));
        if (errores.isEmpty()) {
            return false; // no hay mensaje de error visible
        }
        String textoError = errores.get(0).getText();
        return textoError != null && !textoError.isEmpty();
    }
    @Step("Seleccionar género {0} y hobby {1}")
    public void seleccionarGeneroYHobby(String genero, String hobby) {
        find(By.id("firstName")).type(DatosFaker.nombre());
        find(By.id("lastName")).type(DatosFaker.apellido());
        find(By.id("userEmail")).type(DatosFaker.email());
        seleccionarGenero(genero);
        find(By.id("userNumber")).type(DatosFaker.telefono());
        seleccionarHobby(hobby);
        seleccionarEstadoYCiudad();
    }

    @Step("Ingresar email sin arroba")
    public void ingresarEmailSinArroba() {
        find(By.id("firstName")).type(DatosFaker.nombre());
        find(By.id("lastName")).type(DatosFaker.apellido());
        find(By.id("userEmail")).type("prueba.com");
        seleccionarGenero("Male");
        find(By.id("userNumber")).type(DatosFaker.telefono());
        seleccionarHobby("Music");
        seleccionarEstadoYCiudad();
    }

    @Step("Completar el resto del formulario con datos válidos")
    public void completarRestoConDatosValidos() {
        find(By.id("lastName")).type("Pérez");
        find(By.id("userEmail")).type("juan@mail.com");
        seleccionarGenero("Male");
        find(By.id("userNumber")).type("1234567890");
        seleccionarHobby("Sports");
        seleccionarEstadoYCiudad();
    }

    @Step("Seleccionar género")
    public void seleccionarGenero(String genero) {
        WebElement generoLabel = getDriver().findElement(By.xpath("//label[text()='" + genero + "']"));
        clickSeguro(generoLabel);
    }

    @Step("Seleccionar hobby")
    public void seleccionarHobby(String hobby) {
        WebElement hobbyLabel = getDriver().findElement(By.xpath("//label[text()='" + hobby + "']"));
        clickSeguro(hobbyLabel);
    }

    @Step("Seleccionar estado y ciudad con espera adecuada")
    public void seleccionarEstadoYCiudad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        // Ocultar iframe para evitar interferencias
        js.executeScript(
                "let iframe = document.querySelector('iframe[id^=\"google_ads_iframe\"]'); if (iframe) { iframe.style.display = 'none'; }"
        );

        // Estado
        WebElement stateDropdown = find(By.id("state"));
        js.executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        stateDropdown.click();

        try { Thread.sleep(1000); } catch (InterruptedException e) { /* Ignorar */ }

        WebElement optionNCR = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='NCR']"))
        );
        js.executeScript("arguments[0].scrollIntoView(true);", optionNCR);
        optionNCR.click();

        try { Thread.sleep(1000); } catch (InterruptedException e) { /* Ignorar */ }

        // Ciudad
        WebElement cityDropdown = find(By.id("city"));
        js.executeScript("arguments[0].scrollIntoView(true);", cityDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));
        cityDropdown.click();

        try { Thread.sleep(500); } catch (InterruptedException e) { /* Ignorar */ }

        WebElement optionDelhi = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Delhi']"))
        );
        js.executeScript("arguments[0].scrollIntoView(true);", optionDelhi);
        optionDelhi.click();

        try { Thread.sleep(500); } catch (InterruptedException e) { /* Ignorar */ }
    }

    @Step("Enviar formulario")
    public void enviarFormulario() {
        WebElement submitBtn = getDriver().findElement(By.id("submit"));
        clickSeguro(submitBtn);
    }

    @Step("Obtener mensaje del modal")
    public String obtenerMensajeModal() {
        WebElementFacade modal = find(By.id("example-modal-sizes-title-lg"));
        return modal.getText();
    }

    @Step("Validar si el modal es visible")
    public boolean estaModalVisible() {
        List<WebElementFacade> modales = findAll(By.id("example-modal-sizes-title-lg"));
        if (modales.isEmpty()) {
            return false;
        }
        return modales.stream().anyMatch(WebElementFacade::isVisible);
    }

    @Step("Validar si el campo email muestra error")
    public boolean campoEmailConError() {
        WebElementFacade campoEmail = $("#userEmail");
        String borderColor = campoEmail.getCssValue("border-color");
        return borderColor.equals("rgb(220, 53, 69)"); // rojo
    }

    // Método para hacer clic seguro con Javascript y manejar excepciones
    public void clickSeguro(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));

        try {
            elemento.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", elemento);
        }
    }

    @Step("Validar que el formulario NO se envió (modal de éxito NO visible)")
    public void validarFormularioNoEnviado() {
        // Buscamos todos los elementos con id del modal
        List<WebElementFacade> modales = Serenity.getDriver().findElements(By.id("example-modal-sizes-title-lg"))
                .stream()
                .map(element -> (WebElementFacade) element)
                .toList();

        // Validamos que NO exista ningún modal visible
        boolean modalNoVisible = modales.isEmpty();

        Assert.assertTrue("El formulario se envió pero no debería haberse enviado", modalNoVisible);
    }
}