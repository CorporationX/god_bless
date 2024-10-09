package instagram.filters;

import java.util.function.Function;

public class Filters {
    public static final Function<Image, Image> grayscaleFilter = (image) -> {
        String description = image.getDescription() + " -> Черно-белый фильтр";
        return new Image(image.getName(), description);
    };

    public static final Function<Image, Image> sepiaFilter = (image) -> {
        String description = image.getDescription() + " -> Фильтр Сепия";
        return new Image(image.getName(), description);
    };

    public static final Function<Image, Image> vignetteFilter = (image) -> {
        String description = image.getDescription() + " -> Фильтр Виньетка";
        return new Image(image.getName(), description);
    };
}
