package org.example.service.instagramFilter;

import org.example.model.instagramFilter.Image;

import java.util.function.Function;

public class FilterProcessor {
    private static Image applyFilter(Image image, Function<Image, Image> filter){
        return filter.apply(image);
    }

    private static Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter){
        return firstFilter.andThen(secondFilter);
    }

    public static void main(String[] args) {
        Function<Image, Image> blackWhite = image -> new Image(image.getName(), image.getDescription() + "| Black White filter");
        Function<Image, Image> dark = image -> new Image(image.getName(), image.getDescription() + "| Dark filter");
        Function<Image, Image> contrast = image -> new Image(image.getName(), image.getDescription() + "| Contrast filter");

        Image image = new Image("image.jpg", "image");
        Image blackImage = FilterProcessor.applyFilter(image, blackWhite);
        System.out.println(blackImage.getDescription());

        Image darkImage = FilterProcessor.applyFilter(image, dark);
        System.out.println(darkImage.getDescription());

        Image contrastImage = FilterProcessor.applyFilter(image, contrast);
        System.out.println(contrastImage.getDescription());

        Function<Image, Image> blackWhiteAndContrastFilter = FilterProcessor.combineFilters(blackWhite, contrast);
        Image blackWhiteAndConstrastImage = FilterProcessor.applyFilter(image, blackWhiteAndContrastFilter);
        System.out.println(blackWhiteAndConstrastImage.getDescription());
    }
}
