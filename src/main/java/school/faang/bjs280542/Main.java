package school.faang.bjs280542;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayFilter = (image -> {
            String filter = " | Фильтр: cерый";
            return new Image(image.getName(), image.getDescription() + filter);
        });
        Function<Image, Image> sepiaFilter = (image -> {
            String filter = " | Фильтр: сепия";
            return new Image(image.getName(), image.getDescription() + filter);
        });
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
