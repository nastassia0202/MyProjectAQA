package relaxby.pagesRelax.filters;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Filter {

  private District district;
  private TypeOfCuisine typeOfCuisine;
  private TakeawayFood takeawayFood;
  private TakeawayMenu takeawayMenu;

}

