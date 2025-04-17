package school.faang.stream2.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Genuine foto");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Filter: " + Filter.GREYSCALE.label);
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Filter: " + Filter.SEPIA.label);
        Function<Image, Image> vignette = image -> new Image(image.getName(),
                image.getDescription() + " | Filter: " + Filter.VIGNETTE.label);

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, vignette);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
