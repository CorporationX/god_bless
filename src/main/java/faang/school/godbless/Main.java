package faang.school.godbless;

import faang.school.godbless.InstagramFilters.FilterProcessor;
import faang.school.godbless.Media.Image;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("photo.jpg", "A beautiful sunset.");

        FilterProcessor processor = new FilterProcessor();

        Function<Image, Image> filterUpperCase = img -> new Image(img.getName(), img.getDescription().toUpperCase());

        Function<Image, Image> filterAddActiveTag = img -> new Image(img.getName(), img.getDescription() + " - Active");

        Image processedImage1 = processor.applyFilter(image, filterAddActiveTag);
        System.out.println(processedImage1);

        Image processedImage2 = processor.applyFilter(image, filterUpperCase);
        System.out.println(processedImage2);

        Function<Image, Image> combinedFilter = processor.combineFilters(filterAddActiveTag, filterUpperCase);
        Image combinedImage = processor.applyFilter(image, combinedFilter);
        System.out.println(combinedImage);


    }
}
