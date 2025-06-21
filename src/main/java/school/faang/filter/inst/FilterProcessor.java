package school.faang.instagram.filters;

import school.faang.filter.inst.Image;

import java.util.function.Function;

public class FilterProcessor {
    Image apply(Image img, Function<Image, Image> f) {
        return f.apply(img);
    }

    Function<Image, Image> combine(Function<Image, Image> a,
                                   Function<Image, Image> b) {
        return a.andThen(b);
    }
}