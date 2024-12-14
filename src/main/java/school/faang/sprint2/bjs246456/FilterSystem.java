package school.faang.sprint2.bjs246456;

import java.util.function.Function;

public class FilterSystem {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " ⇢ Фильтр: черно-белый");

        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " ⇢ Фильтр: сепия");

        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " ⇢ Фильтр: виньетка");

        Image blackAndWhiteImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        System.out.println(blackAndWhiteImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println("\nКОМБИНИРОВАНИЕ ФИЛЬТРОВ\n" + combinedImage.getDescription());
    }
}