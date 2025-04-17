package school.faang.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Image, Image> grayscaleFilter =
                image -> new Image(image.getName(), image.getDescription() + " Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter =
                image -> new Image(image.getName(), image.getDescription() + " Фильтр: сепия");

        Function<Image, Image> vignetteFilter =
                image -> new Image(image.getName(), image.getDescription() + " Фильтр: виньетка");

        Image originalImage = new Image("original.jpg", "Оригинальное изображение ");

        FilterProcessor processor = new FilterProcessor();

        Image grayscale = processor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscale.getDescription());

        Image sepia = processor.applyFilter(grayscale, sepiaFilter);
        System.out.println(sepia.getDescription());

        Function<Image, Image> combined = processor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = processor.applyFilter(originalImage, combined);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> fullCombo = processor
                .combineFilters(grayscaleFilter, sepiaFilter)
                .andThen(vignetteFilter);
        Image finalImage = processor.applyFilter(originalImage, fullCombo);
        System.out.println(finalImage.getDescription());
    }
}

