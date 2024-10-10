package instagram.filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Vacation", "I'm in Istanbul");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackAndWhiteFilter = (image) -> new Image(image.getName(), image.getDescription() + " [B&W filter applied]");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " [Sepia filter applied]");
        Function<Image, Image> polaroidFilter = (image) -> new Image(image.getName(), image.getDescription() + " [Polaroid filter applied]");

        Image blackWhiteImage = filterProcessor.applyFilter(originalImage, blackAndWhiteFilter);
        Image combinedFiltersImage = filterProcessor.applyFilter(originalImage, filterProcessor.combineFilters(sepiaFilter, polaroidFilter));

        System.out.println(blackWhiteImage.getDescription());
        System.out.println(combinedFiltersImage.getDescription());
    }
}
