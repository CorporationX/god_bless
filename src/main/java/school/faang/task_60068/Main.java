package school.faang.task_60068;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: grayscale");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: sepia");

        System.out.print("""
                Applying filters one at a time
                ----------------------------------------------------------------
                """);
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        System.out.println();

        System.out.print("""
                Applying two filters at once
                ----------------------------------------------------------------
                """);
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
