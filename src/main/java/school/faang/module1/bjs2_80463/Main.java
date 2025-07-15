package school.faang.module1.bjs2_80463;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = image -> new Image(originalImage.getFileName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = image -> new Image(originalImage.getFileName(),
                image.getDescription() + " | Фильтр: сепия");
        Function<Image, Image> vignetteFilter = image -> new Image(originalImage.getFileName(),
                image.getDescription() + " | Фильтр: виньетка");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        log.info(grayscaleImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image sepiaAndVignetteImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        log.info(sepiaAndVignetteImage.getDescription());
    }
}