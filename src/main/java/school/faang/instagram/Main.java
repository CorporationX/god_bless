package school.faang.instagram;

import java.util.function.UnaryOperator;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        UnaryOperator<Image> grayscaleFilter =
                image -> new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        UnaryOperator<Image> sepiaFilter =
                image -> new Image(image.name(), image.description() + " | Фильтр: сепия");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description()); // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
        System.out.println(sepiaImage.description());

        // Комбинирование фильтров
        UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
        System.out.println(combinedImage.description());
    }
}
