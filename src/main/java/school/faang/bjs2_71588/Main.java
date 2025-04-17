package school.faang.bjs2_71588;

import lombok.extern.slf4j.Slf4j;
import java.util.function.Function;

@Slf4j
public class Main {
    private static final FilterProcessor FILTER_PROCESSOR = new FilterProcessor();
    private static final Function<Image, Image> BLACK_AND_WHITE_FILTER = (image) -> new Image(
            image.getName(),
            image.getDescription() + ": applied black and white filter"
    );
    private static final Function<Image, Image> INVERT_COLORS_FILTER = (image) -> new Image(
            image.getName(),
            image.getDescription() + ": applied colors inverted filter"
    );
    private static final Function<Image, Image> SEPIA_FILTER = (image) -> new Image(
            image.getName(),
            image.getDescription() + ": applied colored unknown filter"
    );
    private static final Image ORIGINAL_DOG_IMAGE = new Image("fluffy", "White dog");

    public static void main(String[] args) {
        Image filteredDogImage;
        filteredDogImage = FILTER_PROCESSOR.applyFilter(ORIGINAL_DOG_IMAGE, BLACK_AND_WHITE_FILTER);
        log.info("Now the picture \"{}\" is {}.", filteredDogImage.getName(), filteredDogImage.getDescription());
        filteredDogImage = FILTER_PROCESSOR.applyFilter(ORIGINAL_DOG_IMAGE, INVERT_COLORS_FILTER);
        log.info("Now the picture \"{}\" is {}.", filteredDogImage.getName(), filteredDogImage.getDescription());
        filteredDogImage = FILTER_PROCESSOR.applyFilter(
                ORIGINAL_DOG_IMAGE,
                FILTER_PROCESSOR.combineFilters(BLACK_AND_WHITE_FILTER, SEPIA_FILTER));
        log.info("Now the picture \"{}\" is {}.", filteredDogImage.getName(), filteredDogImage.getDescription());
    }
}
