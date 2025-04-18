package school.faang.sprint_2.instagram_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");
        Function<Image, Image> blurFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: размытие");

        Image grayscaleImage = FilterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = FilterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Image vignetteImage = FilterProcessor.applyFilter(grayscaleImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> combinedTwoFilters = FilterProcessor.combineTwoFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = FilterProcessor.applyFilter(originalImage, combinedTwoFilters);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> combinedFilters = FilterProcessor.combineFilters(vignetteFilter,
                grayscaleFilter, sepiaFilter, blurFilter);
        Image allFiltersImage = FilterProcessor.applyFilter(originalImage, combinedFilters);
        System.out.println(allFiltersImage.getDescription());
    }
}
