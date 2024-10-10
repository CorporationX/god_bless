package school.faang.insta;

import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    Image originalImage = new Image("original.jpg", "Original image");

    FilterProcessor filterProcessor = new FilterProcessor();

    Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
        image.getDescription() + " | Filter : grayscale");
    Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
        image.getDescription() + " | Filter : sepia");
    Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(),
        image.getDescription() + " | Filter : vignette");

    Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
    System.out.println(grayscaleImage.getDescription());

    Image vignetteImage = filterProcessor.applyFilter(grayscaleImage, vignetteFilter);
    System.out.println(vignetteImage.getDescription());

    Function<Image, Image> combinedFilter = filterProcessor.combineFilter(sepiaFilter,
        vignetteFilter);
    Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    System.out.println(combinedImage.getDescription());

  }
}
