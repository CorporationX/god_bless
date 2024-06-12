package faang.school.godbless.lambdas3;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "������������ �����������");

        FilterProcessor filterProcessor = new FilterProcessor();

// �������� ��������
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.name() + "_grayscale", "������: �����-�����");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.name() + "_sepia", "������: �����");
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.name() + "_vignette", "������: ��������");

// ���������� ��������
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

// �������� � ���������� ���������������� �������
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
    }
}