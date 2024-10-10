package school.faang.instagramfilter.main;

import school.faang.instagramfilter.maincode.FilterProcessor;
import school.faang.instagramfilter.maincode.Image;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (original) -> new Image(originalImage.getName(),
                originalImage.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = (original) -> new Image(originalImage.getName(),
                originalImage.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combainFilter = filterProcessor.combineFilter(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combainFilter);
        System.out.println(combineImage.getDescription());
    }
}
