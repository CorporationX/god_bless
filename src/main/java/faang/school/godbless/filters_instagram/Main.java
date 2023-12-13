package faang.school.godbless.filters_instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();
        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Function<Image, Image> gradientFilter = (image) -> new Image(image.getName() + "gradient", "Фильтр: градиент");
        Function<Image, Image> blackFoneFilter = (image) -> new Image(image.getName() + "blackFone", "Фильтр затемнения фона");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Function<Image, Image> combinedFilterBlackFone = filterProcessor.combineFilters(gradientFilter, blackFoneFilter);
        Image combinedImageBlackFone = filterProcessor.applyFilter(originalImage, combinedFilterBlackFone);
    }
}