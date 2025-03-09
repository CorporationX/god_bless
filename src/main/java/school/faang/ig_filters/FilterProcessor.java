package school.faang.ig_filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> func1, Function<Image, Image> func2) {
        return image -> {
            return func2.apply(func1.apply(image));

//          Image testImage1 = new Image(image.getName(), image.getDescription());
//          Image testImage2 = new Image(image.getName(), image.getDescription());
//          func1.apply(testImage1);
//          String resultsAfterFirstFiltering = testImage1.getDescription();
//          func2.apply(testImage2);
//          String resultsAfterSecondFiltering = testImage2.getDescription();
//          image.setDescription(resultsAfterFirstFiltering + "\n" + resultsAfterSecondFiltering);
//          return image;
//          };
        };
    }
}
