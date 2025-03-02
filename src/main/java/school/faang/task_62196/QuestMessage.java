package school.faang.task_62196;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuestMessage {
    START_QUEST("Игрок \"{}\" приступил к выполнению задания \"{}\"."),
    END_QUEST("Игрок \"{}\" выполнил задание \"{}\"."),
    INTERRUPT_QUEST("Выполнение квеста \"{}\" прервано."),
    QUEST_ERROR("Произошла ошибка при выполнении квеста \"{}\" игроком \"{}\"."),
    GAIN_EXPERIENCE("Игрок \"{}\" получил {} опыта за задание \"{}\". Текущий уровень опыта: {}.");

    private final String message;
}
