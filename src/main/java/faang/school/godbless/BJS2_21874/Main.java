package faang.school.godbless.BJS2_21874;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");
        System.out.println(originalImage);
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getFileName() +
                "_grayscale", "Filter: grayscale");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getFileName() +
                "_sepia", "Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getFileName() +
                "_vignette", "Filter: vignette");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        Function<Image,Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
