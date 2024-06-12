package faang.school.godbless;

import java.util.function.Function;

public class Application {

    public static void main(String[] args) {
        Image image = new Image("File.png", "Original Image");
        ImageProcessor imageProcessor = new ImageProcessor();
        Filter grayscaleFilter = new Filter("_grayscale", "Filter: Grayscale");
        Filter sepiaFilter = new Filter("_sepia", "Filter: sepia");
        Filter vignetteFilter = new Filter("_vignette", "Filter: Vignette");

        Function<Image, Image> grayscale = img -> new Image(img.getFileName() + "_grayscale", "Filter: Grayscale");
        Function<Image, Image> sepia = img -> new Image(img.getFileName() + "_sepia", "Filter: sepia");
        Function<Image, Image> vignette = img -> new Image(img.getFileName() + "_vignette", "Filter: Vignette");

        Function<Image, Image> combineFilters = imageProcessor.combineFilters(grayscaleFilter, sepiaFilter, vignetteFilter);
        Function<Image, Image> sequentialFunction = imageProcessor.combineFilters(grayscale, sepia);

        imageProcessor.applyFilter(image, grayscaleFilter.getFilter());
        imageProcessor.applyFilter(image, sepiaFilter.getFilter());
        imageProcessor.applyFilter(image, vignetteFilter.getFilter());
        imageProcessor.applyFilter(image, combineFilters);
        imageProcessor.applyFilter(image, sequentialFunction);
    }
}