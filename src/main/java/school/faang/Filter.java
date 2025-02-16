package school.faang;

import java.util.function.Function;

public class Filter {

    public static Function<Image, Image> blackAndWhite() {
        return image -> {
            image.setDescription(image.getDescription() + " black and white");
            return image;
        };
    }

    public static Function<Image, Image> sepia() {
        return image -> {
            image.setDescription(image.getDescription() + " sepia");
            return image;
        };
    }

    public static Function<Image, Image> vignette() {
        return image -> {
            image.setDescription(image.getDescription() + "vignette");
            return image;
        };
    }
}
