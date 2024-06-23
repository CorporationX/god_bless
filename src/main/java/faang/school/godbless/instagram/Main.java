package faang.school.godbless.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
      Image originalImage = new Image("original.jpg", "Original image");
      FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> greyScaleFilter = image -> new Image(image.fileName() + "_grayscale", "grayscale Filter");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.fileName() + "_sepia", "sepia Filter");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.fileName() + "_vignette", "vignette Filter");

        Image imageGrey = filterProcessor.applyFilter(originalImage, greyScaleFilter);
        Image imageSepia = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image imageVignette = filterProcessor.applyFilter(originalImage, vignetteFilter);

      Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
      filterProcessor.applyFilter(originalImage, combinedFilter);


    }
}
