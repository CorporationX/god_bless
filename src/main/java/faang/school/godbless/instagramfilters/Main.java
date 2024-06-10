package faang.school.godbless.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName() + "_grayscale ", image.getDescription() + ", Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName() + "_sepia ",image.getDescription() + ", Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName() + "_vignette ", image.getDescription() + ", Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println("Grayscale Image: " + grayscaleImage);
        System.out.println("Sepia Image: " + sepiaImage);
        System.out.println("Vignette Image: " + vignetteImage);
        System.out.println("Combined Image: " + combinedImage);

    }
}
