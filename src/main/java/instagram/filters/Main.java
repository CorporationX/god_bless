package instagram.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImg = new Image("original.jpg", "Фото без фильтров");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> firstFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> secondFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Image imageBlackAndWite = filterProcessor.applyFilter(originalImg, firstFilter);
        System.out.printf("Image name: %s | Image filters: %s%n", imageBlackAndWite.getName(),
                imageBlackAndWite.getDescription());

        Function<Image, Image> combined = filterProcessor.combineFilters(firstFilter, secondFilter);
        Image imageCombinedFilters = filterProcessor.applyFilter(originalImg, combined);
        System.out.printf("Image name: %s | Image filters: %s%n", imageCombinedFilters.getName(),
                imageCombinedFilters.getDescription());
    }
}
