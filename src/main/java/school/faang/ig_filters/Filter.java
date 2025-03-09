package school.faang.ig_filters;

import java.util.function.Function;

public class Filter {

    public static Function<Image, Image> filter1() {
        return image -> {
            String previousDescr = image.getDescription();
            if (previousDescr.contains("Without")) {
                image.setDescription("Apllied first filter");
                return image;
            }
            image.setDescription(previousDescr + "\n" + "Apllied first filter");
            return image;
        };
    }

    public static Function<Image, Image> filter2() {
        return image -> {
            String previousDescr = image.getDescription();
            if (previousDescr.contains("Without")) {
                image.setDescription("Apllied second filter");
                return image;
            }
            image.setDescription(previousDescr + "\n" + "Apllied second filter");
            return image;
        };
    }
}
