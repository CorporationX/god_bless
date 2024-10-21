package ru.kraiush.BJS2_34760;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Image originalImage = new Image("original.jpeg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> greyscaleFilter = (image -> new Image(image.getName(), image.getDescription() + " | Filter: greyscale"));
        Function<Image, Image> sepiaFilter = (image -> new Image(image.getName(), image.getDescription() + " | Filter: sepia"));

        Image greyscaleImage = filterProcessor.applyFilter(originalImage, greyscaleFilter);
        System.out.println(greyscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(greyscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(greyscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
