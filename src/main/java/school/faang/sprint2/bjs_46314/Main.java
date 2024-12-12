package school.faang.sprint2.bjs_46314;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class Main {
    private static final Logger logs = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.fileName(),
                image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.fileName(),
                image.description() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        logs.info(grayscaleImage.description());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        logs.info(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        logs.info(combinedImage.description());
    }
}
