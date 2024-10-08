package school.faang.m1s2.bsj2_34734_instagram;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FilterProcessor {
    private final Map<String, Function<Image, Image>> filters = new HashMap<>();

    public void addNewFilter(String name, Function<Image, Image> filter) {
        filters.put(name, filter);
    }

    public Image applyFilter(Image image, String filterName) {
        return filters.get(filterName).apply(image);
    }

    public Function<Image, Image> combineFilters(String filterOneName, String filterTwoName) {
        return filters.get(filterOneName).andThen(filters.get(filterTwoName));
    }
}
