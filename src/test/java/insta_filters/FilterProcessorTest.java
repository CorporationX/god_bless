package insta_filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FilterProcessorTest {
    private Image originalImage;
    private FilterProcessor filterProcessor;

    @BeforeEach
    public void setUp() {
        originalImage = new Image("original.jpg", "Original image");
        filterProcessor = new FilterProcessor();
    }

    @Test
    public void applyFilter() {
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.fileName() + "_grayscale", "Filter: black and white");

        Image filteredImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);

        Assertions.assertEquals("original.jpg_grayscale", filteredImage.fileName());
        Assertions.assertEquals("Filter: black and white", filteredImage.description());

    }

    @Test
    public void combineFilter() {
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.fileName() + "_grayscale", "Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.fileName() + "_sepia", "Filter: sepia");

        Function<Image, Image> combinedFilter = filterProcessor.combineFilter(grayscaleFilter, sepiaFilter);
        Image filteredImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        Assertions.assertEquals("original.jpg_grayscale_sepia", filteredImage.fileName());
        Assertions.assertEquals("Filter: sepia", filteredImage.description());
    }
}