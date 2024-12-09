package school.faang.sprint_2.task_46242;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("image", "Original image");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> bwFilter = image -> {
            return new Image(image.name(), image.description() + " Filter: BW");
        };

        Function<Image, Image> sepiaFilter = image -> {
            return new Image(image.name(), image.description() + " Filter: Sepia");
        };


        Image bwImage = filterProcessor.applyFilter(originalImage, bwFilter);
        System.out.println(bwImage.description());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.description());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(bwFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combineImage.description());
    }
}
