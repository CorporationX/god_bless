package school.faang.sprint_2.task_46256;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Original.jpg", "Original image");
        System.out.println(originalImage.description());

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> sepiaFilter = image -> new Image(image.name(), image.description()
                + " | Filter: sepia");
        Function<Image, Image> grayscaleFilter = image -> new Image(image.name(), image.description()
                + " | Filter: grayscale");
        Function<Image, Image> vignetteFilter = image -> new Image(image.name(), image.description()
                + " | Filter: vignette");

        try {
            Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
            System.out.println(vignetteImage.description());
            Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
            System.out.println(sepiaImage.description());
            Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
            System.out.println(grayscaleImage.description());

            Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
            Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);
            System.out.println(combinedFilterImage.description());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}