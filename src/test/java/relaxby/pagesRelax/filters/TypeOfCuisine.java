package relaxby.pagesRelax.filters;

import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public enum TypeOfCuisine {
  Восточная,
  Белорусская,
  Английская,
  Греческая,
  Китайская,
  Русская,
  Украинская,
  Японская;

  public void filters(String value) {
    String XPATH_txtFilter2 = "//*[@class='FilterSidebar__itemTitle' and text()='Кухня']/parent::*//*[@class='CompositeButtons__toggle']";
    ITextBox txtFilter2 = getElementFactory().getTextBox(By.xpath(XPATH_txtFilter2), "");
    txtFilter2.clickAndWait();
    getElementFactory().getTextBox(By.xpath("//*[text()='" + value + "']"), "Filters").clickAndWait();
  }

  @Override
  public String toString() {
    switch (this) {
      case Восточная:
        filters("Восточная");
        break;
      case Белорусская:
        filters("Белорусская");
        break;
      case Английская:
        filters("Английская");
        break;
      case Греческая:
        filters("Греческая");
        break;
      case Китайская:
        filters("Китайская");
        break;
      case Русская:
        filters("Русская");
        break;
      case Украинская:
        filters("Украинская");
        break;
      case Японская:
        filters("Японская");
        break;
    }
    return "TypeOfCuisine{}";
  }
}

