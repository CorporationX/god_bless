package school.faang.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();


        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                String.format("%s | Фильтр: черно-белый", image.getDescription()));
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                String.format("%s | Фильтр: сепия", image.getDescription()));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription()); // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        // Вывод: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия
        System.out.println(combinedImage.getDescription());
    }
}
