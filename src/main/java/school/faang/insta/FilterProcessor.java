package school.faang.insta;

import java.util.function.Function;

public class FilterProcessor {

  public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
    return imageFunction.apply(image);
  }

  public Function<Image, Image> combineFilter(Function<Image, Image> firstFunction,
      Function<Image, Image> secondFunction) {
    return firstFunction.andThen(secondFunction);
  }
}
