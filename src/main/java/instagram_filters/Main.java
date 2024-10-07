package instagram_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image original = new Image("image.png", "This is original image.png");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(original, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(original, combinedFilter);
        System.out.println(combinedImage.getDescription());}
}
