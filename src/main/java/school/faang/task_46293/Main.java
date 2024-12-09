package school.faang.task_46293;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(), image.description()
                + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(), image.description()
                + " | Фильтр: сепия");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия


        // Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия


        Function<Image, Image> customFilter = image -> new Image(image.name(), image.description()
                + " | Фильтр: пользовательский");
        Function<Image, Image> combinedFilter2 = filterProcessor.combineFilters(combinedFilter, customFilter);
        Image combinedImage2 = filterProcessor.applyFilter(originalImage, combinedFilter2);
        System.out.println(combinedImage2.description());
        // Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия | Фильтр: пользовательский
    }
}
