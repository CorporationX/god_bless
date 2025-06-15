package school.faang.instafilter;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(
                image.getName(), image.getDescription() + " | Фильтр: черно-белый"
        );
        Function<Image, Image> sepiaFilter = (image) -> new Image(
                image.getName(), image.getDescription() + " | Фильтр: сепия"
        );

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info("Привенен фильтр " + grayscaleImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info("Привенен фильтр " + sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info("Привенен фильтр " + combinedImage.getDescription());
    }

}
