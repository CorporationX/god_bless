package bjs257813;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image originalImage = new Image("original.jpg", "Original image");

        // Фильтры
        Function<Image, Image> grayscaleFilter = (image)
                -> new Image(image.getName(), image.getDescription() + " | Filter: black and white");
        Function<Image, Image> sepiaFilter = (image)
                -> new Image(image.getName(), image.getDescription() + " | Filter: sepia");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription()); // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия

        // Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
    }
}
