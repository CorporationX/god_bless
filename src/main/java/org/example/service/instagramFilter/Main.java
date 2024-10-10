package org.example.service.instagramFilter;

import org.example.model.instagramFilter.Image;

import java.util.function.Function;

public class Main {
    private final static Function<Image, Image> BLACK_WHITE_FILTER =
            image -> new Image(image.getName(), image.getDescription() + "| Black White filter");
    private final static Function<Image, Image> DARK_FILTER =
            image -> new Image(image.getName(), image.getDescription() + "| Dark filter");
    private final static Function<Image, Image> CONTRAST_FILTER =
            image -> new Image(image.getName(), image.getDescription() + "| Contrast filter");

    public static void main(String[] args) {
        Image image = new Image("image.jpg", "image");
        Image blackImage = FilterProcessor.applyFilter(image, BLACK_WHITE_FILTER);
        System.out.println(blackImage.getDescription());

        Image darkImage = FilterProcessor.applyFilter(image, DARK_FILTER);
        System.out.println(darkImage.getDescription());

        Image contrastImage = FilterProcessor.applyFilter(image, CONTRAST_FILTER);
        System.out.println(contrastImage.getDescription());

        Function<Image, Image> blackWhiteAndContrastFilter = FilterProcessor.combineFilters(BLACK_WHITE_FILTER, CONTRAST_FILTER);
        Image blackWhiteAndConstrastImage = FilterProcessor.applyFilter(image, blackWhiteAndContrastFilter);
        System.out.println(blackWhiteAndConstrastImage.getDescription());
    }
}
