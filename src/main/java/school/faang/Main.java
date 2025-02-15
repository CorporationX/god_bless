package school.faang;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(), image.description() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name(), image.description() + " | Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = applyFilter(filterProcessor, originalImage, grayscaleFilter);
        Image sepiaImage = applyFilter(filterProcessor, grayscaleImage, sepiaFilter);
        applyFilter(filterProcessor, sepiaImage, vignetteFilter);

        // Комбинирование фильтров
        applyCombineFilter(filterProcessor, grayscaleFilter, sepiaFilter, originalImage);
        applyCombineFilter(filterProcessor, vignetteFilter, sepiaFilter, originalImage);
        applyCombineFilter(filterProcessor, vignetteFilter, grayscaleFilter, originalImage);
    }

    private static Image applyFilter(
            FilterProcessor filterProcessor,
            Image originalImage,
            Function<Image, Image> filter) {
        Image filteredImage = filterProcessor.applyFilter(originalImage, filter);
        System.out.println(filteredImage.description());

        return filteredImage;
    }

    private static void applyCombineFilter(
            FilterProcessor filterProcessor,
            Function<Image, Image> filter1,
            Function<Image, Image> filter2,
            Image originalImage) {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(filter1, filter2);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(combinedImage.description());
    }
}