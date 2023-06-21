package faang.school.godbless;

import java.util.function.Function;

public class InstagramFilter {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName() + "_grayscale", image.getDescription().contains("Фильтр") ?
                        "Фильтр: черно-белый" + " +" + image.getDescription().substring(7) : "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName() + "_sepia", image.getDescription().contains("Фильтр") ?
                        "Фильтр: сепия" + " +" + image.getDescription().substring(7) : "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName() + "_vignette", image.getDescription().contains("Фильтр") ?
                        "Фильтр: виньетка" + " +" + image.getDescription().substring(7) : "Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        System.out.println(grayscaleImage.getName() + " - " + grayscaleImage.getDescription());
        System.out.println(sepiaImage.getName() + " - " + sepiaImage.getDescription());
        System.out.println(vignetteImage.getName() + " - " + vignetteImage.getDescription());

        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getName() + " - " + combinedImage.getDescription());
    }
}

