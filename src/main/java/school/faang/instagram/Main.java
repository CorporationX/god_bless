package school.faang.instagram;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class Main {

    public static void main(String[] args) {
        FilterProcessor processor = new FilterProcessor();

        Function<Image, Image> blackAndWhite = image -> {
            Image result = new Image(image.getName(),
                    image.getDescription() + ", черно-белый");
            log.info("Применен черно-белый фильтр");
            return result;
        };

        Function<Image, Image> sepia = image -> {
            Image result = new Image(image.getName(),
                    image.getDescription() + ", сепия");
            log.info("Применен фильтр сепия");
            return result;
        };

        Function<Image, Image> vignette = image -> {
            Image result = new Image(image.getName(),
                    image.getDescription() + ", виньетка");
            log.info("Применена виньетка");
            return result;
        };

        Image original = new Image("photo.jpg", "оригинал");
        log.info(original.toString());

        Image bwImage = processor.applyFilter(original, blackAndWhite);
        log.info(bwImage.toString());

        Function<Image, Image> combinedFilter =
                processor.combineFilters(blackAndWhite, sepia);

        Image sepiaImage = processor.applyFilter(original, combinedFilter);
        log.info(sepiaImage.toString());

        Function<Image, Image> tripleFilter =
                processor.combineFilters(
                        processor.combineFilters(blackAndWhite, sepia),
                        vignette);

        Image finalImage = processor.applyFilter(original, tripleFilter);
        log.info(finalImage.toString());
    }
}
