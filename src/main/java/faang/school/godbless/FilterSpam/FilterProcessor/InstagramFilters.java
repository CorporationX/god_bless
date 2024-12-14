package faang.school.godbless.FilterSpam.FilterProcessor;

import java.util.function.Function;

public class InstagramFilters {
    public static void main(String[] args) {
        Image image = new Image("photo.jpg", "A beautiful day!");
        FilterProcessor filterProcessor = new FilterProcessor();
        
        Function<Image, Image> grayscaleFilter = img -> {
            img.setDescription(img.getDescription() + " (Grayscale applied)");
            return img;
        };

        Function<Image, Image> sepiaFilter = InstagramFilters::apply;

        Function<Image, Image> brightnessFilter = img -> {
            img.setDescription(img.getDescription() + " (Brightness increased)");
            return img;
        };
        Image grayscaleImage = FilterProcessor.applyFilter(image, grayscaleFilter);
        System.out.println(grayscaleImage);

        Function<Image, Image> combinedFilter = FilterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = FilterProcessor.applyFilter(image, combinedFilter);
        System.out.println(combinedImage);

        Function<Image, Image> allFilters = FilterProcessor.combineFilters(combinedFilter, brightnessFilter);
        Image finalImage = FilterProcessor.applyFilter(image, allFilters);
        System.out.println(finalImage);
    }

    private static Image apply(Image img) {
        img.setDescription(img.getDescription() + " (Sepia applied)");
        return img;
    }
}