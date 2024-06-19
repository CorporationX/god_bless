package BJS2_9890;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {


        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name() + "_vignette", "Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        System.out.println(grayscaleImage);

        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(combinedImage);
    }
}