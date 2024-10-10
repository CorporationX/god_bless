package school.faang.filtersforinstagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();

// Filters
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(), image.description() + " | Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(), image.description() + " | Filter: sepia");

// Apply filters
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description()); // Output: Original image | Filter: black and white

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description()); // Output: Original image | Filter: black and white | Filter: sepia

// Combine filters
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description()); // Output: Original image | Filter: black and white | Filter: sepia
    }
}