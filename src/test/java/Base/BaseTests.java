package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;

    public void setDriver() {
        try {
            System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
            driver = new EdgeDriver();
//            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("http://192.168.11.185/");
            System.out.println(driver.getTitle());
            pageAction();
            driver.quit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void pageAction(){

        try {
            driver.findElement(By.linkText("Nidle/")).click();
            Thread.sleep(10000);
            driver.findElement(By.id("userEmail")).sendKeys("Admin");
//            Thread.sleep(2000);
            driver.findElement(By.id("input-password")).sendKeys("admin");

            driver.findElement(By.xpath("/html/body/ngx-app/ngx-login/nb-layout/div/div/div/div/div/nb-layout-column/ngx-auth-login/section/div[1]/div/div[2]/div/div[1]/div/form/div[6]/button")).click();
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setDriver();
    }
}
