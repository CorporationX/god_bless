import org.junit.jupiter.api.Test;
import school.faang.instagramFilters.FilterProcessor;
import school.faang.instagramFilters.Image;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFilterProcessor {
    @Test
    public void testApplyOneFilter() {
        // arrange
        Image catImage = new Image("Cat.png", "A cat picture");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayScaleFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Black-White filter");
        String expected = "A cat picture | Black-White filter";

        // act
        Image grayFilteredCatImage = filterProcessor.applyFilter(catImage, grayScaleFilter);
        String actual = grayFilteredCatImage.getDescription();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleFilters() {
        // arrange
        Image catImage = new Image("Cat.png", "A cat picture");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayScaleFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Black-White filter");
        String expectedGrayFilter = "A cat picture | Black-White filter";
        Function<Image, Image> vineFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Vine filter");
        String expectedVineFilter = "A cat picture | Vine filter";

        // act
        Image grayFilteredCatImage = filterProcessor.applyFilter(catImage, grayScaleFilter);
        String actualGrayFilter = grayFilteredCatImage.getDescription();
        Image vineFilteredCatImage = filterProcessor.applyFilter(catImage, vineFilter);
        String actualVineFilter = vineFilteredCatImage.getDescription();

        // assert
        assertEquals(expectedGrayFilter, actualGrayFilter);
        assertEquals(expectedVineFilter, actualVineFilter);
    }

    @Test
    public void testCombineFilters() {
        // arrange
        Image catImage = new Image("Cat.png", "A cat picture");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayScaleFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Black-White filter");
        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Sepia filter");
        String expected = "A cat picture | Black-White filter | Sepia filter";

        // act
        Function<Image, Image> combinedFilters = filterProcessor.combineFilters(grayScaleFilter, sepiaFilter);
        Image grayFilteredCatImage = filterProcessor.applyFilter(catImage, combinedFilters);
        String actual = grayFilteredCatImage.getDescription();

        // assert
        assertEquals(expected, actual);
    }
}