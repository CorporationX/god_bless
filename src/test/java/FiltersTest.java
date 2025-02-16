import instagramfilters.FilterDescription;
import instagramfilters.FilterProcessor;
import instagramfilters.Filters;
import instagramfilters.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class FiltersTest {

    private static final Logger logger = Logger.getLogger(FiltersTest.class.getName());
    private FilterProcessor processor;
    private final Image image = new Image("Rainbow", "Rainbow picture needs some changes!");

    @BeforeEach
    void setUp() {
        processor = new FilterProcessor();
        logger.info("Starting a new test...");
    }

    @Test
    void testBlackAndWhiteFilter() {
        logger.info("Running test: testBlackAndWhiteFilter");
        Image filteredImage = Filters.blackAndWhiteFilter.apply(image);
        assertTrue(filteredImage.description().contains(FilterDescription.BLACK_AND_WHITE.getDescription()));
        logger.info("Test passed: testBlackAndWhiteFilter");
    }

    @Test
    void testSepiaFilter() {
        logger.info("Running test: testSepiaFilter");
        Image filteredImage = Filters.sepiaFilter.apply(image);
        assertTrue(filteredImage.description().contains(FilterDescription.SEPIA.getDescription()));
        logger.info("Test passed: testSepiaFilter");
    }

    @Test
    void testVignetteFilter() {
        logger.info("Running test: testVignetteFilter");
        Image filteredImage = Filters.vignetteFilter.apply(image);
        assertTrue(filteredImage.description().contains(FilterDescription.VIGNETTE.getDescription()));
        logger.info("Test passed: testVignetteFilter");
    }

    @Test
    void testNullImage() {
        logger.info("Running test: testNullImage");
        assertThrows(IllegalArgumentException.class, () -> Filters.blackAndWhiteFilter.apply(null));
        logger.info("Test passed: testNullImage");
    }

    @Test
    void testApplyFilter() {
        logger.info("Running test: testApplyFilter");
        Image image = new Image("Rainbow", "Rainbow picture needs some changes!");
        Image filteredImage = processor.applyFilter(image, Filters.blackAndWhiteFilter);
        assertTrue(filteredImage.description().contains(FilterDescription.BLACK_AND_WHITE.getDescription()));
        logger.info("Test passed: testApplyFilter");
    }

    @Test
    void testCombineFilters() {
        logger.info("Running test: testCombineFilters");
        Image image = new Image("Rainbow", "Rainbow picture needs some changes!");
        Function<Image, Image> combinedFilter = processor.combineFilters(Filters.blackAndWhiteFilter,
                Filters.sepiaFilter);
        Image filteredImage = combinedFilter.apply(image);
        assertTrue(filteredImage.description().contains(FilterDescription.BLACK_AND_WHITE.getDescription()));
        assertTrue(filteredImage.description().contains(FilterDescription.SEPIA.getDescription()));
        logger.info("Test passed: testCombineFilters");
    }

    @Test
    void testNullFilter() {
        logger.info("Running test: testNullFilter");
        Image image = new Image("Rainbow", "Rainbow picture needs some changes!");
        assertThrows(IllegalArgumentException.class, () -> processor.applyFilter(image, null));
        logger.info("Test passed: testNullFilter");
    }
}

