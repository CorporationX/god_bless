package faang.school.godbless.BJS2_9877;

import java.util.function.Function;

public class App {
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

        System.out.println(grayscaleImage.getName());
        System.out.println(sepiaImage.getName());
        System.out.println(vignetteImage.getName());

// �������� � ���������� ���������������� �������
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        System.out.println(combinedImage.getName());
    }
}
