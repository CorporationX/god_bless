package faang.school.godbless.BJS2_21835;

import java.util.function.Function;

public class FilterProcessor {

    public static void applyFilter(Image image, Function<Image, Image> filter){
        if (image == null){
            throw new IllegalArgumentException("Image must by chosen");
        }
        if (filter == null){
            throw new IllegalArgumentException("Filter must be chosen");
        }
        System.out.println(filter.apply(image));
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2){
        if(filter1 == null || filter2 == null){
            throw new IllegalArgumentException("Filter must be chosen");
        }
        return filter1.andThen(filter2);
    }
}
