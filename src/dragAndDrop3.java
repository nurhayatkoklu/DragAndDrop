import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class dragAndDrop3 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        List<WebElement> sehirler=driver.findElements(By.cssSelector("[id='allItems']>[id^='node']"));
        List<WebElement> ulkeler=driver.findElements(By.cssSelector("[id^='box']"));
        Actions islemler=new Actions(driver);

        for (WebElement sehir : sehirler){
            for (WebElement ulke : ulkeler) {
                islemler.moveToElement(sehir).clickAndHold().perform();
                Bekle(1);
                islemler.release(ulke).perform();
                if (sehir.getAttribute("class").contains("correct")) {
                    break; }

            }
        }
        driver.switchTo().alert().accept();
        BekleKapat();
    }
}
