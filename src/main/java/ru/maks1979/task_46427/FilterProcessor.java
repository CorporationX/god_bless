package ru.maks1979.task_46427;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image,Image> function) {

        return function.apply(image);
    }

    public Function <Image, Image> combineFilters(Function<Image,Image> firstStep, Function<Image,Image> secondStep) {
return firstStep.andThen(secondStep);
    }
}
