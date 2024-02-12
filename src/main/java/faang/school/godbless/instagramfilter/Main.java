package faang.school.godbless.instagramfilter;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName() + "_sepia", "Image with sepia");
        Function<Image, Image> blueFilter = image -> new Image(image.getName() + "_blue", "Image with blue");
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Function<Image, Image> bluePlusSepiaFilter = filterProcessor.combineFilters(sepiaFilter, blueFilter);
        Image bluePlusSepiaImage = filterProcessor.applyFilter(originalImage, bluePlusSepiaFilter);
    }
}
