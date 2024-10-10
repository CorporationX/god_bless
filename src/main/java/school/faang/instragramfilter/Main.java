package school.faang.instragramfilter;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vinetkaFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vinetkaImage = filterProcessor.applyFilter(sepiaImage, vinetkaFilter);
        System.out.println(vinetkaImage.getDescription());


        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> combinedFilter2 = filterProcessor.combineFilters(combinedFilter, vinetkaFilter);
        Image combinedImage2 = filterProcessor.applyFilter(sepiaImage, combinedFilter2);
        System.out.println(combinedImage2.getDescription());

    }
}
