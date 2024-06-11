package faang.school.godbless.module1.sprint2.task4;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image originalImage = new Image("Портрет", "На фоне стены");
        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale",
                image.getDescription() + " Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia",
                image.getDescription() + " Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette",
                image.getDescription() + " Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        // Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter, vignetteFilter);
        Function<Image, Image> combinedFilterSecond = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Image combinedImageSecond = filterProcessor.applyFilter(originalImage, combinedFilterSecond);


        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        System.out.println(combinedImage);
        System.out.println(combinedImage);
        System.out.println(combinedImageSecond);
    }
}
