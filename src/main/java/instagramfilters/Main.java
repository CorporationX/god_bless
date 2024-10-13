package instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image firstImage = new Image("firstImage", "описание первой картинки");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> filter1 = image -> new Image(image.getName(),
                image.getDescription() + " | фильтр 1");
        Function<Image, Image> filter2 = image -> new Image(image.getName(),
                image.getDescription() + " | фильтр 2");
        Function<Image, Image> filter3 = image -> new Image(image.getName(),
                image.getDescription() + " | фильтр 3");

        Image firstImageAfterFilters = filterProcessor.applyFilter(firstImage, filter1);
        System.out.println(firstImageAfterFilters);
        Function<Image, Image> combinedFilters = filterProcessor.combineFilters(filter2, filter3);
        System.out.println(filterProcessor.applyFilter(firstImageAfterFilters, combinedFilters));
    }
}
