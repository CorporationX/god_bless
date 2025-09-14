package school.faang.bjs2_87910;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        //filters
        Function<Image, Image> grayscaleFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: grayscale");
        Function<Image, Image> sepiaFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Filter: sepia");

        //applying filters
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Image comboImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(comboImage.getDescription());

        // Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
