package school.faang.sprint2.task_46286;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("summer2024.jpg", "Summer photos");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage);

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
