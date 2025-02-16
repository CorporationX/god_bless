package school.faang;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("photo.jpg", null);
        FilterProcessor filterProcessor = new FilterProcessor();

        Image baw = filterProcessor.applyFilter(image, Filter.blackAndWhite());
        System.out.println(baw.getDescription());

        Image sepia = filterProcessor.applyFilter(image, Filter.blackAndWhite());
        System.out.println(sepia.getDescription());

        Function<Image, Image> comboFilter = filterProcessor.combineFilters(Filter.blackAndWhite(), Filter.sepia());
        Image comboImage = filterProcessor.applyFilter(image, comboFilter);
        System.out.println(comboImage.getDescription());
    }
}
