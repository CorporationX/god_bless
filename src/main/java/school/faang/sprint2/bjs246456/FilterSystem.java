package school.faang.sprint2.bjs246456;

import java.util.function.Function;

public class FilterSystem {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = (image) ->
                new Image(image.name(), image.description() + " ⇢ Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.name(), image.description() + " ⇢ Фильтр: сепия");

        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.name(), image.description() + " ⇢ Фильтр: виньетка");

        Image blackAndWhiteImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage.description());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println("\nКОМБИНИРОВАНИЕ ФИЛЬТРОВ\n" + combinedImage.description());
    }
}