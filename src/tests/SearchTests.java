package tests;

import lib.CoreTestCase;
import lib.UI.SearchPageObject;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {





//---------------------------------------------------------------------------------

    /* Ex 3. Написать тест, который:

            1. Ищет какое-то слово
            2. Убеждается, что найдено несколько статей
            3. Отменяет поиск
            4. Убеждается, что результат поиска пропал */



    @Test

    public void testCancelSearchAndAmountOfEmptySearch()
    {



        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();


        assertTrue(
                "We found too few results!",
                amount_of_search_results > 0

        );

        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }


//---------------------------------------------------------------------------------







    @Test
    public void testSearch()
    {

        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }




    @Test

    public void testCancelSearch()
    {

        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);



        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }



    @Test

    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Linkin park discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();


        assertTrue(
                "We found too few results!",
                amount_of_search_results > 0

        );

    }


    @Test
    public void testAmountOfEmptySearch()
    {

        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "fghjhffj";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }




}
