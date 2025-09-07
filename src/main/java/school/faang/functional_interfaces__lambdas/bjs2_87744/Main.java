package school.faang.functional_interfaces__lambdas.bjs2_87744;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        //фильтры
        Function<Image, Image> grayscaleFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");


        // Применение фильтров
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());
        Image vignetteSepiaImage = filterProcessor.applyFilter(vignetteImage, sepiaFilter);
        System.out.println(vignetteSepiaImage.getDescription());

        // Комбинирование фильтров
        Function<Image, Image> combiFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combiFilter);
        System.out.println(combineImage.getDescription());
        Function<Image, Image> combiFilte2 = filterProcessor.combineFilters(vignetteFilter, grayscaleFilter);
        Image combineImage2 = filterProcessor.applyFilter(originalImage, combiFilte2);
        System.out.println(combineImage2.getDescription());
    }
}
