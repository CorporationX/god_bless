package bjs2_34830;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image img = new Image("img1.jpg", "desc1");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> filter1 = image ->
                new Image(image.getName(), image.getDescription() + " - filter1");
        Function<Image, Image> filter2 = image ->
                new Image(image.getName(), image.getDescription() + " - filter2");

        Image img1 = filterProcessor.applyFilter(img, filter1);
        Image img2 = filterProcessor.applyFilter(img, filter2);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(filter1, filter2);
        Image img3 = filterProcessor.applyFilter(img, combinedFilter);

        System.out.println(img1);
        System.out.println(img2);
        System.out.println(img3);
    }
}
