package faang.school.godbless.filterinstagram;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function <Image, Image> grayscaleFilter = (image -> new Image(image.getName() + "_greyscale", "Filter: white and black"));
        Function <Image, Image> sepiaFilter = (image -> new Image(image.getName() + "_sepia", "Filter: sepia"));
        Function <Image, Image> vignetteFilter = (image -> new Image(image.getName() + "_vignette", "Filter: vignette"));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(grayscaleImage);
        System.out.println("---------------");
        System.out.println(combinedFilterImage);
    }
}
