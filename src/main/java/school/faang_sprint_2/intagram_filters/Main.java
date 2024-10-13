package school.faang_sprint_2.intagram_filters;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        var originalImage = new Image("original.jpg", "Original Image");
        var filterProcessor = new FilterProcessor();


        Function<Image, Image> grayscaleFilter =
                image -> new Image(image.name(), image.description() + " | Filter: Black-White");
        Function<Image, Image> sepiaFilter =
                image -> new Image(image.name(), image.description() + " | Filter: Sepia");
        Function<Image, Image> valenciaFilter = image -> new Image(image.name(), image.description() + " | Filter: Valencia");

        var grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        var sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(valenciaFilter, grayscaleFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
    }
}
