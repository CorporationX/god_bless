package school.faang.bjs2_34878;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;
public class FilterProcessorTest {
    private FilterProcessor processor;
    private Image image;

    @BeforeEach
    public void setUp() {
        processor = new FilterProcessor();
        image = new Image("photo.jpg", "Before photo");
    }


    @Test
    public void testApplyBlackAndWhiteFilter() {
        Image result = processor.applyFilter(image, Filters.blackAndWhiteFilter);
        assertEquals("Before photo + Black & White Filter ", result.getDescription(),
                "Black and White filter should be applied");
    }


    @Test
    public void testCombineFilters() {
        Function<Image, Image> combinedFilter = processor.combineFilter(Filters.blackAndWhiteFilter, Filters.sepiaFilter);
        Image result = processor.applyFilter(image, combinedFilter);

        // Assert the description contains both filters in the correct order
        assertEquals("Before photo + Black & White Filter  + Sepia Filter", result.getDescription(),
                "Combined filter (Black & White + Sepia) should be applied in order");
    }


    @Test
    public void testApplyFilterToEmptyDescription() {
        image.setDescription("");
        Image result = processor.applyFilter(image, Filters.blackAndWhiteFilter);
        assertEquals(" + Black & White Filter ", result.getDescription(),
                "Filter should apply to empty description without error");
    }


    @Test
    public void testNoFiltersApplied() {
        Image result = processor.applyFilter(image, img -> img); // No-op filter (does nothing)
        assertEquals("Before photo", result.getDescription(),
                "Image description should remain unchanged with no-op filter");
    }
}

