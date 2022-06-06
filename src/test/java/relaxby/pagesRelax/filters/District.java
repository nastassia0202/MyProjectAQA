package relaxby.pagesRelax.filters;

import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public enum District {
  Заводской,
  Ленинский,
  Московский,
  Октябрьский,
  Советский,
  Фрунзенский,
  Центральный,
  НеВыбрано;

  private void filters(String value) {
    String XPATH_txtFilter1 = "//*[@class='FilterSidebar__itemTitle' and text()='Район']/parent::*//*[@class='Icon Icon--menu']";
    ITextBox txtFilter1 = getElementFactory().getTextBox(By.xpath(XPATH_txtFilter1), "");
    txtFilter1.clickAndWait();
    getElementFactory().getTextBox(By.xpath("//*[text()='" + value + "']"), "Filters").clickAndWait();
  }


  @Override
  public String toString() {
    switch (this) {
      case Заводской:
        filters("Заводской");
        break;
      case Ленинский:
        filters("Ленинский");
        break;
      case Московский:
        filters("Московский");
        break;
      case Октябрьский:
        filters("Октябрьский");
        break;
      case Советский:
        filters("Советский");
        break;
      case Фрунзенский:
        filters("Фрунзенский");
        break;
      case Центральный:
        filters("Центральный");
        break;
      default:
        filters("Не Выбрано");
        break;
    }
    return "District{}";
  }
}
