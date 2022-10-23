import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class dragAndDrop4 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        List<WebElement> sehirler = driver.findElements(By.cssSelector("[class='dragableBox'][id^='box']"));
        List<WebElement> ulkeler = driver.findElements(By.cssSelector("[class='dragableBoxRight'][id^='box']"));
        Actions islemler=new Actions(driver);

        for (WebElement sehir : sehirler) {
            for (WebElement ulke : ulkeler) {
                islemler.clickAndHold(sehir).moveToElement(ulke).release().build().perform();
                Bekle(1);

                if (sehir.getAttribute("style").contains("background-color")) break;

                }

            }
            BekleKapat();

        }



        }








