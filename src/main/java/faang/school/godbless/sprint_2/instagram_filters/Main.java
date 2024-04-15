package faang.school.godbless.sprint_2.instagram_filters;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);

        // Создание и применение комбинированного фильтра
        try {
            Function<Image, Image> combinedFilter = filterProcessor.combineFilters(null, sepiaFilter);
            Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

            System.out.println(combinedImage);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(combinedImage);
    }
}