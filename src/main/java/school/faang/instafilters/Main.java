package school.faang.instafilters;

import static school.faang.instafilters.Filters.FILTERS;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackWhiteFilter = FILTERS.get("blackWhiteFilter");
        Function<Image, Image> sepia = FILTERS.get("sepia");
        Function<Image, Image> vignette = FILTERS.get("vignette");

        Image testImage = new Image("picture.png", "original");
        Image testImage2 = new Image("photo.jpeg", "original");

        Image blackWhiteImage = filterProcessor.applyFilter(testImage, blackWhiteFilter);
        System.out.println(blackWhiteImage.description());

        Image sepiaImage = filterProcessor.applyFilter(blackWhiteImage, sepia);
        System.out.println(sepiaImage.description());

        Function<Image, Image> vignetteSepiaFilter = filterProcessor.combineFilters(vignette, sepia);
        Image combinedImage = filterProcessor.applyFilter(testImage2, vignetteSepiaFilter);
        System.out.println(combinedImage.description());
    }
}
