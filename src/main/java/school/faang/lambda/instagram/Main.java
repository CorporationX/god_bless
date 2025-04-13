package school.faang.lambda.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        // Фильтры
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: сепия");
        Function<Image, Image> vinFilter = (image) -> new Image(image.name(),
                image.description() + " | Фильтр: виньетка");

        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        //Комбинирование фильтров
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Function<Image, Image> threeFilters = filterProcessor.combineFilters(vinFilter, combinedFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
        Image threeFilteredImage = filterProcessor.applyFilter(originalImage, threeFilters);
        System.out.println(threeFilteredImage.description());
    }
}
