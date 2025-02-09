package school.faang.instagram;

import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        Image image = new Image("photo.jpg", "Original photo");

        Function<Image, Image> blackAndWhiteFilter = img -> {
            img.setDescription(img.getDescription() + " + Black & White");
            return img;
        };

        Function<Image, Image> sepiaFilter = img -> {
            img.setDescription(img.getDescription() + " + Sepia");
            return img;
        };

        Function<Image, Image> vignetteFilter = img -> {
            img.setDescription(img.getDescription() + " + Vignette");
            return img;
        };

        FilterProcessor processor = new FilterProcessor();

        Image filteredImageFirst = processor.applyFilter(image, blackAndWhiteFilter);
        System.out.println(filteredImageFirst);

        Image filteredImageSecond = processor.applyFilter(filteredImageFirst, sepiaFilter);
        System.out.println(filteredImageSecond);

        Function<Image, Image> combinedFilter = processor.combineFilters(blackAndWhiteFilter, vignetteFilter);
        Image filteredImage3 = processor.applyFilter(image, combinedFilter);
        System.out.println(filteredImage3);
    }
}
