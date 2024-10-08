package school.faang.instafilters;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Filters {
    public static final Map<String, Function<Image, Image>> FILTERS = new HashMap<>(Map.of(
            "blackWhiteFilter",
            image -> new Image(image.getName(), image.getDescription() + "| blackWhite filter added "),
            "sepia", image -> new Image(image.getName(), image.getDescription() + "| sepia filter added "),
            "vignette", image -> new Image(image.getName(), image.getDescription() + "| vignette filter added ")
    ));
}
