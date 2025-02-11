package school.faang.filtersofinstagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        try {
            Image originalImage = new Image("original.jpg", "Оригинальное изображение");

            FilterProcessor filterProcessor = new FilterProcessor();

            Function<Image, Image> grayscaleFilter = (image) ->
                    new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
            Function<Image, Image> sepiaFilter = (image) ->
                    new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
            Function<Image, Image> negativeFilter = (image) ->
                    new Image(image.getName(), image.getDescription() + " | Фильтр: негатив");

            Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
            System.out.println(grayscaleImage.getDescription());

            Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
            System.out.println(sepiaImage.getDescription());

            Function<Image, Image> firstCombinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
            Image firstCombinedImage = filterProcessor.applyFilter(originalImage, firstCombinedFilter);
            System.out.println(firstCombinedImage.getDescription());

            Function<Image, Image> secondCombinedFilter =
                    filterProcessor.combineFilters(firstCombinedFilter, negativeFilter);
            Image secondCombinedImage = filterProcessor.applyFilter(originalImage, secondCombinedFilter);
            System.out.println(secondCombinedImage.getDescription());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
