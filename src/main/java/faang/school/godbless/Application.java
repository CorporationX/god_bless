package faang.school.godbless;

import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение Filter:");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> reverseFilter = (image) -> new Image(image.getName() + "_reverse", (image.getDescription() + " reverse"));
        Function<Image, Image> mirrorFilter = (image) -> new Image(image.getName() + "_mirror", (image.getDescription() + " mirror"));


        Image mirrorImage = filterProcessor.applyFilter(originalImage, mirrorFilter);
        System.out.println(mirrorImage);

        Image reverseImage = filterProcessor.applyFilter(originalImage, reverseFilter);
        System.out.println(reverseImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(mirrorFilter, reverseFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(combinedImage);
    }
}