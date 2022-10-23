import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class dragAndDrop1 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        List<WebElement> capitals = driver.findElements(By.cssSelector("div[id='answerDiv']>div[id^='a']"));
        List<WebElement> boxes = driver.findElements(By.cssSelector("div[id='questionDiv']>div[id^='q']+div"));
        Actions islemler=new Actions(driver);

        for (WebElement sehir : capitals) {
            for (WebElement ulke : boxes) {
                islemler.moveToElement(sehir).clickAndHold().perform();
                Bekle(1);
                islemler.release(ulke).perform();
                if (sehir.getAttribute("class").contains("correct")) {
                    boxes.remove(ulke); break;
                }

            }
        }
        BekleKapat();
    }

    }











