package faang.school.godbless.instagram;

import faang.school.godbless.instagram.model.FilterProcessor;
import faang.school.godbless.instagram.model.Image;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
    @Test
    public void applyFilter_shouldReturnImageWithFilter() {
        Image imageWithoutFilter = new Image("mountains", 12, "none");
        Image imageWithFilter = new Image("mountains_grayscale", 12, "Фильтр: черно-белый");
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", 12, "Фильтр: черно-белый");
        FilterProcessor filterProcessor = new FilterProcessor();
        var resultFromApply = filterProcessor.applyFilter(imageWithoutFilter,grayscaleFilter);
        assertEquals(imageWithFilter, resultFromApply);

        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", 12, "Фильтр: сепия");
        var combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        var resultFromCombined = filterProcessor.applyFilter(imageWithoutFilter, combinedFilter);
        assertEquals("mountains_grayscale_sepia", resultFromCombined.getName());
    }
}
