package school.faang.instafilteres;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image ->
                new Image(image.name(), image.description() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info("Применение первого фильтра - {}", grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info("Примененин второго фильтра - {}", sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info("Примененин комбинации фильтров - {}", combinedImage.description());
    }
}
