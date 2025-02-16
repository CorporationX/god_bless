package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class FilterProcessor {

    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image bonk = new Image("bonk.jpg", "собака с битой");
        Image pepe = new Image("pepe.jpeg", "забавная лягушка");

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: черно-белый");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(),
                image.getDescription() + " | Фильтр: сепия");

        Image grayscaleImage = filterProcessor.applyFilter(bonk, grayscaleFilter);
        log.info(grayscaleImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedFilterImage = filterProcessor.applyFilter(pepe, combinedFilter);
        log.info(combinedFilterImage.getDescription());
    }

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}
