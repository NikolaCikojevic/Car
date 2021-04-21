package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.Helper;
import org.openqa.selenium.Keys;

public class CategoriesTest {
    
    private static WebDriver driver;
    
    public CategoriesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
       System.setProperty("webdriver.chrome.driver", "/home/nikola/Desktop/Workspace/chromedriver");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
        
        login();
    }
    
    @After
    public void tearDown() {
        
        logout();
    }

    private void login() {
        
       WebElement emailField = driver.findElement(By.name("email"));
       emailField.sendKeys("qa@cubes.rs");
        
       WebElement passwordField = driver.findElement(By.name("password"));
       passwordField.sendKeys("cubesqa");
        
       WebElement loginButton = driver.findElement(By.className("btn-primary"));
       loginButton.click();
    }
    
    private void logout() {
        
       WebElement dropDownLink = driver.findElement(By.className("dropdown-toggle"));
       dropDownLink.click();
        
       WebElement dropDownLoguot = driver.findElement(By.className("dropdown-menu"));
       dropDownLoguot.click();
    }
   
    @Test
    public void addNewCategory() throws InterruptedException {
        
       WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
       categoriesLink.click();
        
       WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
       addCategoryButton.click();
        
       WebElement titleField = driver.findElement(By.id("title"));
       String newCategorytitle = Helper.genereateTitle();
       titleField.sendKeys(newCategorytitle);
       
       WebElement saveButton = driver.findElement(By.id("save-category-button"));
       saveButton.click();
       
       String expectedResult = "Category \"" + newCategorytitle + "\" has been successfully saved!";
       String actualResult = driver.findElement(By.className("alert-success")).getText();
       
       assertTrue("Alert message is not correct.", expectedResult.equals(actualResult));
  
       String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
       String actualUrl = driver.getCurrentUrl();
       
       assertTrue("URLs doesnt match.", expectedUrl.equals(actualUrl));
       
    }
    
    @Test
    public void testCancelAddNewCategory() {
        
       WebElement emailField = driver.findElement(By.name("email"));
       emailField.sendKeys("qa@cubes.rs");

       WebElement passwordField = driver.findElement(By.name("password"));
       passwordField.sendKeys("cubesqa");

       WebElement loginButton = driver.findElement(By.className("btn-primary"));
       loginButton.click();

       WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
       categoriesLink.click();

       WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
       addCategoryButton.click();

       WebElement titleField = driver.findElement(By.id("title"));
       String newCategorytitle = Helper.genereateTitle();
       titleField.sendKeys(newCategorytitle);

       WebElement backButton = driver.findElement(By.id("back-button"));
       backButton.click();

       String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
       String actualUrl = driver.getCurrentUrl();

       assertTrue("URLs doesnt match.", expectedUrl.equals(actualUrl));

 } 

    @Test
    public void editDisableEnableDeleteButtons() throws InterruptedException {

       WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
       categoriesLink.click(); 

       WebElement editNikola963Button = driver.findElements(By.cssSelector("a.btn")).get(138);
       editNikola963Button.click();
       Thread.sleep(3000);

       WebElement editNikola963 = driver.findElement(By.id("title"));
       editNikola963.click();

       WebElement editValue = driver.findElement(By.id("title"));
       editValue.sendKeys(Keys.CONTROL + "a");
       editValue.sendKeys(Keys.DELETE);
       editValue.sendKeys("Daki26");
       Thread.sleep(3000);

       WebElement saveButton1 = driver.findElement(By.id("save-category-button"));
       saveButton1.click();
       Thread.sleep(3000);

       WebElement disableButtonNikola963 = driver.findElements(By.cssSelector("button")).get(271);
       disableButtonNikola963.click();
       Thread.sleep(3000);

       WebElement disableButtonDaki26 = driver.findElement(By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]"));
       disableButtonDaki26.click();

       WebElement disableButtonInPopUpDaki26 = driver.findElements(By.cssSelector("button")).get(271);
       disableButtonInPopUpDaki26.click();
       Thread.sleep(3000);

       WebElement enableButtonDaki26 = driver.findElement(By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[2]"));
       enableButtonDaki26.click();
       Thread.sleep(3000);

       WebElement deleteButtonDaki26 = driver.findElements(By.cssSelector("button")).get(272);
       deleteButtonDaki26.click();
       Thread.sleep(3000);
      
       WebElement cancelDeleteCloseButtonDaki26 = driver.findElement(By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[1]"));
       cancelDeleteCloseButtonDaki26.click();
       Thread.sleep(3000);
      
      
       
       
      //*[@id="categoryEnableDialog"]/div/div/div[3]/button[2]
//        Thread.sleep(3000);
//      WebElement confirmDisableButton = driver.findElement(By.className("btn-primary"))[286];
//      confirmDisableButton.click();
             

//      WebElement disableConfirm = driver.findElement
//      disableConfirm.click();

//      String master = "Nikola999";
//    String target = "Nikola999";
//    String replacement = "Daki26";
//    String processed = master.replace(target, replacement);
//    assertTrue(processed.contains(replacement));
//     assertFalse(processed.contains(target));
      
      
      
      
    }
}
 