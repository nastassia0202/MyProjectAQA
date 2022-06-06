package relaxby.test;

import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import relaxby.pagesRelax.filters.District;
import relaxby.pagesRelax.filters.Filter;
import relaxby.pagesRelax.filters.TakeawayFood;
import relaxby.pagesRelax.filters.TakeawayMenu;
import relaxby.pagesRelax.filters.TypeOfCuisine;
import relaxby.pagesRelax.pages.CatalogPage;
import relaxby.pagesRelax.pages.HomePage;
import relaxby.pagesRelax.pages.SearchPage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class RelaxTests {

  HomePage homePage = new HomePage();
  SearchPage searchPage = new SearchPage();
  CatalogPage catalogPage = new CatalogPage();

  @Test
  public void searchTest() {
    String title = "Luna";
    String typeOfInstitution = "Рестобар";
    getBrowser().getDriver().manage().window().maximize();
    homePage.openHomePage();
    homePage.inputInSearchBox(title);
    String actualAddress = homePage.getAddressInstitution(title, typeOfInstitution);
//        String actualWorkingHours = "до 00:00";
    String actualWorkingHours = homePage.getWorkingHours(title, typeOfInstitution);
    String actualPhone = "+375 29 333-00-74";
    homePage.openPageWithExpectedResult(title, typeOfInstitution);
    Assert.assertEquals(actualAddress, searchPage.addressOnThePage());
    Assert.assertEquals(actualPhone, searchPage.phoneNumberOnThePage());
    Assert.assertTrue(actualWorkingHours.equals(searchPage.workingHoursOnThePage()));
    getBrowser().getDriver().quit();
  }

  @Test
  public void filtersValidationTest() throws InterruptedException {
    String categoryFromMenu = "Еда";
    String typeOfInstitution = "Рестораны";
    getBrowser().getDriver().manage().window().maximize();
    homePage.openHomePage();
    homePage.selectMenuCategory(categoryFromMenu, typeOfInstitution);
    catalogPage.openFilter();
    Filter filter = Filter.builder()
        .district(District.Заводской)
        .typeOfCuisine(TypeOfCuisine.Белорусская)
        .takeawayFood(TakeawayFood.Да)
        .takeawayMenu(TakeawayMenu.Да)
        .build();
    filter.toString();
//        catalogPage.filters("Район", "Заводской");
//        catalogPage.filters("Кухня", "Белорусская");
//        catalogPage.filters("Еда навынос", "Да");
//        catalogPage.filters("Меню навынос", "Да");
    Thread.sleep(1000);
    catalogPage.applyFilterAndShowResult();
    String productLink = catalogPage.getProductLinkFromSearchList("1");
    Thread.sleep(1000);
    getBrowser().goTo(productLink);
    Assert.assertEquals(searchPage.titleDeliveryBox(), "Заказать еду");
    searchPage.showMoreParamsInContentBox();
    Assert.assertTrue(searchPage.foo(searchPage.checkFilterValue("Район"), "Заводской"));
    Assert.assertTrue(searchPage.foo(searchPage.checkFilterValue("Кухня"), "Белорусская"));
    Thread.sleep(3000);
    getBrowser().getDriver().quit();
  }


  @Test
  public void posterValidationTest() throws InterruptedException {
    getBrowser().getDriver().manage().window().maximize();
    homePage.openHomePage();
    homePage.selectMenuCategory("Афиша, кино");
    String productLink = catalogPage.getProductLinkFromSearchListAfisha("2");
    Thread.sleep(1000);
    getBrowser().goTo(productLink);
    ITextBox feedbacksIcon = getElementFactory().getTextBox(By.xpath("//*[contains(@class, \"js-feedbacks b-feedbacks\")]"), "");
    Assert.assertTrue(feedbacksIcon.getElement().isDisplayed());
    getBrowser().getDriver().quit();
  }
}

