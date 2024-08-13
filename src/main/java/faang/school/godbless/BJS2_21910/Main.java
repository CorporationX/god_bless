package faang.school.godbless.BJS2_21910;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        System.out.println(originalImage);
        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getFileName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getFileName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getFileName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров
        System.out.println(filterProcessor.applyFilter(originalImage, grayscaleFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, sepiaFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, vignetteFilter));

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        System.out.println(filterProcessor.applyFilter(originalImage, combinedFilter));
    }
}
