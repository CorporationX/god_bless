package faang.school.godbless.instagram;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getTitle() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getTitle() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getTitle() + "_vignette", "Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(originalImage);
        System.out.println(grayscaleImage.toString());
        System.out.println(sepiaImage.toString());
        System.out.println(vignetteImage.toString());
        System.out.println(combinedImage.toString());
    }
}
