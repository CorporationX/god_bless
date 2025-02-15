package school.faang.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = (image) -> new Image(image.getName(), image.getDescription() +
                "| Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() +
                "| Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(), image.getDescription() +
                "| Filter: the vignette");

        Image blackAndWhiteImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());
    }
}
