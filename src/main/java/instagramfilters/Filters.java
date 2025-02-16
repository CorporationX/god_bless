package instagramfilters;

import java.util.function.Function;

public class Filters {
    public static Function<Image, Image> blackAndWhiteFilter = image -> {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null!");
        }
        return image.applyDescription(image.description() + FilterDescription.BLACK_AND_WHITE.getDescription());
    };

    public static Function<Image, Image> sepiaFilter = image -> {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null!");
        }
        return image.applyDescription(image.description() + FilterDescription.SEPIA.getDescription());
    };

    public static Function<Image, Image> vignetteFilter = image -> {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null!");
        }
        return image.applyDescription(image.description() + FilterDescription.VIGNETTE.getDescription());
    };
}