package school.faang.BJS2_57713;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (
                image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый")
        );

        Function<Image, Image> sepiaFilter = (
                image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия")
        );

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.printf(
                "Image name: %s Description: %s ", grayscaleImage.getName(), grayscaleImage.getDescription()
        );

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.printf(
                "%nImage name: %s Description: %s ", sepiaImage.getName(), sepiaImage.getDescription()
        );

        Function<Image, Image> combineFilters = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combineFilters);
        System.out.printf(
                "%nImage name: %s Description: %s ", combineImage.getName(), combineImage.getDescription()
        );
    }
}
