package school.faang.instagramfilter;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getFileName(), image.getDescription() +
                " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getFileName(), image.getDescription() +
                " | Фильтр : сепия");
        Function<Image, Image> vinietkaFilter = image -> new Image(image.getFileName(), image.getDescription() +
                " | Фильтр : виньетка");

        Image greyscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(greyscaleImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vinietkaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
