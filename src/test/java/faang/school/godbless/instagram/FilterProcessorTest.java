package faang.school.godbless.instagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
    private Image image;
    private FilterProcessor filterProcessor;
    private Function<Image, Image> monochromeFilter;
    private Function<Image, Image> rgbFilter;

    @BeforeEach
    public void setUp() {
        image = new Image("Image.jpg", "Green forest");
        filterProcessor = new FilterProcessor();
        monochromeFilter = (image) -> (new Image(image.getName() + "_grayscale", image.getDescription() + " Фильтр: черно-белый "));
        rgbFilter = (image) -> (new Image(image.getName() + "_RGB", image.getDescription() + " Фильтр: красно-зелено-голубой "));
    }

    @Test
    public void testApplyFilter() {
        Image grayscaleImage = filterProcessor.applyFilter(image, monochromeFilter);
        Image rgbImage = filterProcessor.applyFilter(image, rgbFilter);
        assertEquals(grayscaleImage.getName(), "Image.jpg_grayscale");
        assertEquals(rgbImage.getName(), "Image.jpg_RGB");
    }

    @Test
    public void testCombineFilters() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(monochromeFilter, rgbFilter);
        Image combinedImage = filterProcessor.applyFilter(image, combinedFilter);
        assertEquals(combinedImage.getName(), "Image.jpg_grayscale_RGB");
    }
}
