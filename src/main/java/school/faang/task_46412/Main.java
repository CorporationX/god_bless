package school.faang.task_46412;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription()); // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
        System.out.println(sepiaImage.getDescription());

        // Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
        System.out.println(combinedImage.getDescription());
    }
}
