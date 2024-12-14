package school.faang.sprint_2.task_46228;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image)
                -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image)
                -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> redFilter = (image)
                -> new Image(image.getName(), image.getDescription() + " | Фильтр: красный");
        Function<Image, Image> blueFilter = (image)
                -> new Image(image.getName(), image.getDescription() + " | Фильтр: синий");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> mixFilter = filterProcessor
                .combineFilters(grayscaleFilter, sepiaFilter, redFilter, blueFilter);
        Image mixImage = filterProcessor.applyFilter(originalImage, mixFilter);
        System.out.println(mixImage.getDescription());
    }
}
//