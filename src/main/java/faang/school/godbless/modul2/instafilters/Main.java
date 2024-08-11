package faang.school.godbless.modul2.instafilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName().replace(".jpg", "_grayscale.jpg"), "Filter: black and white");

        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName().replace(".jpg", "_sepia.jpg"), "Filter: sepia");

        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName().replace(".jpg", "_vignette.jpg"), "Filter: vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        System.out.println(combinedImage);
    }
}
