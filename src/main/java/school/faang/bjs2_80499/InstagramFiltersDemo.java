package school.faang.bjs2_80499;

import java.util.function.Function;

public class InstagramFiltersDemo {
    public static void main(String[] args) {
        Image original = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor processor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image ->
                new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Image grayImage = processor.applyFilter(original, grayscaleFilter);
        System.out.println(grayImage.getDescription());

        Image sepiaImage = processor.applyFilter(grayImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = processor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = processor.applyFilter(original, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}

