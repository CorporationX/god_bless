package faang.school.godbless.instagram_filters;

public class Main {
    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image image = new Image("cap.jpg", "Оригинальное изображение");

        Filters<Image, Image> combinetFilter = filterProcessor.combineFilters(filterProcessor.GRAYSCALEFILTER, filterProcessor.SEPIAFILTER);
        Image combinetImage = filterProcessor.applyFilter(image, combinetFilter);

        Image image1 = filterProcessor.applyFilter(combinetImage, filterProcessor.combineFilters(filterProcessor.VIGNETTEFILTER, filterProcessor.SEPIAFILTER));

        System.out.println(image1.getName());
    }
}
