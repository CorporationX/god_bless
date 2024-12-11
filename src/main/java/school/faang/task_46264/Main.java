package school.faang.task_46264;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                String.format("%s | %s", image.getDescription(), Filters.GRAYSCALE.toString()));
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                String.format("%s | %s", image.getDescription(), Filters.SEPIA.toString()));
        Function<Image, Image> vignette = (image) -> new Image(image.getName(),
                String.format("%s | %s", image.getDescription(), Filters.VIGNETTE.toString()));

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vignetteImage = filterProcessor.applyFilter(sepiaImage, vignette);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
