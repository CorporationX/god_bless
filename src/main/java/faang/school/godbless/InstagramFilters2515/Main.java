package faang.school.godbless.InstagramFilters2515;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image original = new Image("Original", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> filter1 = (image) -> new Image(image.getName(), image.getDescription() + "_filter1");
        Function<Image, Image> filter2 = (image) -> new Image(image.getName(), image.getDescription() + "_filter2");
        Function<Image, Image> filter3 = (image) -> new Image(image.getName(), image.getDescription() + "_filter3");
        Function<Image, Image> combinedFilter1 = filterProcessor.combineFilters(filter1, filter3);

        System.out.println(original);
        System.out.println(filterProcessor.applyFilter(original, filter2));
        System.out.println(filterProcessor.applyFilter(original, combinedFilter1));

    }
}
