package school.faang.bjs2_75935;

import java.util.NoSuchElementException;

public record Author(String name) {
    private static final String AUTHOR_NAME_IS_EMPTY = "Author name is empty";

    public Author {
        new ParamValidator()
            .addParam(Utils.VALIDATE_TEXT.test(name), AUTHOR_NAME_IS_EMPTY)
            .validate();
    }
}
