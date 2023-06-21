package instagram;

import java.util.function.Function;

public class Main {
    private static final FilterProcessor filterProcessor = new FilterProcessor();
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "������������ �����������");

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name() + "_grayscale", "������: �����-�����");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name() + "_sepia", "������: �����");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name() + "_vignette", "������: ��������");

        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(grayscaleImage);
        System.out.println(sepiaImage);
        System.out.println(vignetteImage);
        System.out.println(combinedImage);
    }
}
