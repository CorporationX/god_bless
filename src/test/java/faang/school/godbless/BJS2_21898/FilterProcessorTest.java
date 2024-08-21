package faang.school.godbless.BJS2_21898;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class FilterProcessorTest {
    private FilterProcessor fp;
    private Image originalImage;
    Function<Image, Image> grayscaleFilter = image -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
    Function<Image, Image> sepiaFilter = image -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
    Function<Image, Image> vignetteFilter = image -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");


    @BeforeEach
    void setUp() {
        fp = new FilterProcessor();
        originalImage = new Image("original.jpg", "Оригинальное изображение");
    }

    @Test
    void applyFilter() {
        Image grayscaleImage = fp.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = fp.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = fp.applyFilter(originalImage, vignetteFilter);

        assertThat(grayscaleImage.getName()).isEqualTo("original.jpg_grayscale");
        assertThat(grayscaleImage.getDescription()).isEqualTo("Фильтр: черно-белый");
        assertThat(sepiaImage.getName()).isEqualTo("original.jpg_sepia");
        assertThat(sepiaImage.getDescription()).isEqualTo("Фильтр: сепия");
        assertThat(vignetteImage.getName()).isEqualTo("original.jpg_vignette");
        assertThat(vignetteImage.getDescription()).isEqualTo("Фильтр: виньетка");
        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
    }

    @Test
    void combineFilters() {
        Function<Image, Image> combinedFilter = fp.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = fp.applyFilter(originalImage, combinedFilter);

        assertThat(combinedImage.getName()).isEqualTo("original.jpg_grayscale_sepia");
        System.out.println(combinedImage);
    }
}