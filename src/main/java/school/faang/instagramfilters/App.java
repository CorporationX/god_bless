package school.faang.instagramfilters;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class App {
    public static final String IMAGE_NAME = "original.jpg";
    public static final String IMAGE_DESCRIPTION = "Оригинальное изображение";
    public static final String GRAYSCALE_DESCRIPTION = " | Фильтр: черно-белый";
    public static final String SEPIA_DESCRIPTION = " | Фильтр: сепия";

    public static void main(String[] args) {
        Image originalImage = new Image(IMAGE_NAME, IMAGE_DESCRIPTION);
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image ->
                new Image(image.getName(), image.getDescription() + GRAYSCALE_DESCRIPTION));

        Function<Image, Image> sepiaFilter = (image ->
                new Image(image.getName(), image.getDescription() + SEPIA_DESCRIPTION));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(combinedImage.getDescription());
    }
}