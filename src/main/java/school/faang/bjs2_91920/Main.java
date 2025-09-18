package school.faang.bjs2_91920;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackWhiteFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: виньетка");

        Image blackWhiteFilterImage = filterProcessor.applyFilter(originalImage, blackWhiteFilter);
        System.out.println(blackWhiteFilterImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(blackWhiteFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> combinedThreeFilter = combinedFilter.andThen(vignetteFilter);
        Image editedPhoto = filterProcessor.applyFilter(originalImage, combinedThreeFilter);
        System.out.println(editedPhoto.getDescription());
    }
}