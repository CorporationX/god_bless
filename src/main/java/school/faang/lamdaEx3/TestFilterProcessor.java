package school.faang.lamdaEx3;

import java.util.function.Function;

public class TestFilterProcessor {
    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> {
            String newDescription = image.getDescription() + " | Фильтр: черно-белый";
            return new Image(image.getName(), newDescription);
        };

        Function<Image, Image> sepiaFilter = (image) -> {
            String newDescription = image.getDescription() + " | Фильтр: сепия";
            return new Image(image.getName(), newDescription);
        };

        Function<Image, Image> vignetteFilter = (image) -> {
            String newDescription = image.getDescription() + " | Фильтр: виньетка";
            return new Image(image.getName(), newDescription);
        };

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combinedFilter(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> fullFilter = filterProcessor.combinedFilter(combinedFilter, vignetteFilter);
        Image fullFilteredImage = filterProcessor.applyFilter(originalImage, fullFilter);
        System.out.println(fullFilteredImage.getDescription()); // Output: Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия | Фильтр: виньетка
    }
}
