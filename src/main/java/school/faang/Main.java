package school.faang;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Orig");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: grayscale");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Filter: vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vignetteImage = filterProcessor.applyFilter(sepiaImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }


}
