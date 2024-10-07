package school.faang.task213;

import school.faang.task213.Filter.FilterProcessor;
import school.faang.task213.image.Image;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image firstImage = new Image("firstImage", "Оригинальное изображение");
        Image secondImage = new Image("secondImage", "Оригинальное изображение");
        Image thirdImage = new Image("thirdImage", "Оригинальное изображение");

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignette = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        firstImage = FilterProcessor.applyFilter(firstImage, grayscaleFilter);
        secondImage = FilterProcessor.applyFilter(secondImage, sepiaFilter);

        System.out.println(firstImage.getDescription());
        System.out.println();
        System.out.println(secondImage.getDescription());
        System.out.println();

        Function<Image, Image> combine = FilterProcessor.combineFilters(vignette, sepiaFilter);
        thirdImage = FilterProcessor.applyFilter(thirdImage, combine);

        System.out.println(thirdImage.getDescription());
    }
}
