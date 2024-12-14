package faang.school.godbless;

import faang.school.godbless.InstagramFilters.FilterProcessor;
import faang.school.godbless.InstagramFilters.Image;

import java.util.function.Function;

public class Application {
    public static void main(String... args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров
        Image grayscaleImage = FilterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = FilterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = FilterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = FilterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = FilterProcessor.applyFilter(originalImage, combinedFilter);
    }
}
