package faang.school.godbless.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter =
                (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Function<Image, Image> varkinFilter =
                (image) -> new Image(image.getName() + "_varkin", "Фильтр: варькин");


        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage);

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage);

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage);

        Image varkinImage = filterProcessor.applyFilter(originalImage, varkinFilter);
        System.out.println(varkinImage);


        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, varkinFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
