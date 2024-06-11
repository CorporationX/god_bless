package faang.school.godbless.Task_Instagram_Filter;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Original image");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName()
                + " grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName()
                + " sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName()
                + " vignette", "Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter1 = filterProcessor.combineFilters(grayscaleFilter, vignetteFilter);
        Function<Image, Image> combinedFilter2 = filterProcessor.combineFilters(vignetteFilter, sepiaFilter);
        Image combinedImage1 = filterProcessor.applyFilter(originalImage, combinedFilter1);
        Image combinedImage2 = filterProcessor.applyFilter(originalImage, combinedFilter2);
        System.out.println(combinedImage1);
        System.out.println(combinedImage2);

    }
}
