package derschrank.sprint02.task03.bjstwo_46685;

import org.w3c.dom.ls.LSOutput;

import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, FilterType.GRAYSCALE.getFilter());

        System.out.println(grayscaleImage); // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(originalImage, FilterType.SEPIA.getFilter());
        System.out.println(sepiaImage); // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия

        Image superImage = filterProcessor.applyFilter(originalImage, FilterType.SUPER.getFilter());
        System.out.println(superImage); // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия

        // Комбинирование фильтров
        UnaryOperator<Image> combinedFilter1 = filterProcessor.combineFilters(FilterType.SUPER.getFilter(), FilterType.SEPIA.getFilter());
        Image combinedImage1 = filterProcessor.applyFilter(originalImage, combinedFilter1);
        System.out.println(combinedImage1); // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия

        UnaryOperator<Image> combinedFilter2 = filterProcessor.combineFilters(combinedFilter1, FilterType.GRAYSCALE.getFilter());
        Image combinedImage2 = filterProcessor.applyFilter(originalImage, combinedFilter2);
        System.out.println(combinedImage2); // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
    }
}
