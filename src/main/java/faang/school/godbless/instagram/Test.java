package faang.school.godbless.instagram;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Filter: vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage);

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage);

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
