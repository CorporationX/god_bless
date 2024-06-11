package faang.school.godbless.instagram_filters;

import lombok.NonNull;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> function) {
        Image updatedImage = function.apply(image);
        return updatedImage;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        return filterOne.andThen(filterTwo);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Function<Image, Image> myFilter = (image) -> new Image(image.getName() + "_hearts", "Фильтр: сердечки");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> anotherCombinedFilter = filterProcessor.combineFilters(grayscaleFilter, myFilter);

        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        Image myImage = filterProcessor.applyFilter(originalImage, anotherCombinedFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        System.out.println(combinedImage);
        System.out.println(myImage);
    }
}
