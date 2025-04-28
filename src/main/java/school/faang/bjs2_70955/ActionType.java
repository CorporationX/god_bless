package school.faang.bjs2_70955;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActionType {
    POST("Написать пост"),
    COMMENT("Оставить комментарий"),
    LIKE("Поставить лайк"),
    SHARE("Поделиться");

    private final String title;
}
