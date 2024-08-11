package com.functional.insta;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        if(image == null){
           return null;
        }
        return function.apply(image);
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> functionFirst, Function<Image, Image> functionSecond ) {
        return functionFirst.andThen(functionSecond);
    }
}
