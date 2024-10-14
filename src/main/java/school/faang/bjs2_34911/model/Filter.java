package school.faang.bjs2_34911.model;

import java.util.function.Function;

public class Filter {
    public static final Function<Image, Image> BLUR = image -> new Image(image.getName(), image.getDescription() + FilterDescription.BLUR);
    public static final Function<Image, Image> CONTRAST = image -> new Image(image.getName(), image.getDescription() + FilterDescription.CONTRAST);
    public static final Function<Image, Image> BRIGHTNESS = image -> new Image(image.getName(), image.getDescription() + FilterDescription.BRIGHTNESS);
}
