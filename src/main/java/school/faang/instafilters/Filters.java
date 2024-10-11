package school.faang.instafilters;

import java.util.Map;
import java.util.function.Function;

public class Filters {
    public static final Map<String, Function<Image, Image>> FILTERS = Map.of(
            "blackWhiteFilter",
            image -> new Image(image.name(), image.description() + "| blackWhite filter added "),
            "sepia", image -> new Image(image.name(), image.description() + "| sepia filter added "),
            "vignette", image -> new Image(image.name(), image.description() + "| vignette filter added ")
    );
}
