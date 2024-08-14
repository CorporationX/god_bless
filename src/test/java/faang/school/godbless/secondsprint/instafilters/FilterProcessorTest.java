package faang.school.godbless.secondsprint.instafilters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
    private FilterProcessor filterProcessor;
    private Image originalImage;
    private Image filteredImage;
    private Function<Image, Image> nameFilter;
    private Function<Image, Image> descriptionFilter;

    @BeforeEach
    public void setUp() {
        filterProcessor = new FilterProcessor();
        originalImage = new Image("testImage", "testDescription");
        nameFilter = image -> new Image(image.getName() + "_filtered", image.getDescription());
        descriptionFilter = image -> new Image(image.getName(), image.getDescription() + "_filtered");
    }

    @Test
    @DisplayName("Should apply a single filter to the image correctly")
    public void testApplyFilter() {
        filteredImage = filterProcessor.applyFilter(originalImage, nameFilter);

        assertAll(
                () -> assertEquals("testImage_filtered", filteredImage.getName()),
                () -> assertEquals("testDescription", filteredImage.getDescription())
        );
    }

    @Test
    @DisplayName("Should combine two filters and apply them sequentially")
    public void testCombineFilters() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(nameFilter, descriptionFilter);
        filteredImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertAll(
                () -> assertEquals("testImage_filtered", filteredImage.getName()),
                () -> assertEquals("testDescription_filtered", filteredImage.getDescription())
        );
    }

    @Test
    @DisplayName("Should handle combining identical filters")
    public void testCombineIdenticalFilters() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(nameFilter, nameFilter);
        Image filteredImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertAll(
                () -> assertEquals("testImage_filtered_filtered", filteredImage.getName()),
                () -> assertEquals("testDescription", filteredImage.getDescription())
        );
    }
}
