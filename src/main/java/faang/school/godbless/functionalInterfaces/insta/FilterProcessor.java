package faang.school.godbless.functionalInterfaces.insta;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        if(originalImage == null) {
            throw new IllegalArgumentException("Original image must be non-null valued!");
        }

        if(originalImage.fileName() == null || originalImage.fileName().isBlank() || originalImage.fileExtension() == null || originalImage.fileExtension().isBlank()) {
            throw new IllegalArgumentException("Original image cannot have null or blank file name and extension!");
        }

        if(filter == null ) {
            throw new IllegalArgumentException("Filter must be non-null valued!");
        }

        return filter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        if(firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("Both filters must have non-null values!");
        }

        return firstFilter.andThen(secondFilter);
    }
}
