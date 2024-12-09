package school.faang.task_46233;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image origImage = new Image("meWithBro.png", "Just image with bro");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> firstFilter = (image ->
                new Image(origImage.name(), image.description() + " -> with filter : X"));
        Function<Image, Image> secondFilter = (image ->
                new Image(origImage.name(), image.description() + " -> with filter : Y"));

        Image imageWithX = filterProcessor.applyFilter(origImage, firstFilter);
        Image imageWithY = filterProcessor.applyFilter(origImage, secondFilter);

        System.out.println(imageWithX.description());
        System.out.println(imageWithY.description());

        Function<Image, Image> combinedImage = filterProcessor.combineFilters(firstFilter, secondFilter);
        Image imageCombined = filterProcessor.applyFilter(origImage, combinedImage);

        System.out.println(imageCombined.description());
    }
}
