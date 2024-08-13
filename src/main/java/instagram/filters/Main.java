package instagram.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayScaleFilter = (image) -> new Image(
                image.getFileName().split("\\.")[0] +
                        "_grayscale" + "." + image.getFileName().split("\\.")[1],
                image.getDescription() + " Grayscale filter");
        Function<Image, Image> sepiaFilter = (image) -> new Image(
                image.getFileName().split("\\.")[0] +
                        "_sepia" + "." + image.getFileName().split("\\.")[1],
                image.getDescription() + " Sepia filter");
        Function<Image, Image> vignetteFilter = (image) -> new Image(
                image.getFileName().split("\\.")[0] +
                        "_vignette" + "." + image.getFileName().split("\\.")[1],
                image.getDescription() + " Vignette filter");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayScaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        var combinedFilter = filterProcessor.combineFilter(grayScaleFilter, sepiaFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedFilterImage);
    }
}
