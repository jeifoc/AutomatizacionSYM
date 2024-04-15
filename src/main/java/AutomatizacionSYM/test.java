package AutomatizacionSYM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        WebElement user = driver.findElement(By.id("vtbUsuario"));
        user.sendKeys("ecarpioe");

        WebElement password = driver.findElement(By.id("tbPassword"));
        password.sendKeys("Siged2025$");

        WebElement loginButton = driver.findElement(By.cssSelector("#submitPreLoginBtn_label"));
        loginButton.click();

        //Crear un nuevo expediente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement nuevoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Nuevo")));
        nuevoButton.click();


        //Seleccionar el tipo de proceso
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement procesoInput = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='objDocumento.expediente.proceso.idproceso']")));
        procesoInput.sendKeys("OSINERGMIN-Comunicaciones Externas");
        try {
            Thread.sleep(2000);
            procesoInput.sendKeys(Keys.DOWN);
            procesoInput.sendKeys(Keys.ENTER);
        } catch (Exception e){
            System.out.println("No se elegió a quién enviar");
        }



        //Seleccionar el usuario en el campo Enviar a
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement enviarA = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='objDD.iIdDestinatario']")));
        enviarA.sendKeys("Carpio Escalante, Enrique Daniel");
        try {
            Thread.sleep(3000);
            enviarA.sendKeys(Keys.DOWN);
            enviarA.sendKeys(Keys.ENTER);
        } catch (Exception e){
            System.out.println("No se elegió a quién enviar");
        }

        //Seleccionar el tipo de documento
        WebElement tipoDocumento = driver.findElement(By.xpath("//input[@id='objDocumento.tipoDocumento.idtipodocumento']"));
        tipoDocumento.sendKeys("OFICIO IPAS");
        try {
            Thread.sleep(3000);
            tipoDocumento.sendKeys(Keys.DOWN);
            tipoDocumento.sendKeys(Keys.ENTER);
        } catch (Exception e){
            System.out.println("No se elegió el tipo de documento");
        }

        //Ingresar el asunto
        WebElement asunto = driver.findElement(By.xpath("//textarea[@id='objDD.strAsunto']"));
        asunto.sendKeys("PRUBA SYM");

        //Ingresar el cliente
        WebElement buscarClienteButton = driver.findElement(By.xpath("//span[@id='btnBusquedaCliente_label']"));
        buscarClienteButton.click();
        WebElement filtroBuscarCliente = driver.findElement(By.xpath("//input[@id='txtFiltroBusquedaCliente']"));
        filtroBuscarCliente.sendKeys("OSINERGMIN");

        WebElement filtrarButton = driver.findElement(By.id("btnBuscar_label"));
        filtrarButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actions = new Actions(driver);
        for (int i = 0; i <= 4; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();


        //Subir el OFICIO IPAS
        WebElement btnFileUpload = driver.findElement(By.xpath("//input[@type='file']"));
        btnFileUpload.sendKeys("D:\\SYM\\Documentos de prueba SYM\\Oficio IPAS - Prueba.docx");

        //Registrar documento

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement registrarDocumento = wait4.until(ExpectedConditions.(By.xpath("//span[@id='btnRegistrarDocumentoBottom_label']")));
        registrarDocumento.click();

    }
}

