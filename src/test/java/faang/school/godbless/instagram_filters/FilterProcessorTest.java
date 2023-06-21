package faang.school.godbless.instagram_filters;

import faang.school.godbless.sprint_3.instagram_filtres.FilterProcessor;
import faang.school.godbless.sprint_3.instagram_filtres.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;

public class FilterProcessorTest {
    FilterProcessor filterProcessor;
    Image originalImage;
    Function<Image, Image> grayscaleFilter;
    Function<Image, Image> sepiaFilter;
    Function<Image, Image> combineFilters;
    Image filteredImage;

    @BeforeEach
    public void init() {
        filterProcessor = new FilterProcessor();
        originalImage = new Image("original.jpg", "Original image");
        grayscaleFilter = image -> new Image(image.getName() + "_grayscale", "Filter: white-black");
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Filter: series");
        combineFilters = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        filteredImage = filterProcessor.applyFilter(originalImage, combineFilters);
    }

    @Test
    public void applyFilterTest() {
        String expected = "original.jpg_grayscale";
        Image result = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        assertEquals(expected, result.getName());

    }

    @Test
    public void combineFiltersTest() {
        String expected = "original.jpg_grayscale_sepia";
        Image result = filterProcessor.applyFilter(originalImage, combineFilters);
        assertEquals(expected, result.getName());
    }

    @Test
    public void showCurrentFilterTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        filterProcessor.showCurrentFilter(filteredImage, consumer -> System.out.println(consumer.getName() + "-----" + consumer.getDescription()));

        String expected = "original.jpg_grayscale_sepia-----Filter: series";
        String result = outputStream.toString().trim();
        assertEquals(expected, result);
    }
}
