package school.faang.sprint_2.task_bjs246345;

import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg").addNewDescription(ImageDescription.ORIGINAL_IMAGE);
        FilterProcessor filterProcessor = new FilterProcessor();

        UnaryOperator<Image> grayscaleFilter = image ->
                image.addNewDescription(ImageDescription.FILTER_BLACK_WHITE);
        UnaryOperator<Image> sepiaFilter = image ->
                image.addNewDescription(ImageDescription.FILTER_SEPIA);

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        System.out.println(grayscaleImage.descriptions());

        Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
        System.out.println(sepiaImage.descriptions());

        UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage.descriptions());
    }
}
