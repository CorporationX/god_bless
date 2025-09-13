package school.faang.bjs2_87898;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Original image");

        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + "Filter: Grayscale filter");
        
    }
}