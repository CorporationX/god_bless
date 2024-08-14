package faang.school.godbless.instagramfilters;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("upload_image", "original image");
        
        FilterProcessor filterProcessor = new FilterProcessor();
        
        Function<Image, Image> grayScaleFilter = image -> new Image(
                image.getFileName() + "_grayscale", image.getDescription() + " grayscale filter");
        Function<Image, Image> sepiaFilter = image -> new Image(
                image.getFileName() + "_sepia", image.getDescription() + " sepia filter");
        Function<Image, Image> vignetteFilter = image -> new Image(
                image.getFileName() + "_vignette", image.getDescription() + " vignette filter");
        
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayScaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        
        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilter(grayScaleFilter, sepiaFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedFilterImage);
    }

}
