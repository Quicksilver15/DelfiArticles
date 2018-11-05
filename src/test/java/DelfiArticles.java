import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiArticles {
    private final By ARTICLE = By.xpath(".//a[@class = 'top2012-title']");
    private final By MOB_ARTICLE = By.xpath(".//a[@class = 'md-scrollpos']");
    private WebDriver browser;

    @Test
    public void compareArticles(){
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://rus.delfi.lv");
        List<WebElement> articles = browser.findElements(ARTICLE);
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");

        List<String> firstArticles = new ArrayList<String>();
        firstArticles.add("Поезд в аэропорт \"Рига\": билет будет дешевле, чем поездка на такси");
        firstArticles.add("Трагический пожар в Риге: полиция начала уголовный процесс");
        firstArticles.add("В Ригу вернулись блокираторы колес: все, что об этом надо знать");
        firstArticles.add("Вике-Фрейберга о нацменьшинствах: если сравнить с Турцией, то у нас все блестяще");
        firstArticles.add("Министр финансов Рейзниеце-Озола вышла из партии \"Латвии и Вентспилсу\"");

        browser.get("http://m.rus.delfi.lv");
        List<WebElement> mobArticles = browser.findElements(MOB_ARTICLE);
        Assertions.assertFalse(mobArticles.isEmpty(), "There is no articles");

        List<String> firstMobArticles = new ArrayList<String>();
        firstMobArticles.add("Поезд в аэропорт \"Рига\": билет будет дешевле, чем поездка на такси");
        firstMobArticles.add("Трагический пожар в Риге: полиция начала уголовный процесс");
        firstMobArticles.add("В Ригу вернулись блокираторы колес: все, что об этом надо знать");
        firstMobArticles.add("Вике-Фрейберга о нацменьшинствах: если сравнить с Турцией, то у нас все блестяще");
        firstMobArticles.add("Министр финансов Рейзниеце-Озола вышла из партии \"Латвии и Вентспилсу\"");

        for (int i = 0; i < 5; i++){
            Assertions.assertEquals(articles.get(i), mobArticles.get(i), "Articles are not equals");
        }
    }
    @AfterEach
    public void closeBrowser(){
        browser.close();
    }

}

