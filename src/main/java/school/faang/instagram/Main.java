package school.faang.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {


        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        Function<Image, Image> grayscaleFilter = (image) -> {
            new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
            return image;
        };
        Function<Image, Image> sepiaFilter = (image) -> {
            new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
            return image;
        };

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        // Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}