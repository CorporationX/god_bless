package school.faang.filters_instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Cat", "Start image");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " sepia filter.");
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " grayscale filter.");

        Image newImage = filterProcessor.applyFilter(originalImage, image -> new Image(image.getName(), image.getDescription() + " я есть новый фильтр"));
        System.out.println(newImage.getDescription());

        Function<Image, Image> doubleImage = filterProcessor.combineFilters(sepiaFilter, grayscaleFilter);
        Image resultImage = doubleImage.apply(newImage);
        System.out.println(resultImage.getDescription());
    }
}
