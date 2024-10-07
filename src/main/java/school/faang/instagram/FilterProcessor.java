package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayScaleFilter = (image) -> new Image(image.getFileName(), image.getDescription() + " | Black and white filter");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getFileName(), image.getDescription() + " | Sepia filter");

        Image grayScaleImage = filterProcessor.applyFilter(originalImage, grayScaleFilter);
        System.out.println(grayScaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayScaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayScaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }

    public static Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);
    }
}