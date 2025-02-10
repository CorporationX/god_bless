package school.faang.naughtwoBJS257722;

import java.util.function.Function;

public class FilterProcessor {


    private void checkFunction(Function<Image, Image> function) {
        try {
            if (function == null) {
                throw new IllegalArgumentException("Function is 'null'.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument " + e.getMessage());
        }
    }

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        checkFunction(filter);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        checkFunction(filter1);
        checkFunction(filter2);
        return filter1.andThen(filter2);
    }
}