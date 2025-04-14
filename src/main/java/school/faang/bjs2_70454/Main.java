package school.faang.bjs2_70454;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("photo", "original photo");
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayScale = (source) -> new Image(source.getName(),
                source.getDescription() + " || Photo is now gray");
        Function<Image, Image> sepia = (source) -> new Image(source.getName(),
                source.getDescription() + " || Photo is now sepia");

        Image gray = filterProcessor.applyFilter(grayScale, image);
        System.out.println(gray);
        Image sep = filterProcessor.applyFilter(sepia, image);
        System.out.println(sep);
        Image both = filterProcessor.combineFilter(grayScale, sepia, image);
        System.out.println(both);
    }
}
