package faang.school.godbless.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void startInstagramFiltres() {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getFileName() + "_grayscale", image.getDescription() + " обработано в фильтр:" + " черно-белый;");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getFileName() + "_sepia", image.getDescription() + " обработано в фильтр:" + " сепия;");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getFileName() + "_vignette", image.getDescription() + " обработано в фильтр:" + " виньетка;");

// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println("Название файла: " + combinedImage.getFileName() + " Описание файла: " + combinedImage.getDescription());
    }
}
