package faang.school.godbless.sprint2.lambda.instagram.filters;

import java.util.function.Function;

public class Runner {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Create filters
        Function<Image, Image> grayscaleFilter = image -> new Image(image.filename() + "_grayscale", "Filter: grayscale");
        Function<Image, Image> sepiaFilter = image -> new Image(image.filename() + "_sepia", "Filter: sepia");
        Function<Image, Image> vignetteFilter = image -> new Image(image.filename() + "_vignette", "Filter: vignette");

        // Apply filters
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        // Create and apply a combined filter
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        System.out.println(combinedImage);
    }
}
