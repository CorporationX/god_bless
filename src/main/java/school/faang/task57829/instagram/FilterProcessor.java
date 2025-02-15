package school.faang.task57829.instagram;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filer) {
        return filer.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> firstFilter,
                                                 @NonNull Function<Image, Image> secondFilter) {
        return  image -> {
            image = applyFilter(image, firstFilter);
            image = applyFilter(image, secondFilter);
            return image;
        };
    }
}
