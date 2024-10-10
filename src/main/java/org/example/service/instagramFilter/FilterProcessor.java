package org.example.service.instagramFilter;

import org.example.model.instagramFilter.Image;

import java.util.function.Function;

public class FilterProcessor {
    public static Image applyFilter(Image image, Function<Image, Image> filter){
        return filter.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter){
        return firstFilter.andThen(secondFilter);
    }
}
