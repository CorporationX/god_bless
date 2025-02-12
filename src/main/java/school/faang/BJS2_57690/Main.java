package school.faang.BJS2_57690;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинал");
        FilterProcessor filter = new FilterProcessor();

        Function<Image, Image> grayscale = (image ->
                new Image(image.getName(), image.getDescription() + " - Фильтр: черно-белый"));
        Function<Image, Image> sepiaFilter = (image ->
                new Image(image.getName(), image.getDescription() + " - Фильтр: сепия"));
        Function<Image, Image> vignette = (image ->
                new Image(image.getName(), image.getDescription() + " - Фильтр: виньетка"));

        Image grayscaleImage = filter.applyFilter(originalImage, grayscale);
        System.out.println(grayscaleImage.getDescription());
        Function<Image, Image> combineFilter = filter.combineFilters(sepiaFilter, vignette);
        Image combineImage = filter.applyFilter(originalImage, combineFilter);
        System.out.println(combineImage.getDescription());
    }
}
