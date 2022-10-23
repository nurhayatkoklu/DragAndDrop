import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class dragAndDrop2 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        List<WebElement> studentlist=driver.findElements(By.cssSelector("[id=allItems]>[id^='node']"));
        WebElement teamA=driver.findElement(By.cssSelector("[id='box1']"));
        WebElement teamB=driver.findElement(By.cssSelector("[id='box2']"));
        WebElement teamC=driver.findElement(By.cssSelector("[id='box3']"));
        WebElement teamD=driver.findElement(By.cssSelector("[id='box4']"));
        WebElement teamE=driver.findElement(By.cssSelector("[id='box5']"));

        yerlestir(studentlist, teamA, 4 );
        yerlestir(studentlist, teamB, 4);
        yerlestir(studentlist, teamC, 4);
        yerlestir(studentlist, teamD, 3);
        yerlestir(studentlist, teamE, 6);
        if (studentlist.isEmpty()) System.out.println("Congrats!");
        else System.out.println("Failed!");

        BekleKapat();
    }
    public static void yerlestir (List<WebElement> studentList, WebElement team, int teamSize )
    {
        int counter=0;
        Actions islemler=new Actions(driver);
        while (counter < teamSize) {

            islemler.moveToElement(studentList.get(0)).clickAndHold().perform();
            Bekle(1);
            islemler.release(team).perform();
            studentList.remove(0);
            counter++;
        }
    }
}
