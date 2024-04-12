package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

public class test {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","D:\\Automatizacion\\Driver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://srvcertsiged.osinergmin.gob.pe/siged/login.action");

        driver.manage().window().maximize();

        //Ingresar usuario y contraseña
        WebElement inputUser = driver.findElement(By.id("vtbUsuario"));
        inputUser.sendKeys("ecarpioe");

        WebElement inputPassword = driver.findElement(By.id("tbPassword"));
        inputPassword.sendKeys("Siged2025$");

        WebElement loginButton = driver.findElement(By.cssSelector("#submitPreLoginBtn_label"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement nuevoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Nuevo")));
        nuevoButton.click();

        WebElement procesoInput = driver.findElement(By.id("objDocumento.expediente.proceso.idproceso"));
        procesoInput.sendKeys("COMUNICACIONES EXTERNAS");

    }
}

