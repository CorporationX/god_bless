package school.faang;

import school.faang.instagram.services.FilterProcessor;
import school.faang.instagram.services.Image;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image original = new Image("original.jpg", "Оригинал");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = (image) -> new Image(
                image.getName(),
                image.getDescription() + " | Фильтр: черно-белый"
        );
        Function<Image, Image> sepiaFilter = (image) -> new Image(
                image.getName(),
                image.getDescription() + " | Фильтр: сепия"
        );

        Function<Image, Image> vignette = (image) -> new Image(
                image.getName(),
                image.getDescription() + " | Фильтр: виньетка"
        );

        Image blackAndWhiteImage = filterProcessor.applyFilter(original, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignette);
        Image combinedImage = filterProcessor.applyFilter(original, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}