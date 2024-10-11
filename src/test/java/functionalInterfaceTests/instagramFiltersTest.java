package functionalInterfaceTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.functionalInterface.instagramFilters.FilterProcessor;
import school.faang.functionalInterface.instagramFilters.Image;

import java.util.function.Function;

public class instagramFiltersTest {

    @Test
    public void filtersTest() {
        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Filter: Black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Filter: Sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        Assertions.assertEquals("Original image | Filter: Black and white", grayscaleImage.getDescription());
        Assertions.assertEquals("Original image | Filter: Black and white | Filter: Sepia", sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Assertions.assertEquals("Original image | Filter: Black and white | Filter: Sepia", combinedImage.getDescription());
    }
}
