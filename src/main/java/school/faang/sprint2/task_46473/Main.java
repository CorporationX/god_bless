package school.faang.sprint2.task_46473;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Cat", "Original Image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Фильтр чёрно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " | Фильтр сепиа");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());


    }
}