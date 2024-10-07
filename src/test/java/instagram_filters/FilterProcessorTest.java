package instagram_filters;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    private final Image IMAGE = new Image("original.png", "This is original.png");
    private final FilterProcessor FILTER_PROCESSOR = new FilterProcessor();

    private final Function<Image, Image> GRAYSCALE_FILTER = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
    private final Function<Image, Image> SEPIA_FILTER = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

    @Test
    void applyFilter() {
        Image editedImage = FILTER_PROCESSOR.applyFilter(IMAGE, GRAYSCALE_FILTER);

        assertEquals("original.png", editedImage.getName());
        assertEquals("This is original.png | Фильтр: черно-белый", editedImage.getDescription());
    }

    @Test
    void combineFilters() {
        Function<Image, Image> newFilter = FILTER_PROCESSOR.combineFilters(GRAYSCALE_FILTER, SEPIA_FILTER);
        Image editedImage = FILTER_PROCESSOR.applyFilter(IMAGE, newFilter);

        assertEquals("original.png", editedImage.getName());
        assertEquals("This is original.png | Фильтр: сепия | Фильтр: черно-белый", editedImage.getDescription());
    }
}