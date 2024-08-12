package faang.school.godbless.photoFilter;

import java.util.function.Function;

public class Main {

    private static final String SEPARATOR = "_";
    private static final String CLARENDON = "clarendon";
    private static final String GINGHAM = "gingham";
    private static final String MOON = "moon";
    private static final String LARK = "lark";

    public static void main(String[] args) {
        FilterProcessor filterProcessor = new FilterProcessor();

        Image image = new Image("test.jgp", "Test image");

        Function<Image, Image> clarendonFilter = i -> new Image(i.getName() + SEPARATOR + CLARENDON, i.getDescription() + " filter " + CLARENDON);
        Function<Image, Image> ginghamFilter = i -> new Image(i.getName() + SEPARATOR + GINGHAM, i.getDescription() + " filter " + GINGHAM);

        Image imageWithParam = filterProcessor.applyFilter(image, clarendonFilter);
        System.out.println(imageWithParam);
        imageWithParam = filterProcessor.applyFilter(image, ginghamFilter);
        System.out.println(imageWithParam);

        System.out.println();
        Image imageWithDirectFilter = filterProcessor.applyFilter(image, i -> new Image(i.getName() + SEPARATOR + MOON, i.getDescription() + " filter " + MOON));
        System.out.println(imageWithDirectFilter);

        imageWithDirectFilter = filterProcessor.applyFilter(image, i -> new Image(i.getName() + SEPARATOR + LARK, i.getDescription() + " filter " + LARK));
        System.out.println(imageWithDirectFilter);

        System.out.println();
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(clarendonFilter, ginghamFilter);
        Image imageWithCombinedFilter = filterProcessor.applyFilter(image, combinedFilter);
        System.out.println(imageWithCombinedFilter);
    }
}
