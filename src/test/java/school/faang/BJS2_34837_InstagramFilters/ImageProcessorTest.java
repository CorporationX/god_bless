package school.faang.BJS2_34837_InstagramFilters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ImageProcessorTest {
    private ImageProcessor imageProcessor;

    @BeforeEach
    void setUp() {
        imageProcessor = new ImageProcessor();
    }

    @Test
    @DisplayName("Apply filter with null image")
    void testApplyFilterNullImage() {
        Function<Image, Image> blurFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: blur");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> imageProcessor.applyFilter(null, blurFilter)
        );
        assertEquals("Image can't be null!", exception.getMessage());
    }

    @Test
    @DisplayName("Apply filter with null filter")
    void testApplyFilterNullFilter() {
        Image image = new Image("image.jpg", "original image!!!");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> imageProcessor.applyFilter(image, null)
        );
        assertEquals("Invalid image filter!", exception.getMessage());
    }

    @Test
    @DisplayName("Apply filter with valid image and filter")
    void testApplyFilterValidData() {
        String description = "original sea image!!!";
        String expectedDescription = "original sea image!!!" + " | Filter: blur";
        Image seaImage = new Image("sea.jpg", description);
        Function<Image, Image> blurFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: blur");

        Image seaImageBlur = imageProcessor.applyFilter(seaImage, blurFilter);
        assertEquals(expectedDescription, seaImageBlur.getDescription());
    }

    @Test
    @DisplayName("Combine filters with null first filter")
    void testCombineFiltersNullFirstFilter() {
        Function<Image, Image> blurFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: blur");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> imageProcessor.combineFilters(null, blurFilter)
        );
        assertEquals("Invalid first image filter!", exception.getMessage());
    }

    @Test
    @DisplayName("Combine filters with null second filter")
    void testCombineFiltersNullSecondFilter() {
        Function<Image, Image> blurFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: blur");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> imageProcessor.combineFilters(blurFilter, null)
        );
        assertEquals("Invalid second image filter!", exception.getMessage());
    }

    @Test
    @DisplayName("Combine filters with valid two filters")
    void testApplyFilterValidFilters() {
        String description = "original sea image!!!";
        String expectedDescription = "original sea image!!!" + " | Filter: blur" + " | Filter: vintage";
        Image seaImage = new Image("sea.jpg", description);
        Function<Image, Image> blurFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: blur");
        Function<Image, Image> vintageFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: vintage");
        Function<Image, Image> blurVintageFilter = imageProcessor.combineFilters(blurFilter, vintageFilter);

        Image seaImageBlurVintage = imageProcessor.applyFilter(seaImage, blurVintageFilter);
        assertEquals(expectedDescription, seaImageBlurVintage.getDescription());
    }
}