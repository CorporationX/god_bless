package school.faang.BJS2_34904;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Image image1 = new Image("original.jpg", "Оригинальное изображение1");
        Image image2 = new Image("original.jpg", "Оригинальное изображение2");
        Image image3 = new Image("original.jpg", "Оригинальное изображение3");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый" );

        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия" );

        Image grayscaleImage = filterProcessor.applyFilter(image1, grayscaleFilter);
        System.out.println("\n" + grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(image2, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(image3, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
