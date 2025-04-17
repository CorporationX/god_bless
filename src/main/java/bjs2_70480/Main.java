package bjs2_70480;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image firstImage = new Image("Family photo", "The original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = image -> new Image(image.name(), image.discription() + " | Filter: Black and white filter");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(), image.discription() + " | Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name(), image.discription() + " | Filter: vignette");

        Image blackAndWhiteImage = filterProcessor.applyFilter(firstImage, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage.discription());

        Image sepiaImage = filterProcessor.applyFilter(firstImage, sepiaFilter);
        System.out.println(sepiaImage.discription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(vignetteFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(firstImage, combinedFilter);
        System.out.println(combinedImage.discription());
    }
}
