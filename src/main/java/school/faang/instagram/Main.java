package school.faang.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Image, Image> functionSepia = image ->
                new Image(image.getName(), image.getDescription() + ", add sepia");
        Function<Image, Image> functionBlackWhite = image ->
                new Image(image.getName(), image.getDescription() + ", add Black-White");
        Function<Image, Image> functionSpirit = image ->
                new Image(image.getName(), image.getDescription() + ", add Spirit");

        Image image1 = new Image("original", "Original image");
        Image image2 = new Image("new jpg", "here is empty");
        FilterProcessor filter = new FilterProcessor();

        image1 = filter.applyFilter(image1, filter.combineFilters(functionBlackWhite, functionSepia));
        image2 = filter.applyFilter(image2, functionSpirit);

        System.out.println(image1);
        System.out.println(image2);

    }
}
