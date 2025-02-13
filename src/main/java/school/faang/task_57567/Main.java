package school.faang.task_57567;

import java.util.function.Function;

public class Main {
    private static final String GRAYSCALE_DESCRIPTION = " | Filter: Black and white";
    private static final String SEPIA_DESCRIPTION = " | Filter: Sepia";
    private static final String VIGNETTE_DESCRIPTION = " | Filter: Vignette";

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "The original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getName(), image.getDescription() +
                GRAYSCALE_DESCRIPTION);
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(), image.getDescription() +
                SEPIA_DESCRIPTION);
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName(), image.getDescription() +
                VIGNETTE_DESCRIPTION);

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}