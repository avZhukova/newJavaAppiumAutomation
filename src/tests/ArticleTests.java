package tests;

import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {



    /*

Ex6: Тест: assert title
Написать тест, который открывает статью и убеждается, что у нее есть элемент title.
Важно: тест не должен дожидаться появления title, проверка должна производиться сразу.
Если title не найден - тест падает с ошибкой. Метод можно назвать assertElementPresent.

*/


    @Test
    public void testAssertTitle()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.assertThereTitleOfArticle();


    }


//-----------------------------------------------------------------------------------------------




    @Test

    public void testCompareArticleTitle()
    {




        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");


        ArticlePageObject ArticlePageObject = new   ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );

    }




    @Test

    public void testSwipeArticle()
    {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageObject ArticlePageObject = new   ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();



    }



}
