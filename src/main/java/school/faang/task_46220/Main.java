package school.faang.task_46220;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_46220.model.Image;

import java.util.function.Function;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> {
            return new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        };
        Function<Image, Image> sepiaFilter = (image) -> {
            return new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
        };

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.getDescription());
    }
}
