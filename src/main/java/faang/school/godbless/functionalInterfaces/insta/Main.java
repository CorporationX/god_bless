package faang.school.godbless.functionalInterfaces.insta;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image originalImage = new Image("image", ".png", "Yet another selfie");

        Function<Image, Image> inverseFilter = (image) -> filterProcessor.filtering(image, "_inverse", " with inverse filter on");
        Function<Image, Image> saturationFilter = (image) -> filterProcessor.filtering(image, "_saturated", " with saturation filter applied");
        Function<Image, Image> blurFilter = (image) -> filterProcessor.filtering(image, "_blurred", " with blur filter applied");

        Image imageWithFilter = filterProcessor.applyFilter(originalImage, inverseFilter);

        System.out.println(imageWithFilter);

        System.out.println();

        var doubleFilter = filterProcessor.combineFilters(saturationFilter, blurFilter);

        Image imageWithDoubleFilter = filterProcessor.applyFilter(originalImage, doubleFilter);

        System.out.println(imageWithDoubleFilter);
    }
}
