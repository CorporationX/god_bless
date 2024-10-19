package school.faang.bjs2_34878;

import java.util.function.Function;

public class Filters {
    public static Function<Image, Image> blackAndWhiteFilter = image -> {
        image.setDescription(image.getDescription() + " + Black & White Filter ");
        return image;
    };
    public static Function<Image, Image> sepiaFilter = image -> {
        image.setDescription(image.getDescription() + " + Sepia Filter");
        return image;
    };
    public static Function<Image, Image> vignetteFilter = image -> {
        image.setDescription(image.getDescription() + " + Vignette Filter");
        return image;
    };
}
