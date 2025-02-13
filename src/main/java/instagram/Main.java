package instagram;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image ->
                new Image(image.name(), image.description() + " | Filter: grayscale");
        Function<Image, Image> sepiaFilter = image ->
                new Image(image.name(), image.description() + " | Filter: sepia");
        Function<Image, Image> vignetteFilter = image ->
                new Image(image.name(), image.description() + " | Filter: vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info(grayscaleImage.description());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(combinedImage.description());

        Function<Image, Image> combinedAll = filterProcessor.combineFilters(combinedFilter, vignetteFilter);
        Image allFilteredImage = filterProcessor.applyFilter(originalImage, combinedAll);
        log.info(allFilteredImage.description());
    }
}
