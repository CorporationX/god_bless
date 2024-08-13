package faang.school.godbless.BJS2_21878;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "original");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> blurFilter = (image) -> new Image(filterProcessor.editImageName(image.getName(), "_blur"), "blur effect");
        Function<Image, Image> sharpeningFilter = (image) -> new Image(filterProcessor.editImageName(image.getName(), "_sharpening"), "Increases the clarity and detail of the image");

        Image blurFilterImage = filterProcessor.applyFilter(originalImage, blurFilter);
        System.out.println(blurFilterImage);

        Function<Image, Image> combineFilter = filterProcessor.combineFilter(blurFilter, sharpeningFilter);
        Image blurAndShaperingFiltersImage = combineFilter.apply(originalImage);
        System.out.println(blurAndShaperingFiltersImage);
    }
}