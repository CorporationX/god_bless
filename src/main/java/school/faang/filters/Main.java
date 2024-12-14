package school.faang.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("markiza.jpg", "Image of Markiza");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() +
                " | Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() +
                " | Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(), image.getDescription() +
                " | Filter: vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> sepiaVignetteFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image sepiaVignetteImage = filterProcessor.applyFilter(originalImage, sepiaVignetteFilter);
        System.out.println(sepiaVignetteImage.getDescription());

        Function<Image, Image> grayscaleSepiaFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image grayscaleSepiaImage = filterProcessor.applyFilter(originalImage, grayscaleSepiaFilter);
        System.out.println(grayscaleSepiaImage.getDescription());
    }
}
