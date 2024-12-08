package school.faang.task46219;

import java.util.List;
import java.util.function.Function;

public class Main {

    private static final FilterProcessor FILTER_PROCESSOR = new FilterProcessor();

    public static void main(String[] args) {
        Image image = new Image("original.jpg", "Оригинальное изображение");

        List<Function<Image, Image>> filters = generateFilters();

        Image blackWhiteImage = FILTER_PROCESSOR.applyFilter(image, filters.get(0));
        System.out.println(blackWhiteImage.getDescription());

        Image sepiaImage = FILTER_PROCESSOR.applyFilter(image, filters.get(1));
        System.out.println(sepiaImage.getDescription());

        Image newImage = FILTER_PROCESSOR.applyFilter(image, filters.get(2));

        System.out.println(newImage.getDescription());

    }

    private static List<Function<Image, Image>> generateFilters() {
        Function<Image, Image> blackWhite = newImage -> new Image(newImage.getName(),
                newImage.getDescription() + " |" + Filter.BLACK_WHITE.getName());

        Function<Image, Image> sepia = newImage -> new Image(newImage.getName(),
                newImage.getDescription() + " |" + Filter.SEPIA.getName());

        Function<Image, Image> twoFilters = FILTER_PROCESSOR.combineFilters(blackWhite, sepia);

        return List.of(blackWhite, sepia, twoFilters);
    }
}
