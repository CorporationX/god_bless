package school.faang.bjs2_70584;

import java.util.function.UnaryOperator;

/**
 * Задача "Фильтры Instagram"
 */
public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        UnaryOperator<Image> grayscaleFilter =
                image -> new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        UnaryOperator<Image> sepiaFilter =
                image -> new Image(image.name(), image.description() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Image sepiaGrayscaleImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaGrayscaleImage.description());

        UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
    }
}
