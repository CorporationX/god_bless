package faang.school.godbless.sprint3.Instagram_Sprint3;

import faang.school.godbless.sprint3.Instagram_Sprint3.FilterProcessor;
import faang.school.godbless.sprint3.Instagram_Sprint3.Function;
import faang.school.godbless.sprint3.Instagram_Sprint3.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Image originalImage = new Image("original.jpg", "Оригинальное изображение");
    FilterProcessor filterProcessor = new FilterProcessor();

    Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
    Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
    Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

    @Test
    void testGrayscale(){
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        assertEquals(new Image("original.jpg_grayscale","Фильтр: черно-белый"), grayscaleImage);

    }
    @Test
    void testSepiaImage(){
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        assertEquals(new Image("original.jpg_sepia","Фильтр: сепия"), sepiaImage);
    }
    @Test
    void testVignetteImage(){
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        assertEquals(new Image("original.jpg_vignette","Фильтр: виньетка"), vignetteImage);
    }

    @Test
    void testCombined(){
        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        assertEquals(new Image("original.jpg_grayscale_sepia","Фильтр: сепия"), combinedImage);
    }
}