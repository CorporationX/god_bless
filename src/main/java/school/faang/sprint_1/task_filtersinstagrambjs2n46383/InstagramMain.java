package school.faang.sprint_1.task_filtersinstagrambjs2n46383;

import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstagramMain {
    public static void main(String[] args) {
        Logger instgramLogger = LoggerFactory.getLogger("instagramLogger");

        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        instgramLogger.info("Use single applyFilter(): {}", grayscaleImage.toString());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        instgramLogger.info("Use single applyFilter(): {}", sepiaImage.toString());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        instgramLogger.info("Use of combineFilters():  {}", combinedImage.toString());
    }
}
