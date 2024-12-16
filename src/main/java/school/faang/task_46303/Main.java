package school.faang.task_46303;

import school.faang.task_46303.entity.Image;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: Black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: Sepia");
        Function<Image, Image> vintageFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Filter: Vintage");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        Image vintageImage = filterProcessor.applyFilter(sepiaImage, vintageFilter);
        for (Image image : List.of(grayscaleImage, sepiaImage, vintageImage)) {
            System.out.println(image);
        }

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
