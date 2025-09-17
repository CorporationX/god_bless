package school.faang.bjs2_91909;

import lombok.extern.slf4j.Slf4j;
import java.util.function.Function;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        Image firstImage = new Image(" my.jpg", " original");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> pinkFilter = (image -> new Image(image.getName(), image.getDescription()
                + " | pink filter applied"));
        Function<Image, Image> blackFilter = image -> new Image(image.getName(), image.getDescription()
                + " | black filter applied");
        log.info(String.valueOf(filterProcessor.applyFilter(firstImage, pinkFilter)));

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(blackFilter, pinkFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(firstImage, combinedFilter);
        log.info(String.valueOf(combinedFilterImage.getDescription()));
    }
}
