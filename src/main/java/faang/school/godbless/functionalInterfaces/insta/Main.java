package faang.school.godbless.functionalInterfaces.insta;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image originalImage = new Image("image", ".png", "Yet another selfie");

        Function<Image, Image> inverseFilter = (image) -> {
            var newName = image.fileName() + "_inverse";
            var newDescription = image.description() + " with inverse filter on";

            return new Image(newName, image.fileExtension(), newDescription);
        };

        Function<Image, Image> saturationFilter = (image) -> {
            var newName = image.fileName() + "_saturated";
            var newDescription = image.description() + " with saturation filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };

        Function<Image, Image> blurFilter = (image) -> {
            var newName = image.fileName() + "_blurred";
            var newDescription = image.description() + " with blur filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };

        Image imageWithFilter = filterProcessor.applyFilter(originalImage, inverseFilter);

        System.out.println(imageWithFilter);

        System.out.println();

        var doubleFilter = filterProcessor.combineFilters(saturationFilter, blurFilter);

        Image imageWithDoubleFilter = filterProcessor.applyFilter(originalImage, doubleFilter);

        System.out.println(imageWithDoubleFilter);
    }
}
