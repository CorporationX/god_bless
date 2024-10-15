package school.faang.bjs2_34878;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor processor1 = new FilterProcessor();
        FilterProcessor processor2 = new FilterProcessor();

        Image image = new Image("photo.jpg", "Before photo");

        Image bwImage = processor1.applyFilter(image, Filters.blackAndWhiteFilter);

        Function<Image, Image> combinedFilter = processor2.combineFilter(Filters.blackAndWhiteFilter, Filters.sepiaFilter);

        Image finalImage = processor2.applyFilter(image, combinedFilter);
        System.out.println("After combining Filters ; "+ finalImage.getDescription());
    }
}
