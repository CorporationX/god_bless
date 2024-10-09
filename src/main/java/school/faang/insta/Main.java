package school.faang.insta;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaller = image -> new Image(image.getName(), image.getDescripthon() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(), image.getDescripthon() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaller);
        System.out.println(grayscaleImage.getDescripthon());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaller, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescripthon());
    }
}
