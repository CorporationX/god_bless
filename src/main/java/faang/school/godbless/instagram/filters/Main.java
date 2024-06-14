package faang.school.godbless.instagram.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println("Фото после применения фильтра \"grayscaleFilter\": " + grayscaleImage.getName());
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println("Фото после применения фильтра \"sepiaFilter\": " + sepiaImage.getName());

        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println("Фото после применения комбинированного фильтра: " + combinedImage.getName());
    }
}
