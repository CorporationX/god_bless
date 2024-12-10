package faang.school.godbless.sprint_2.task_46313;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter
                = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter
                = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter
                = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия

        // Комбинирование фильтров
        Function<Image, Image> filterCombination1 = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> filterCombination2 = filterProcessor.combineFilters(filterCombination1, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, filterCombination2);
        System.out.println(combinedImage.getDescription());
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия | Фильтр: виньетка
    }

}
