package faang.school.godbless.lamdbastreamapi.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original", "Оригинальное изобрание");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(
                image.getName() + "_grayscale",
                image.getDescription() + "\nФильтр: черно-белый"
        );
        Function<Image, Image> sepiaFilter = (image) -> new Image(
                image.getName() + "_sepia",
                image.getDescription() + "\nФильтр: сепия"
        );
        Function<Image, Image> vignetteFilter = (image) -> new Image(
                image.getName() + "_vignette",
                image.getDescription() + "\nФильтр: виньетка"
        );

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepialImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(grayscaleImage);
        System.out.println(sepialImage);
        System.out.println(vignetteImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, grayscaleFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);

    }
}
