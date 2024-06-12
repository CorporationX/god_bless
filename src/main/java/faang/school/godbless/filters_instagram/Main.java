package faang.school.godbless.filters_instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

        System.out.println(filterProcessor.applyFilter(originalImage, grayscaleFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, sepiaFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, vignetteFilter));

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        System.out.println(filterProcessor.applyFilter(originalImage, combinedFilter));
    }
}
