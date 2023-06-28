package LambdaStream.bc895;

import java.util.function.Function;

public class FilterProcessor {

   public Image applyFilter(Image image, Function<Image, Image> function) {
      return function.apply(image);
   }

   public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
      return filterOne.andThen(filterTwo);
   }
}
