package school.faang.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Original Image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Filter: black-white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Filter: Sepia");
        Function<Image, Image> frameFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Filter: Frame");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image frameImage = filterProcessor.applyFilter(sepiaImage, frameFilter);
        System.out.println(frameImage.getDescription());

        // Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> combinedFilterWithFrame = filterProcessor.combineFilters(combinedFilter, frameFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilterWithFrame);
        System.out.println(combinedImage.getDescription());
    }
}