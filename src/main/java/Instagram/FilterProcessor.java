package Instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFunction) {
        return imageFunction.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> image, Function<Image, Image> sepiaFilter) {
        return image.andThen(sepiaFilter);
    }

    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "������������ �����������");

        FilterProcessor filterProcessor = new FilterProcessor();

        // �������� ��������
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "������: �����-�����");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "������: �����");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "������: ��������");

        // ���������� ��������
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        // �������� � ���������� ���������������� �������
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
