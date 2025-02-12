package BJS257594;

import lombok.ToString;
import java.util.function.Function;

@ToString
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public  Function<Image, Image> combineFilter(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }

}
