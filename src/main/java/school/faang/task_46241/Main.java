package school.faang.task_46241;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor processor = new FilterProcessor();

        Image testImage = new Image(" Face.png ", " My photos");
        System.out.println(testImage);

        Function<Image, Image> bwFilter = (image ->
                new Image(image.getName(), image.getDescription() + " Filter BW"));
        System.out.println(processor.applyFilter(testImage, bwFilter));

        Function<Image, Image> serpiaFilter = (image ->
                new Image(image.getName(), image.getDescription() + " Filter Serpia"));
        System.out.println(processor.applyFilter(testImage, serpiaFilter));

        Function<Image, Image> combineFilter = processor.combineFilter(bwFilter, serpiaFilter);
        System.out.println(processor.applyFilter(testImage, combineFilter));
    }
}
