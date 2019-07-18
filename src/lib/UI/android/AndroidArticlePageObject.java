package lib.UI.android;

import io.appium.java_client.AppiumDriver;
import lib.UI.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {



   static {

               TITLE = "id:org.wikipedia:id/view_page_title_text";
               FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
               OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
               OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
               ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
               MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
               MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
               ADD_TO_FOOTER_ELEMENT = "id:org.wikipedia:id/item_container";
               CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";
   }




    public AndroidArticlePageObject(AppiumDriver driver){

    super(driver);

}



}
