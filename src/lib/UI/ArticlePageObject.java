package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }


    private static final String

            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            TITLE = "org.wikipedia:id/view_page_title_text",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            ADD_TO_FOOTER_ELEMENT = "org.wikipedia:id/item_container",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";


    public WebElement waitForTitleElement() {

        return this.waitForElementPresent(By.id(TITLE),
                "Cannot find article title on page!", 15);

    }

    public String getArticleTitle() {


        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");

    }


    public void swipeToFooter() {

        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT), "Cannot find the end ot the article", 20

        );


    }

    public void addArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find search Wikipedia input",
                5


        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5
        );


        this.waitForElementAndClick(By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find it tip overlay",
                5

        );

        this.waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot find input to set name ot articles folder",
                5

        );


        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );


        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5

        );
    }


    public void addArticleToMyListToFooter() {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find search Wikipedia input",
                5


        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5
        );


        this.waitForElementAndClick(By.id(ADD_TO_FOOTER_ELEMENT),
                "Cannot find it tip overlay",
                5

        );


    }


    public void closeArticle() {


        this.waitForElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot find article, cannot find X link",
                10
        );


    }


    public void assertThereTitleOfArticle() {

        this.assertElementPresent(
                By.id(TITLE),
                "We did not find results for " + TITLE

        );


    }

}
