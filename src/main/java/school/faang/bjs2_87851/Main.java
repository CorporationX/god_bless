package school.faang.bjs2_87851;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("image1", "image1");
        FilterProcessor processor = new FilterProcessor();
        Function<Image, Image> filter1 = im -> new Image(im.getName(), "Серый " + im.getDescription());

        Function<Image, Image> filter2 = im -> new Image(im.getName(), "черно-белый " + im.getDescription());
        Function<Image, Image> filter3 = processor.combineFilters(filter1, filter2);

        System.out.println(processor.applyFilter(image, filter1));
        System.out.println(processor.applyFilter(image, filter2));
        System.out.println(processor.applyFilter(image, filter3));
    }
}
