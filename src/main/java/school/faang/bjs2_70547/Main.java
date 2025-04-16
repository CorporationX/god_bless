package school.faang.bjs2_70547;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {
    public static void main(String... arg) {
        Image originalImage = new Image("original.jpg", "original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter =
            (image) -> new Image(image.name(), image.description() + " | filter: black-white");
        Function<Image, Image> sepiaFilter =
            (image) -> new Image(image.name(), image.description() + " | filter: sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(combinedImage.description());
    }
}
