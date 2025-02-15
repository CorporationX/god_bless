package instagram;

import java.util.function.UnaryOperator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        UnaryOperator<Image> grayscaleFilter = image ->
                new Image(image.name(), image.description() + " | Filter: Grayscale");
        UnaryOperator<Image> sepiaFilter = image ->
                new Image(image.name(), image.description() + " | Filter: Sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info(grayscaleImage.description());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info(sepiaImage.description());

        UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(combinedImage.description());
    }
}
