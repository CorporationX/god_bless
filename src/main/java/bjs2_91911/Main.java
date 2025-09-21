package bjs2_91911;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Определяем фильтры как лямбда-функции
        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.name(), image.description() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.name(), image.description() + " | Фильтр: сепия");

        Function<Image, Image> vignetteFilter =
                (image) -> new Image(image.name(), image.description() + " | Фильтр: виньетка");

        // Применение отдельных фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        // Комбинация фильтров (черно-белый + сепия)
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());

        // Комбинация трёх фильтров
        Function<Image, Image> tripleFilter = filterProcessor
                .combineFilters(grayscaleFilter, sepiaFilter.andThen(vignetteFilter));
        Image tripleImage = filterProcessor.applyFilter(originalImage, tripleFilter);
        System.out.println(tripleImage.description());
    }
}
