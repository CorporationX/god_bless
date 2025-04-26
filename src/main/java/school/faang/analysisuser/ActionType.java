package school.faang.analysisuser;

import lombok.Getter;

@Getter
public enum ActionType {
    POST("Пост"),
    COMMENT("Коммент"),
    LIKE("Лайк"),
    SHARE("Репост");

    private final String name;

    ActionType(String name) {
        this.name = name;
    }
}