package school.faang.godbless.bjs2_34693;

import java.util.function.Function;

public class FilterProcessor {

  public Image applyFilter(Image image, Function<Image, Image> filter) {
    return filter.apply(image);
  }

  public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
    return img -> filter2.apply(filter1.apply(img));
  }
}
