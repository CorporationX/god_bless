package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {

        return filter.apply(image);
    }

    protected Function<Image, Image>
                    combineFilters(Function<Image, Image> grayscaleFilter,
                                   Function<Image, Image> sepiaFilter) {

        return grayscaleFilter.andThen(sepiaFilter);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image combinedFilterImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedFilterImage.getDescription());
    }
}