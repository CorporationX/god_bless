package school.faang.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image)
                -> new Image(image.name(), image.description() + " | Filter: black-white");
        Function<Image, Image> sepiaFilter = (image)
                -> new Image(image.name(), image.description() + " | Filter: sepia");
        Function<Image, Image> vignetteFilter = (image)
                -> new Image(image.name(), image.description() + " | Filter: vignatte");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Function<Image, Image> combinedFilter1 = filterProcessor.combineFilters(grayscaleFilter, vignetteFilter);
        Image combinedImage1 = filterProcessor.applyFilter(originalImage, combinedFilter1);
        System.out.println(combinedImage1.description());
    }
}