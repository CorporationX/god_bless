package school.faang.task_46304;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(
                image.name(),
                image.description() + " | Filter: black and white"
        );

        Function<Image, Image> sepiaFilter = (image) -> new Image(
                image.name(),
                image.description() + " | Filter: sepia"
        );

        Function<Image, Image> vignetteFilter = (image) -> new Image(
                image.name(),
                image.description() + " | Filter: vignette"
        );

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());

        Function<Image, Image> advancedFilter = filterProcessor.combineFilters(combinedFilter, vignetteFilter);
        Image advancedImage = filterProcessor.applyFilter(originalImage, advancedFilter);
        System.out.println(advancedImage.description());
    }
}