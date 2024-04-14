package faang.school.godbless.Instagram_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("myFoto", "My wedding photo");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = img -> {
            return new Image(img.getFileName() + "_grayscale", "Filter: black and white");
        };
        Function<Image, Image> sepiaFilter = img -> {
            return new Image(img.getFileName() + "_sepia", "Filter: sepia");
        };
        Function<Image, Image> vignetteFilter = img -> {
            return new Image(img.getFileName() + "_vignette", "Filter: vignette");
        };

        Image grayscaleImage = filterProcessor.applyFilter(image, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(image, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(image, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(image, combinedFilter);
    }
}