package faang.school.godbless.instagramm;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalimage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(
                image.getName() + "_grayscale", image.getDescription() + " + Фильтр: черно-белый"
        );
        Function<Image, Image> sepiaFilter = image -> new Image(
                image.getName() + "_sepia", image.getDescription() + " + Фильтр: сепия"
        );
        Function<Image, Image> vignetteFilter = image -> new Image(
                image.getName() + "_vignette", image.getDescription() + " + Фильтр: виньетка"
        );

        Image grayscaleImage = filterProcessor.applyFilter(originalimage, grayscaleFilter);
        System.out.println(grayscaleImage);

        Image sepiaImage = filterProcessor.applyFilter(originalimage, sepiaFilter);
        System.out.println(sepiaImage);

        Image vignetteImage = filterProcessor.applyFilter(originalimage, vignetteFilter);
        System.out.println(vignetteImage);

        Function<Image, Image> grayscaleAndSepiaFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalimage, grayscaleAndSepiaFilter);
        System.out.println(combineImage);
    }
}
