package school.faang.BJS2_80637;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        Image unOriginalImage = new Image("unoriginal.jpg", "Вторичное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> brightnessFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: прозрачность");
        Function<Image, Image> blurFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: Блюр");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Image brightnessImage = filterProcessor.applyFilter(unOriginalImage, brightnessFilter);
        System.out.println(brightnessImage.getDescription());

        Image blurImage = filterProcessor.applyFilter(brightnessImage, blurFilter);
        System.out.println(blurImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());

        Function<Image, Image> brightnessBlurFilter = filterProcessor.combineFilters(blurFilter, brightnessFilter);
        Image brightnessBlurImaged = filterProcessor.applyFilter(unOriginalImage, brightnessBlurFilter);
    }
}
