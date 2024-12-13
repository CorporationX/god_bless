package school.faang.task_46394;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image original = new Image("original image", "original image description");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> greenFilter = (image) ->
                new Image(image.name(), image.description() + " зеленый фильтр");

        Function<Image, Image> redFilter = (image) ->
                new Image(image.name(), image.description() + " красный фильтр");

        Image greenImage = filterProcessor.applyFilter(original, greenFilter);
        System.out.println("\n" + greenImage.description());

        Image greenRedImage = filterProcessor.applyFilter(greenImage, redFilter);
        System.out.println("\n" + greenRedImage.description());

    }
}
