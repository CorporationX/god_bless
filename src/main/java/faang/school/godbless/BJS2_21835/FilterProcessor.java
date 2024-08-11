package faang.school.godbless.BJS2_21835;

import java.util.function.Function;

public class FilterProcessor {

    public static void applyFilter(Image image, Function<Image, Image> filter){
        System.out.println(filter.apply(image));
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2){
        return filter1.andThen(filter2);
    }
}
