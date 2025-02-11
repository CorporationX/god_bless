package school.faang.task57670.service;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("image.jpg", "оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (img ->
                new Image(img.getName(), img.getDescription() + " | Фильтр: черно-белый"));
        Function<Image, Image> sepiaFilter = (img ->
                new Image(img.getName(), img.getDescription() + " | Фильтр: сепия"));


        Image grayScaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayScaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combineFilter = filterProcessor.combinedFilters(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combineFilter);
        System.out.println(combineImage.getDescription());
    }
}
