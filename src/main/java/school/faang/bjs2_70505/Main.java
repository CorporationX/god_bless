package school.faang.bjs2_70505;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(combinedImage.getDescription());
    }
}