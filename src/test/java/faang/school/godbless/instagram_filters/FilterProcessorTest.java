package faang.school.godbless.instagram_filters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class FilterProcessorTest {
    private Image pic;
    Function<Image, Image> rusticFilter;
    Function<Image, Image> sunsetFilter;
    Function<Image, Image> californiaFilter;
    private FilterProcessor filterProcessor;

    @BeforeEach
    void setUp(){
        pic = new Image("pic", "no filter");
        rusticFilter = (image -> new Image(image.getName() + "_rustic", "rustic filter applied "));
        sunsetFilter = (image -> new Image(image.getName() + "_sunset", "sunset filter applied"));
        californiaFilter = (image -> new Image(
                image.getName() + "_california", image.getDescription() + " california filter applied"));
        filterProcessor = new FilterProcessor();
    }

    @Test
    void applyFilterTest(){
        Image image = filterProcessor.applyFilter(pic, rusticFilter);

        Assertions.assertTrue(image.getName().contains("_rustic"));
        Assertions.assertTrue(image.getDescription().contains("rustic filter applied"));
    }

    @Test
    void appluDoubleFilterTest(){
        Function <Image, Image> combinedFilter = filterProcessor.combineFilters(sunsetFilter, californiaFilter);
        Image image = filterProcessor.applyFilter(pic, combinedFilter);
        System.out.println(image.getName());
        System.out.println(image.getDescription());

        Assertions.assertEquals("pic_sunset_california", image.getName());
        Assertions.assertEquals("sunset filter applied california filter applied", image.getDescription());
    }
}
