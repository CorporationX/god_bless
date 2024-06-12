package faang.school.godbless;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ImageProcessor {
    public void applyFilter(Image image, Function<Image, Image> filter) {
        System.out.println(filter.apply(image).getFileName() + " , " + filter.apply(image).getDescription());
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        BiFunction<Function<Image, Image>, Function<Image, Image>, Function<Image, Image>> combinedFunction = Function::andThen;
        Function<Image, Image> resultFunction = combinedFunction.apply(function1, function2);
        return resultFunction;
    }

    public Function<Image, Image> combineFilters(Filter... filters) {
        Function<Image, Image> combineFilter = null;
        String suffix = "";
        String description = "";
        for (Filter filter : filters) {
            suffix = suffix.concat(filter.getSuffix());
            description = description.concat(filter.getDescription() + ", ");
        }
        description = "Applied filters: " + description.replace("Filter: ", "");
        String finalDescription = description.substring(0, description.length() - 2);
        String finalSuffix = suffix;
        combineFilter = img -> new Image(img.getFileName() + finalSuffix, finalDescription);
        return combineFilter;
    }
}
