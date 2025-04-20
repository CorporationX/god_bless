package school.faang.BJS2_70601;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(), image.description()
                + " | Filter: grayscale");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(), image.description()
                + " | Filter: sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combineFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combineFilter);
        System.out.println(combinedImage.description());
    }
}
