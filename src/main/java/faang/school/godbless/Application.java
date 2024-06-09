package faang.school.godbless;

import java.util.function.Function;

public class Application {

    public static void main(String[] args) {
        Image image = new Image("File.png", "Original Image");
        ImageProcessor imageProcessor = new ImageProcessor();
        Filter grayscaleFilter = new Filter("_grayscale", "Filter: Grayscale");
        Filter sepiaFilter = new Filter("_sepia", "Filter: sepia");
        Filter vignetteFilter = new Filter("_vignette", "Filter: Vignette");
        Function<Image, Image> combineFilters = imageProcessor.combineFilters(sepiaFilter, vignetteFilter, grayscaleFilter);
        imageProcessor.applyFilter(image, grayscaleFilter.getFilter());
        imageProcessor.applyFilter(image, sepiaFilter.getFilter());
        imageProcessor.applyFilter(image, vignetteFilter.getFilter());
        imageProcessor.applyFilter(image, combineFilters);
    }
}