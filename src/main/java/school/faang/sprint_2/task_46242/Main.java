package school.faang.sprint_2.task_46242;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("image", "original image");

        FilterProcessor filterProcessor  = new FilterProcessor();

        Function<Image, Image> bwFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " Filter: BW");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName(), image.getDescription()
                + " Filter: Sepia");


        Image bwImage = filterProcessor.applyFilter(originalImage, bwFilter);
        System.out.println(bwImage.getDescription());

        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        System.out.println(sepiaImage.getDescription());

        Function<Image, Image> combinedFilter = filterProcessor.combineFilter(bwFilter, sepiaFilter);
        Image combineImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combineImage.getDescription());
    }
}
