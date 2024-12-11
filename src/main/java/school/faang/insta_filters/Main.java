package school.faang.insta_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("NewImage.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " >> Filter: Grayscale"
                );
        Function<Image, Image> toneCorrectionFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " >> Filter: Correction"
                );

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, toneCorrectionFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, toneCorrectionFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
