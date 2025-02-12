package instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Function<Image, Image> vignetteFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> grayscaleAndSepiaFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image grayscaleAndSepiaImage = filterProcessor.applyFilter(originalImage, grayscaleAndSepiaFilter);
        System.out.println(grayscaleAndSepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleAndSepiaFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
