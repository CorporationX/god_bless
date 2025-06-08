package school.faang.bjs2_80403;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Me.jpg", "Original photo");

        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> retroFilter = image -> new Image(image.getName(),
                image.getDescription() + ". Retro style");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(),
                image.getDescription() + ". Sepia style");
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName(),
                image.getDescription() + ". Vignette style");

        Image retroImage = filterProcessor.applyFilter(originalImage, retroFilter);
        System.out.println(retroImage.getDescription());

        Function<Image, Image> combineFilters = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image conbineImage = filterProcessor.applyFilter(originalImage, combineFilters);
        System.out.println(conbineImage.getDescription());
    }
}
