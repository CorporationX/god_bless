package school.faang.bjs280542;

import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        UnaryOperator<Image> grayFilter =
                image -> new Image(image.getName(), image.getDescription() + "| Фильтр: серый.");
        UnaryOperator<Image> sepiaFilter =
                image -> new Image(image.getName(), image.getDescription() + " Фильтр: сепия");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
