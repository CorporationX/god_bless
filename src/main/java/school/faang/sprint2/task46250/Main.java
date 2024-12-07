package school.faang.sprint2.task46250;

import school.faang.sprint2.task46250.model.Image;
import school.faang.sprint2.task46250.processor.FilterProcessor;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Image vignetteImage = filterProcessor.applyFilter(grayscaleImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
