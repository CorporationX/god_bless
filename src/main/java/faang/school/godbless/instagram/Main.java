package faang.school.godbless.instagram;

import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getFileName() + "_grayscale", "Filter: black and white");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getFileName() + "_sepia", "Filter: sepia");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        for (Image i : List.of(grayscaleImage, sepiaImage, combinedImage)) {
            System.out.println(i);
        }
    }
}
