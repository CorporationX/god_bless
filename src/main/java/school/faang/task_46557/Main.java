package school.faang.task_46557;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("Original.jpg", "Oriiginal image");
        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> addFilterSepia = (image -> new Image(image.getName(),
                image.getDescription() + "| filter: Sepia"));
        Function<Image, Image> addFilterBlack = (image -> new Image(image.getName(),
                image.getDescription() + "| filter: Black"));
        Function<Image, Image> comboFilter = filterProcessor
                .combineFilter(addFilterBlack, addFilterSepia);

        Image comboImage = filterProcessor.applyFilter(originalImage, comboFilter);
        System.out.println(comboImage);

        Image modifiedImage = filterProcessor.applyFilter(originalImage, addFilterSepia);
        System.out.println(modifiedImage);
    }
}
