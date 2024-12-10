package school.faang.sprint2.task46250;

import school.faang.sprint2.task46250.model.Image;
import school.faang.sprint2.task46250.processor.FilterProcessor;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());
        Image vignetteImage = filterProcessor.applyFilter(grayscaleImage, vignetteFilter);
        System.out.println(vignetteImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
    }
}
