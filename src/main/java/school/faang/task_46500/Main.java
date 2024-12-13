package school.faang.task_46500;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Image image = new Image("Summer", "Original Image");
        FilterProcessor filterProcessor = new FilterProcessor();
        System.out.println(image);

        Function<Image, Image> blackWhiteFilter = (inputImage) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (inputImage) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Image originalImage = filterProcessor.applyFilter(image, blackWhiteFilter);
        System.out.println(originalImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(blackWhiteFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(image, combinedFilter);
        System.out.println(combinedImage.getDescription());

    }
}

