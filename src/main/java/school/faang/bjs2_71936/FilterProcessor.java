package school.faang.bjs2_71936;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> modifier) {
        if (image == null) {
            log.warn("Объект image не инициализирован");
            return null;
        }

        return modifier.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second) {
        return first.andThen(second);
    }
}
