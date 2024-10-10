package functionalInterfaceTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.functionalInterface.instagramFilters.FilterProcessor;
import school.faang.functionalInterface.instagramFilters.Image;

import java.util.function.Function;

public class instagramFiltersTest {

    @Test
    public void filtersTest() {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        Assertions.assertEquals("Оригинальное изображение | Фильтр: черно-белый", grayscaleImage.getDescription());
        Assertions.assertEquals("Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия", sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Assertions.assertEquals("Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия", combinedImage.getDescription());
    }
}
