package onliner.test;

import onliner.pagesOnliner.CartMenuPage;
import onliner.pagesOnliner.HomePage;
import onliner.pagesOnliner.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class OnlinerShoppingTest {

  private final String productTitle = "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)";
  HomePage homePage = new HomePage();
  ProductPage productPage = new ProductPage();
  CartMenuPage cartMenuPage = new CartMenuPage();

  @Test
  public void shoppingTest() throws InterruptedException {
    getBrowser().getDriver().manage().window().maximize();
    homePage.openHomePage();
    homePage.findProduct(productTitle);
    homePage.getProductPageFromSearchList("1");
    Assert.assertEquals(productPage.getProductTitle(), productTitle);
    productPage.isDisplayedDescriptionLabel();
//    String price = productPage.getTxtPrice();
    productPage.showMorePrices();
    productPage.addToCartProductWithMinPrice();
//        Assert.assertEquals(productPage.addToCartProductWithMinPrice(), price);
    Thread.sleep(5000);
    productPage.openCartPage();
    cartMenuPage.deleteProductFromCart(productTitle);
    cartMenuPage.checkTheCartIsEmpty();
    getBrowser().getDriver().quit();
  }
}
