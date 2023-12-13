package faang.school.godbless.filters_Instagram;

import java.util.function.Function;

public class Main {
    public static void main(String... args) {
        Image original = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(original, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(original, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(original, vignetteFilter);

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(grayscaleFilter, vignetteFilter);
        Image combineImage = filterProcessor.applyFilter(original, combineFilter);
        System.out.println(combineImage);


    }
}
