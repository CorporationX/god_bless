package school.faang.instagram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image image = new Image("myImage.png", "Original image");
        Function<Image, Image> grayscaleFilter = i ->
                new Image(i.getName(), i.getDescription() + " | Filter: grayscale");
        Function<Image, Image> sepiaFilter = i ->
                new Image(i.getName(), i.getDescription() + " | Filter: sepia");
        try {
            Image grayscaleImage = filterProcessor.applyFilter(image, grayscaleFilter);
            logger.info("File after apply grayscaleFilter: " + grayscaleImage.getDescription());
            Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
            logger.info("File after apply sepiaFilter: " + sepiaImage.getDescription());
            Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, grayscaleFilter);
            Image cobinedImage = filterProcessor.applyFilter(image, combinedFilter);
            logger.info("File after apply combinedFilter: " + cobinedImage.getDescription());
        } catch (IllegalArgumentException e) {
            logger.error(e.toString());
        }
    }
}
