package relaxby.pagesRelax.filters;

import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public enum TakeawayFood {
  Да,
  Нет;

  public void filters(String value) {
    String XPATH_txtFilter3 = "//*[@class='ToggleSwitch__text' and text()='Еда навынос']/parent::*//*[@class='ToggleSwitch__slider']";
    ITextBox txtFilter3 = getElementFactory().getTextBox(By.xpath(XPATH_txtFilter3), "");
    switch (value) {
      case ("Да"):
        txtFilter3.clickAndWait();
        break;
      case ("Нет"):
        break;
    }
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
    return "TakeawayFood{}";
  }
}

