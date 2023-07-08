package faang.school.godbless.sprint3Java8FunctionalInterfacesAndLambdas.task3;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName() + "_grayscale", image.getDescription() + " Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName() + "_sepia", image.getDescription() + " Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName() + "_vignette", image.getDescription() + "Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter2 = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> combinedFilter3 = filterProcessor.combineFilters(combinedFilter2, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter2);
        Image combinedImage2 = filterProcessor.applyFilter(originalImage, combinedFilter3);
        System.out.println(combinedImage.getName()+combinedImage.getDescription());
        System.out.println(combinedImage2.getName()+combinedImage2.getDescription());
    }
}
