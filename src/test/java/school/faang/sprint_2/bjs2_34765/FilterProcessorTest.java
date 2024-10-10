package school.faang.sprint_2.bjs2_34765;

import org.junit.jupiter.api.Test;
import school.faang.sprint_2.bjs2_34765.FilterProcessor;
import school.faang.sprint_2.bjs2_34765.Image;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    static FilterProcessor filterProcessor = new FilterProcessor();
    String firstEffect = "black test filter";
    String secondEffect = "white test filter";
    Image testImage = new Image("test", "original test image");
    Function<Image, Image> firstTestFilter = image -> new Image(image.getName(),
            image.getDescription() + firstEffect);
    Function<Image, Image> secondTestFilter = image -> new Image(image.getName(),
            image.getDescription() + secondEffect);

    @Test
    void testApplyFilter() {
        Image testFilteredImage = filterProcessor.applyFilter(testImage, firstTestFilter);

        assertEquals(testImage.getDescription() + firstEffect, testFilteredImage.getDescription());
    }

    @Test
    void testCombineFilters() {
        Function<Image, Image> testCombinedFilter = filterProcessor.combineFilters(firstTestFilter, secondTestFilter);
        Image testCombineFilteredImage = filterProcessor.applyFilter(testImage, testCombinedFilter);

        assertEquals(testImage.getDescription() + firstEffect + secondEffect,
                testCombineFilteredImage.getDescription());
    }
}