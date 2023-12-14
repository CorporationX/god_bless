package faang.school.godbless.BJS2_914;

import java.util.function.Function;

public class FilterProcessor {
    public static void main(String[] args) {
        Image image1 = new Image("faang.jpg", "sunrise");

        Function<Image, Image> filter1 = picture -> {
            return new Image(picture.getFileName(), picture.getDescription()+" VIGNETTE");
        };
        Function<Image, Image> filter2 = picture -> {
            return new Image(picture.getFileName(), picture.getDescription()+" VOGUE NOIR");
        };

        System.out.println(applyFilter(image1, filter1));
        Function<Image, Image> newFilter = combineFilters(filter1, filter2);
        System.out.println(applyFilter(image1, newFilter));
    }

    public static Image applyFilter(Image image, Function<Image, Image> functionFilter){
        return functionFilter.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> function, Function<Image, Image> anotherFunciton){
        return function.andThen(anotherFunciton);
    }
}
