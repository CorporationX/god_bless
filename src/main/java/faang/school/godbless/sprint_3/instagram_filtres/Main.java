package faang.school.godbless.sprint_3.instagram_filtres;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();
        Image originalImage = new Image("original.jpg", "Original image");

        Function<Image, Image> function = image -> new Image(image.getName() + "_grayscale", "Filter: white-black");
        Image result = filterProcessor.applyFilter(originalImage, function);

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Filter: white-black");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Filter: series");

        Function<Image, Image> function1 = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image filteredImage = filterProcessor.applyFilter(originalImage, function1);

        filterProcessor.showCurrentFilter(filteredImage, consumer -> System.out.println(consumer.getName() + "-----" + consumer.getDescription()));

    }
}