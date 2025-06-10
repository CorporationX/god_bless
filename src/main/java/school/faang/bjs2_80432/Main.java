package school.faang.bjs2_80432;

import lombok.extern.slf4j.Slf4j;
import java.util.function.Function;

@Slf4j
public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image myWorkSideImage = new Image("My work side", "Оригинал");

        Function<Image, Image> blackWhiteFilter = image -> {
            String imageDescription = image.getDescription() == null ? "Исходное" : image.getDescription();
            Image filteredImage = new Image(image.getName(), imageDescription + " | Фильтр: черно-белый");
            return filteredImage;
        };

        Function<Image, Image> sepiaFilter = image -> {
            String imageDescription = image.getDescription() == null ? "Исходное" : image.getDescription();
            Image filteredImage = new Image(image.getName(), imageDescription + " | Фильтр: сепия");
            return filteredImage;
        };

        Function<Image, Image> vignetteFilter = image -> {
            String imageDescription = image.getDescription() == null ? "Исходное" : image.getDescription();;
            Image filteredImage = new Image(image.getName(), imageDescription + " | Фильтр: виньетка");
            return filteredImage;
        };

        Image filteredImage = filterProcessor.applyFilter(myWorkSideImage, blackWhiteFilter);
        log.info("Обработанное фото: {}", filteredImage.getDescription());

        Function<Image, Image> mixFilter = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image mixFilteredImage = filterProcessor.applyFilter(myWorkSideImage, mixFilter);
        log.info("Обработанное несколькими фильтрами фото: {}", mixFilteredImage.getDescription());
    }
}
