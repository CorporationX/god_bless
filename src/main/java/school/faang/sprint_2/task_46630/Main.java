package school.faang.sprint_2.task_46630;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: сепия");
        Function<Image, Image> negativeFilter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: негатив");
        Function<Image, Image> makeUpFilter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: мейкап");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.description());
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.description());
        Function<Image, Image> multiFilter = filterProcessor.combineFilters(
                makeUpFilter, grayscaleFilter, sepiaFilter, negativeFilter);
        Image multiFilteredImage = filterProcessor.applyFilter(originalImage, multiFilter);
        System.out.println(multiFilteredImage.description());
    }
}
