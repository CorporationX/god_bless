package school.faang.ig_filters;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image image = new Image("Sea", "Without filters");
        System.out.println(image);
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> combinedFilters = filterProcessor.combineFilters(Filter.filter1(), Filter.filter2());
        combinedFilters.apply(image);
        System.out.println(image);

        filterProcessor.applyFilter(image, img -> {
            String previousDescr = img.getDescription();
            img.setDescription(previousDescr + "\n" + "Vinietka applied");
            return img;
        });

        System.out.println(image);
    }
}
