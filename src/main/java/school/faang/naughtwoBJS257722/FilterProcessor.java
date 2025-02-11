package school.faang.naughtwoBJS257722;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        try {
            checkImage(image);
            checkFunction(filter);
            return filter.apply(image);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument " + e.getMessage());
            return image; //если проверять на исключение здесь,
            // то необходимо что-нибудь вернуть, а что возваращать вообще...
        }
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        checkFunction(filter1);
        checkFunction(filter2);
        return filter1.andThen(filter2);
    }

    private void checkFunction(Function<Image, Image> function) {
        if (function == null) {
            throw new IllegalArgumentException("Function is 'null'.");
        }
    }

    private void checkImage(Image image) {
        if (image.getName() == null || image.getName().isBlank()
                || image.getDescription() == null || image.getDescription().isBlank()) {
            throw new IllegalArgumentException("Name or Description is 'null'.");
        }
    }
}