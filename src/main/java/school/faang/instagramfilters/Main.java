package school.faang.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image imageCar = new Image("bmv", "Red color");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> combineFilter = filterProcessor
                .combineFilters(grayscaleFilter, sepiaFilter);

        Image carGrayscaleFilter = filterProcessor.applyFilter(imageCar, grayscaleFilter);
        Image carSepiaFilter = filterProcessor.applyFilter(imageCar, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(imageCar, combineFilter);

        System.out.println(carGrayscaleFilter);
        System.out.println(carSepiaFilter);
        System.out.println(combinedImage);
    }
}
