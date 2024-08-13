package faang.school.godbless.BJS2_21873;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> gray = (image) -> new Image(image.getName() + " _grayscale", "Фильтр: черно-белый");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, gray);
        System.out.println(grayscaleImage.getName());
    }
}
