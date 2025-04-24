package school.faang.instagram_filters;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Image originalImage = new Image("Sea2004", "Sea");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> noRedEyes = image ->
                new Image(image.getName(), image.getDescription() + " |remove red eyes");
        Function<Image, Image> blackWhite = image ->
                new Image(image.getName(), image.getDescription() + " |remove colors");

        Image noColorImage = filterProcessor.applyFilter(originalImage, blackWhite);
        System.out.println(noColorImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(noRedEyes, blackWhite);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
