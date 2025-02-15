package instagram;

import java.util.function.UnaryOperator;
import lombok.NonNull;

public class FilterProcessor {

    public Image applyFilter(Image image, @NonNull UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(@NonNull UnaryOperator<Image> filter1,
                                               @NonNull UnaryOperator<Image> filter2) {
        return image -> filter2.apply(filter1.apply(image));
    }
}
