package faang.school.godbless.filters;

import java.util.Objects;
import java.util.function.Function;

public class FilterProcessor {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        System.out.println(grayscaleImage.getName() + " / " + grayscaleImage.getDescription());
        System.out.println(sepiaImage.getName() + " / " + sepiaImage.getDescription());
        System.out.println(vignetteImage.getName() + " / " + vignetteImage.getDescription());

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println("\nCombined filters:");
        System.out.println(combinedImage.getName() + " / " + combinedImage.getDescription());
    }

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (Objects.nonNull(filter)) {
            return filter.apply(image);
        }
        return null;
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> filterOne,
            Function<Image, Image> filterTwo) {
        if (Objects.nonNull(filterOne) && Objects.nonNull(filterTwo)) {
            return filterTwo.compose(filterOne);
        }
        return null;
    }

}

