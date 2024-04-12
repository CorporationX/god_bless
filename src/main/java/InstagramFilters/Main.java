package InstagramFilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("оригинал.jpeg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter =
                (image -> new Image(image.getFileName() + "_grayscale", "Фильтр: черно белый"));
        Function<Image, Image> sepiaFilter =
                (image -> new Image(image.getFileName() + "_sepia", "Фильтр: сепия"));
        Function<Image, Image> vignetteFilter =
                (image -> new Image(image.getFileName() + "_vignette", "Фильтр: виньетка"));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        System.out.println(combinedImage);
    }
}
