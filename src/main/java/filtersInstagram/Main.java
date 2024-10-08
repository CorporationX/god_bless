package filtersInstagram;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        System.out.println(vignetteImage.getDescription());

        Function<Image, Image> firstCombinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image firstCombinedImage = filterProcessor.applyFilter(originalImage, firstCombinedFilter);
        System.out.println(firstCombinedImage.getDescription());
        Function<Image, Image> secondCombinedFilter = filterProcessor.combineFilters(vignetteFilter, sepiaFilter);
        Image secondCombinedImage = filterProcessor.applyFilter(originalImage, secondCombinedFilter);
        System.out.println(secondCombinedImage.getDescription());
    }
}
