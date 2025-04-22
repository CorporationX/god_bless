package school.faang.BJS2_70526;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image original = new Image("original", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(original, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(original, combinedFilter);
        System.out.println(combineImage.description());
    }
}