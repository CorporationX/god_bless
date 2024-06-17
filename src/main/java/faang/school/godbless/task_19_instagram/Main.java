package faang.school.godbless.task_19_instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name() + "_vignette", "Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
