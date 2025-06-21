package school.faang.bjs280542;

import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        UnaryOperator<Image> grayFilter =
                image -> new Image(image.getName(), image.getDescription() + "| Фильтр: серый.");
        UnaryOperator<Image> sepiaFilter =
                image -> new Image(image.getName(), image.getDescription() + " Фильтр: сепия");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayFilter);
        log.info(grayscaleImage.getDescription());
        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        log.info(sepiaImage.getDescription());
        UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(combinedImage.getDescription());
    }
}
