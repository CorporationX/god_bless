package faang.school.godbless.instFilters;

import java.util.ArrayList;
import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    //расширил функционал данного метода: вместо двух функций можно передать сколько угодно
    public Function<Image, Image> combineFilters(Function<Image, Image>...functions) {
        return (image) -> {
            String description = "";
            for (Function<Image,Image> function : functions) {
                image = function.apply(image);
                description += " " + image.getDescription();
            }
            image.setDescription(description);
            return image;
        };
    }
}
