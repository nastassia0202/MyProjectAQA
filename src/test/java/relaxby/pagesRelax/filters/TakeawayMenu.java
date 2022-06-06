package relaxby.pagesRelax.filters;

import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public enum TakeawayMenu {
  Да,
  Нет;

  public void filters(String value) {
    String XPATH_txtFilter4 = "//*[@class='FilterSidebar__itemTitle' and text()='Меню навынос']/parent::*//*[@class='CheckButton__span' and text()='"+value+"']";
    ITextBox txtFilter4 = getElementFactory().getTextBox(By.xpath(XPATH_txtFilter4), "");
    txtFilter4.clickAndWait();
  }

  @Override
  public String toString() {
    switch (this) {
      case Нет:
        filters("Нет");
        break;

      case Да:
        filters("Да");
        break;
    }
    return "TakeawayMenu{}";
  }
}

