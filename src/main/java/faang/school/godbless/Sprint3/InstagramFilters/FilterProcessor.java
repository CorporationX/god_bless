package faang.school.godbless.Sprint3.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imgFilter) {
        return imgFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> imgFilter1, Function<Image, Image> imgFilter2) {
        return imgFilter1.andThen(imgFilter2);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

// Создание фильтров
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getFileName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getFileName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getFileName() + "_vignette", "Фильтр: виньетка");

// Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// Создание и применение комбинированного фильтра
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    }
}
