package school.faang.instagram_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        Function<Image, Image> grayscaleFilter =
                (image) -> new Image(image.getName(),
                        image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter =
                (image) -> new Image(image.getName(),
                        image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription()); // Вывод: Оригинальное изображение | Фильтр: черно-белый

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image updatedImage =  filterProcessor.combineFilters(originalImage, grayscaleFilter, sepiaFilter);
        System.out.println(updatedImage.getDescription());
    }
}
