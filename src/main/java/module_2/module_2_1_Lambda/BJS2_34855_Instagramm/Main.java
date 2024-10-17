package module_2.module_2_1_Lambda.BJS2_34855_Instagramm;

import java.util.function.Function;

public class Main {

    public static void main(String... args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.toString());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.toString());

        Function<Image, Image> combineFilter = filterProcessor.combineFilter(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combineFilter);
        System.out.println(combineImage.toString());
    }
}
