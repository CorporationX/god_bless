package faang.school.godbless.lambda.task3insta;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", image.getDescription() + " Фильтр: черно-белый ");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", image.getDescription() + " Фильтр: сепия ");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", image.getDescription() + " Фильтр: виньетка ");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        System.out.println(grayscaleImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);

        Function<Image, Image> imbaFilter = filterProcessor.imbaFilters(grayscaleFilter, sepiaFilter, vignetteFilter);
        Image imbaImage = filterProcessor.applyFilter(originalImage, imbaFilter);
        System.out.println(imbaImage);
    }

}
