package school.faang.bjs2_75935;

public class ParamValidator {
    private final StringBuilder errors = new StringBuilder();

    public ParamValidator addParam(boolean notValidated, String errorMessage) {
        if (notValidated) {
            if (!errors.isEmpty()) {
                errors.append('\n');
            }
            errors.append(errorMessage);
        }
        return this;
    }

    public void validate() {
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
    }
}
