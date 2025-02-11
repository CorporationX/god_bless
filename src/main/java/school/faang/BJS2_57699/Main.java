package school.faang.BJS2_57699;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("авто", "оригинал");

        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> blackAndWhiteFilter = (image) ->
                new Image(image.getName(), "%s - применен фильтр черно-белый".formatted(image.getDescription()));

        Image blackAndWhiteImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage);

        Function<Image, Image> sepiaFilter = image ->
                new Image(image.getName(), "%s - применен фильтр сепия".formatted(image.getDescription()));

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage);

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(blackAndWhiteFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combineFilter);
        System.out.println(combineImage);
    }
}
