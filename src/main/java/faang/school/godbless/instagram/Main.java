package faang.school.godbless.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> vintageFilter = (image) -> new Image(image.getName() + "_vintage", "Filter: vintage photo");
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Filter: grayscale");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Filter: vignette");

        System.out.println(filterProcessor.applyFilter(originalImage, grayscaleFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, vintageFilter));
        System.out.println(filterProcessor.applyFilter(originalImage, vignetteFilter));

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, vintageFilter);
        System.out.println(filterProcessor.applyFilter(originalImage, combinedFilter));
    }
}
