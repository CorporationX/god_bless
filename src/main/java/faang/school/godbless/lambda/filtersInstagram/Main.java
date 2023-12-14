package faang.school.godbless.lambda.filtersInstagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.getName() + "_grayscale", image.getDescription() + " Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName() + "_sepia", image.getDescription() + " Фильтр: сепия");
        Function<Image, Image> vignetteFilter =
                (image) -> new Image(image.getName() + "_vignette", image.getDescription() + " Фильтр: виньетка");

// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilterGrayscaleSepia =
                filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> combinedFilterVignetteGrayscale =
                filterProcessor.combineFilters(vignetteFilter, grayscaleFilter);
        Function<Image, Image> combinedFilterSepiaVignette =
                filterProcessor.combineFilters(sepiaFilter, vignetteFilter);

        Image combinedImageGrayscaleSepia = filterProcessor.applyFilter(originalImage, combinedFilterGrayscaleSepia);
        Image combinedImageVignetteGrayscale = filterProcessor.applyFilter(originalImage, combinedFilterVignetteGrayscale);
        Image combinedImageSepiaVignette = filterProcessor.applyFilter(originalImage, combinedFilterSepiaVignette);

        System.out.println(combinedImageGrayscaleSepia);
        System.out.println(combinedImageVignetteGrayscale);
        System.out.println(combinedImageSepiaVignette);

        System.out.println();

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
    }
}
