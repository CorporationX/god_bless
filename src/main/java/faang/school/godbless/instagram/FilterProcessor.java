package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public static void main(String[] args) {
        Image image = new Image("море", "без эффектов");
        Function<Image, Image> function1 = i -> new Image(i.getNameF(), "применен фильтр");
        Function<Image, Image> function2 = i -> new Image(i.getNameF(), "Наложено изображение");
        System.out.println(applyFilter(image, function1));
        System.out.println(combineFilters(function1, function2));
    }

    public static Image applyFilter(Image image, Function<Image, Image> function) {
        return function.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return function1.andThen(function2);
    }
}
