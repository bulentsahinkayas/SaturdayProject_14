import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Project_14 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", MyConstant.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();
        driver.findElement(By.id("session_email")).sendKeys("bsahin@hotmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Atlanta");
        driver.findElement(By.cssSelector("#clearance > div > div > form > div:nth-child(5) > input")).click();
        driver.findElement(By.cssSelector("#navbar > div.navbar-nav.mr-auto > a:nth-child(2)")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector("body > div > a")).click();
        driver.findElement(By.id("address_first_name")).sendKeys("Fernando");
        driver.findElement(By.id("address_last_name")).sendKeys("Torres");
        driver.findElement(By.id("address_street_address")).sendKeys("Anfield Rd");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Anfield");
        driver.findElement(By.id("address_city")).sendKeys("Liverpool");
        driver.findElement(By.cssSelector("#address_state [value=GA]")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("L4 0TH");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("03/20/1984");
        driver.findElement(By.id("address_age")).sendKeys("36");
        driver.findElement(By.id("address_website")).sendKeys("https://www.google.com/");
        driver.findElement(By.id("address_phone")).sendKeys("8625747878");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();
        driver.findElement(By.id("address_note")).sendKeys("Never Back Down");
        driver.findElement(By.cssSelector("#new_address > div.form-group.row.justify-content-center > input")).click();

        String name = driver.findElement(By.xpath("/html/body/div/p[1]/span[2]")).getText();
        System.out.println(name);
        if(!name.equals("Fernando")){
            throw new Exception("Expected: Fernando, Actual: " + name);
        }
        String lastName = driver.findElement(By.xpath("/html/body/div/p[2]/span[2]")).getText();
        System.out.println(lastName);
        if(!lastName.equals("Torres")){
            throw new Exception("Expected: Torres, Actual: " + lastName);
        }

        driver.findElement(By.cssSelector("#navbar > div.navbar-nav.mr-auto > a:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.container>table>tbody>tr:nth-child(1)>td:nth-child(6)>a")).click();
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys("Peter");

        driver.findElement(By.id("address_last_name")).clear();
        driver.findElement(By.id("address_last_name")).sendKeys("Crouch");
        driver.findElement(By.cssSelector("form.edit_address> div.form-group.row.justify-content-center > input")).click();
        System.out.println();
        name = driver.findElement(By.xpath("/html/body/div/p[1]/span[2]")).getText();
        System.out.println(name);
        if(!name.equals("Peter")){
            throw new Exception("Expected: Peter, Actual: " + name);
        }
        lastName = driver.findElement(By.xpath("/html/body/div/p[2]/span[2]")).getText();
        System.out.println(lastName);
        if(!lastName.equals("Crouch")){
            throw new Exception("Expected: Crouch, Actual: " + lastName);
        }

        driver.findElement(By.cssSelector("body > div > div.row.justify-content-center > a:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.container>table>tbody>tr>td:nth-child(7)>a")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        String removingText = driver.findElement(By.cssSelector("body > div > div")).getText();
        System.out.println(removingText);
    }

}
 /*/html/body/div/p[1]/span[2]
    NOTE: Create your own account in the website http://a.testaddressbook.com/sign_in manually
          before you start your automation. I suggest you to use a fake email address. This is just for testing.



        Verify if the first name is "Fernando"

        Verify if the last name is "Torres"

        Click on Addresses

        Click on Edit button

        Change the first name as "Peter"

        Change the last name as "Crouch"

        Click on Update address

        Verify if the first name is "Peter"

        Verify if the last name is "Crouch"

        Click on Addresses

        Click on Destroy

        Verify if the address was removed

        Close the browser

        NOTE: For verifications, use if-else statements.
     */