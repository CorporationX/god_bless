package instagram_filters;

import faang.school.godbless.instagram_filters.FilterProcessor;
import faang.school.godbless.instagram_filters.Image;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

@RequiredArgsConstructor
public class FilterProcessorTest {

    @Test
    @DisplayName("Should apply filter")
    void shouldApplyFilter() {

        FilterProcessor filterProcessor = new FilterProcessor();
        Image myPhoto = new Image("myPhoto.jpg", "The most beautiful person in whole world");

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale",
                "Filter: Monochrome");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia",
                "Filter: Sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette",
                "Filter: Vignette");

        Image expectedMonochromePhoto = new Image("myPhoto.jpg_grayscale", "Filter: Monochrome");
        Image expectedSepiaPhoto = new Image("myPhoto.jpg_sepia", "Filter: Sepia");
        Image expectedVignettePhoto = new Image("myPhoto.jpg_vignette", "Filter: Vignette");

        Assertions.assertEquals(expectedMonochromePhoto, filterProcessor.applyFilter(myPhoto, grayscaleFilter));
        Assertions.assertEquals(expectedSepiaPhoto, filterProcessor.applyFilter(myPhoto, sepiaFilter));
        Assertions.assertEquals(expectedVignettePhoto, filterProcessor.applyFilter(myPhoto, vignetteFilter));
    }

    @Test
    @DisplayName("Should combine filters")
    void shouldCombineFilters() {

        FilterProcessor filterProcessor = new FilterProcessor();
        Image myPhoto = new Image("myPhoto.jpg", "The most beautiful person in whole world");

        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia",
                "Filter: Sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette",
                "Filter: Vignette");

        Function<Image, Image> sepiaAndVignetteFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image expectedPhoto = new Image("myPhoto.jpg_sepia_vignette", "Filter: Vignette");

        Assertions.assertEquals(expectedPhoto, filterProcessor.applyFilter(myPhoto, sepiaAndVignetteFilter));
    }
}
