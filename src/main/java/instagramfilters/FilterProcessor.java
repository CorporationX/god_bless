package instagramfilters;

import java.util.function.Function;
import java.util.logging.Logger;

public class FilterProcessor {
    private static final Logger logger = Logger.getLogger(FilterProcessor.class.getName());

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null!");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter function cannot be null!");
        }

        try {
            logger.info("Applying filter...");
            Image filteredImage = filter.apply(image);
            logger.info("Filter applied: " + filteredImage.description());
            return filteredImage;
        } catch (Exception e) {
            logger.severe("Error applying filter: " + e.getMessage());
            throw new RuntimeException("Error applying filter!", e);
        }
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        if (firstFilter == null) {
            throw new IllegalArgumentException("First filter function cannot be null!");
        }
        if (secondFilter == null) {
            throw new IllegalArgumentException("Second filter function cannot be null!");
        }
        return image -> {
            try {
                logger.info("Applying first filter...");
                Image firstFiltered = firstFilter.apply(image);
                logger.info("First filter applied: " + firstFiltered.description());

                logger.info("Applying second filter ...");
                Image secondFiltered = secondFilter.apply(firstFiltered);
                logger.info("Second filter applied: " + secondFiltered.description());

                return secondFiltered;
            } catch (Exception e) {
                logger.severe("Error applying combined filters: " + e.getMessage());
                throw new RuntimeException("Error applying combined filters!", e);
            }
        };
    }
}
