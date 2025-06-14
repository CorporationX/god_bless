package school.faang.bjs280542;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image -> {
            String filter = " | Фильтр: черно-белый";
            return new Image(image.getName(), image.getDescription() + filter);
        });
        Function<Image, Image> sepiaFilter = (image -> {
            String filter = " | Фильтр: сепия";
            return new Image(image.getName(), image.getDescription() + filter);
        });
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
