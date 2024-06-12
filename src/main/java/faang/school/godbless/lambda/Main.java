package faang.school.godbless.lambda;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение с");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", image.getDescription() + " фильтром: черно-белый ");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", image.getDescription() + " фильтром: сепия ");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", " фильтром: виньетка ");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);


    }
}
