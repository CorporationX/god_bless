package faang.school.godbless.sprint3.instagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    private FilterProcessor filterProcessor;
    private Image originalImage;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;
    private Function<Image, Image> vignetteFilter;
    private Function<Image, Image> combinedFilter;

    @BeforeEach
    void setImageFilterProcessorAndFilters() {
        originalImage = new Image("original.jpg", "Оригинальное изображение");
        filterProcessor = new FilterProcessor();

        grayscaleFilter = (image) -> new Image(
                image.getName() + "_grayscale", "Фильтр: черно-белый"
        );
        sepiaFilter = (image) -> new Image(
                image.getName() + "_sepia", "Фильтр: сепия"
        );
        vignetteFilter = (image) -> new Image(
                image.getName() + "_vignette", "Фильтр: виньетка"
        );
        combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
    }

    @Test
    void applyFilter_ShouldApplyGrayscaleFilter() {
        originalImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);

        assertEquals("original.jpg_grayscale", originalImage.getName());
        assertEquals("Фильтр: черно-белый", originalImage.getDescription());
    }

    @Test
    void applyFilter_ShouldApplySepiaFilter() {
        originalImage = filterProcessor.applyFilter(originalImage, sepiaFilter);

        assertEquals("original.jpg_sepia", originalImage.getName());
        assertEquals("Фильтр: сепия", originalImage.getDescription());
    }

    @Test
    void applyFilter_ShouldApplyVignetteFilter() {
        originalImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        assertEquals("original.jpg_vignette", originalImage.getName());
        assertEquals("Фильтр: виньетка", originalImage.getDescription());
    }

    @Test
    void combineFilters_ShouldApplyCombinedFilter() {
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertEquals("original.jpg_grayscale_sepia", combinedImage.getName());
        assertEquals("Фильтр: сепия", combinedImage.getDescription());
    }
}