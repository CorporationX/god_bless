package faang.school.godbless.AmazonStorage2040;

import lombok.Getter;

@Getter
public enum Categories {
    HOME("HOME"),
    ELECTRONICS("ELECTRONICS"),
    FOR_CHILDREN("FOR_CHILDREN"),
    SPORT("SPORT");

    private final String category;

    Categories(String category) {
        this.category = category;
    }
}
