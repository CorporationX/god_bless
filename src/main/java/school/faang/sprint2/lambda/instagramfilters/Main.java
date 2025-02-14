package school.faang.sprint2.lambda.instagramfilters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image myImage = new Image("my foto", "I am at the sea. ");
        FilterProcessor filterProcessor = new FilterProcessor();
        Image afterFilterImage = filterProcessor.applyFilter(myImage,
                (image) -> new Image(image.getName(), image.getDescription()
                        + "\nAdded a filter: sepia."));
        System.out.println(afterFilterImage);
        System.out.println();
        Function<Image, Image> grayScaleFilter = (image) -> new Image(image.getName(),
                image.getDescription() + "\nAdded a grayscale filter.");
        Function<Image, Image> mexicanVibesFilter = (image) -> new Image(image.getName(),
                image.getDescription() + "\nAdded a sombrero and tequila in hand");
        Function<Image, Image> combineFilter = filterProcessor.combineFilters(grayScaleFilter, mexicanVibesFilter);
        Image editedImage = filterProcessor.applyFilter(myImage, combineFilter);
        System.out.println(editedImage);
    }

}
