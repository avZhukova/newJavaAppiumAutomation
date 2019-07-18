package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.UI.ArticlePageObject;
import lib.UI.MyListsPageObject;
import lib.UI.NavigationUI;
import lib.UI.SearchPageObject;
import lib.UI.factories.ArticlePageObjectFactory;
import lib.UI.factories.MyListsPageObjectFactory;
import lib.UI.factories.NavigationUIFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests  extends CoreTestCase {



private static final  String name_of_folder = "Learning programming";

/*

Ex5: Тест: сохранение двух статей

    Написать тест, который:

    1. Сохраняет две статьи в одну папку
    2. Удаляет одну из статей
    3. Убеждается, что вторая осталась
    4. Переходит в неё и убеждается, что title совпадает

*/


    @Test
    public void testSaveTwoArticleMyList()
    {



        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject =  ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Island of Indonesia");
        ArticlePageObject.addArticleToMyListToFooter();
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
        SearchPageObject.waitForSearchResult("island of Indonesia");


    }




//-------------------------------------------------------------------------------------------


    @Test
    public void testSaveFirstArticleMyList()
    {




        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");


        ArticlePageObject ArticlePageObject =  ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();


        if(Platform.getInstance().isAndroid()){


            ArticlePageObject.addArticleToMyList(name_of_folder);

        } else {
ArticlePageObject.addArticlesToMySaved();


        }





        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);


        if (Platform.getInstance().isAndroid()){

            MyListsPageObject.openFolderByName(name_of_folder);

        }



        MyListsPageObject.swipeByArticleToDelete(article_title);



    }


}
