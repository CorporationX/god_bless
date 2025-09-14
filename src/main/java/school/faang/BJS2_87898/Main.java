package school.faang.BJS2_87898;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: Grayscale filter");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: Sepia filter");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combineFilter);
        System.out.println(combinedImage.getDescription());
    }
}