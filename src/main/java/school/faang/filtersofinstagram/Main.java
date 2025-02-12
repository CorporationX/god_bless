package school.faang.filtersofinstagram;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {
    private static final Function<Image, Image> GRAYSCALE_FILTER = (image) ->
            new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
    private static final Function<Image, Image> SEPIA_FILTER = (image) ->
            new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
    private static final Function<Image, Image> NEGATIVE_FILTER = (image) ->
            new Image(image.getName(), image.getDescription() + " | Фильтр: негатив");

    public static void main(String[] args) {
        try {
            Image originalImage = new Image("original.jpg", "Оригинальное изображение");

            FilterProcessor filterProcessor = new FilterProcessor();

            Image grayscaleImage = filterProcessor.applyFilter(originalImage, GRAYSCALE_FILTER);
            log.info(grayscaleImage.getDescription());

            Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, SEPIA_FILTER);
            log.info(sepiaImage.getDescription());

            Function<Image, Image> firstCombinedFilter = filterProcessor.combineFilters(GRAYSCALE_FILTER, SEPIA_FILTER);
            Image firstCombinedImage = filterProcessor.applyFilter(originalImage, firstCombinedFilter);
            log.info(firstCombinedImage.getDescription());

            Function<Image, Image> secondCombinedFilter =
                    filterProcessor.combineFilters(firstCombinedFilter, NEGATIVE_FILTER);
            Image secondCombinedImage = filterProcessor.applyFilter(originalImage, secondCombinedFilter);
            log.info(secondCombinedImage.getDescription());
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}
