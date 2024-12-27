package filters_Instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image originalImage = new Image( "my cute dog","Original Image");

        Image imageBlackWhite = filterProcessor.applyFilter(originalImage,filterProcessor.BlackWhite);
        System.out.println(imageBlackWhite.getDescription());

        Function<Image,Image> sepiaBlackWhiteFilter =filterProcessor.combineFilters(filterProcessor.sepia,filterProcessor.BlackWhite);
        Image combineImageFilters = filterProcessor.applyFilter(originalImage,sepiaBlackWhiteFilter);
        System.out.println(combineImageFilters.getDescription());
    }
}
