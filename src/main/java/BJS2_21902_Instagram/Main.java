package BJS2_21902_Instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpeg", "Original image");

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getFileName() + "_grayscale",
                "black and white filter");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getFileName() + "_sepia",
                "sepia filter");

        Image grayscaleImage = FilterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = FilterProcessor.applyFilter(originalImage, sepiaFilter);

        System.out.println("Was: " + originalImage.getFileName() + " and now it's: "
                + grayscaleImage.getFileName() + " with a help of: " + grayscaleImage.getDescription());
        System.out.println("Was: " + originalImage.getFileName() + " and now it's: "
                + sepiaImage.getFileName() + " with a help of: " + sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = FilterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedSepiaGrayscale = FilterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println("Was: " + originalImage.getFileName() + " now it's: "
                + combinedSepiaGrayscale.getFileName() + " with help of: " + grayscaleImage.getDescription() +
                " and " + sepiaImage.getDescription());
    }

}
