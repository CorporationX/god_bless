package school.faang.sprinttwo.analysisofuseractivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionType {
    POST,
    COMMENT,
    LIKE,
    SHARE
}