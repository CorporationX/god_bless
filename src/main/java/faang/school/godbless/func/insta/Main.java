package faang.school.godbless.func.insta;

import java.util.function.Function;

public class Main {

    private static final String FILENAME_WITHOUT_EXTENSION_REGEX = "(?<=^|\\.)[^.]+(?=\\.)";

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "original");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> grayscaleFilter = (image) -> new Image(
                image.fileName().replaceFirst(FILENAME_WITHOUT_EXTENSION_REGEX, "$0_grayscale"),
                "B&W");
        Function<Image, Image> sepiaFilter = (image) -> new Image(
                image.fileName().replaceFirst(FILENAME_WITHOUT_EXTENSION_REGEX, "$0_sepia"),
                "sepia");
        Function<Image, Image> vignetteFilter = (image) -> new Image(
                image.fileName().replaceFirst(FILENAME_WITHOUT_EXTENSION_REGEX, "$0_vignette"),
                "vignette");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
