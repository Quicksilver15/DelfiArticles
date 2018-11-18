import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class DelfiArticleTest3 {
    private final By WEB_ARTICLE = By.xpath(".//a[@class = 'text-mine-shaft']");
    private final By MOB_ARTICLE = By.xpath(".//a[@class = 'md-scrollpos']");
    private WebDriver browser;
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final String MOB_HOME_PAGE = "http://m.rus.delfi.lv";

    @Test
    public void compareArticles() {
        List<String> articleTitle = new ArrayList<String>();
        articleTitle.add("Прямой эфир: На Набережной в ожидании салюта собрались десятки тысяч человек");
        articleTitle.add("ВИДЕО: военный парад, посвященный 100-летию провозглашения независимости Латвии");
        articleTitle.add("Грибаускайте не смогла вылететь в Ригу на 100-летие независимости Латвии");
        articleTitle.add("Вейонис: мы готовы защищать свою страну и народ");
        articleTitle.add("ФОТО, ВИДЕО: В центре Риги прошло грандиозное факельное шествие");

        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE);
        List<WebElement> webArticles = browser.findElements(WEB_ARTICLE);
        Assertions.assertFalse(webArticles.isEmpty(), "There is no articles");

        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(articleTitle.get(i), webArticles.get(i).getText(),"This is not true article");
        }

        browser.get(MOB_HOME_PAGE);
        List<WebElement> mobArticles = browser.findElements(MOB_ARTICLE);
        Assertions.assertFalse(mobArticles.isEmpty(), "There is no articles");

        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(articleTitle.get(i), mobArticles.get(i).getText(),"This is not true article");
        }

        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(webArticles.get(i).getText(), mobArticles.get(i).getText(), "Articles Nr." + (i + 1) + " are not equals");
        }

    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

}
