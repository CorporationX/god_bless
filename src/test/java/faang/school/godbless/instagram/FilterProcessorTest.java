package faang.school.godbless.instagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    private static final String ORIGINAL_NAME = "original.jpg";
    private static final String GRAYSCALE = "_grayscale";
    private static final String SEPIA = "_sepia";
    private static final String VIGNETTE = "_vignette";
    private static final String GRAYSCALE_DESC = "Фильтр: черно-белый";
    private static final String SEPIA_DESC = "Фильтр: сепия";
    private static final String VIGNETTE_DESC = "Фильтр: виньетка";
    private Image originalImage;
    private FilterProcessor filterProcessor;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;
    private Function<Image, Image> vignetteFilter;

    @BeforeEach
    void setup() {
        originalImage = new Image(ORIGINAL_NAME, "Оригинальное изображение");

        filterProcessor = new FilterProcessor();

        grayscaleFilter = (image) -> new Image(image.getName() + GRAYSCALE, GRAYSCALE_DESC);
        sepiaFilter = (image) -> new Image(image.getName() + SEPIA, SEPIA_DESC);
        vignetteFilter = (image) -> new Image(image.getName() + VIGNETTE, VIGNETTE_DESC);
    }

    @Test
    public void applyFilterTest() {
        assertAll(
            () -> {
                Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
                assertEquals(ORIGINAL_NAME + GRAYSCALE, grayscaleImage.getName());
                assertEquals(GRAYSCALE_DESC, grayscaleImage.getDescription());
            },
            () -> {
                Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
                assertEquals(ORIGINAL_NAME + SEPIA, sepiaImage.getName());
                assertEquals(SEPIA_DESC, sepiaImage.getDescription());
            },
            () -> {
                Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
                assertEquals(ORIGINAL_NAME + VIGNETTE, vignetteImage.getName());
                assertEquals(VIGNETTE_DESC, vignetteImage.getDescription());
            }
        );
    }

    @Test
    public void combineFiltersTest() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertAll("combineFilters",
            () -> assertEquals(ORIGINAL_NAME + GRAYSCALE + SEPIA, combinedImage.getName()),
            () -> assertEquals(SEPIA_DESC, combinedImage.getDescription())
        );
    }
}