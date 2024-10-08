package instagram.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("home.jpg", "Загруженное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = Filters.grayscaleFilter;
        Function<Image, Image> sepiaFilter = Filters.sepiaFilter;
        Function<Image, Image> vignetteFilter = Filters.vignetteFilter;

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedFilterImage.getDescription());

        Function<Image, Image> allFilters = filterProcessor.combineFilters(combinedFilter, vignetteFilter);
        Image allFiltersImage = filterProcessor.applyFilter(originalImage, allFilters);
        System.out.println(allFiltersImage.getDescription());
    }
}
