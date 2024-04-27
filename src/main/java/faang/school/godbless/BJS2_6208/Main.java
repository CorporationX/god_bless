package faang.school.godbless.BJS2_6208;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");
        ArrayList<Image> images = new ArrayList<>();

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image("grayscale_" + image.getName(), "Filter: grayscale");
        Function<Image, Image> sepiaFilter = (image) -> new Image("sepia_" + image.getName(), "Filter: sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image("vignette_" + image.getName(), "Filter: vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        images.add(grayscaleImage);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        images.add(sepiaImage);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        images.add(vignetteImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        images.add(combinedImage);

        for (Image image : images) {
            System.out.println(image.toString());
        }
    }
}
