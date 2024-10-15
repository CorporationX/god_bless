package school.faang.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Original Image
        Image originalImage = new Image("original.jpg", "Original Image");

        // Create FilterProcessor instance
        FilterProcessor filterProcessor = new FilterProcessor();

        // Define Filters using lambdas
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: Grayscale");

        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: Sepia");

        // Apply grayscale filter
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        // Output: Original Image | Filter: Grayscale

        // Apply sepia filter to the grayscale image
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        // Output: Original Image | Filter: Grayscale | Filter: Sepia

        // Combine filters and apply them
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
        // Output: Original Image | Filter: Grayscale | Filter: Sepia
    }
}
