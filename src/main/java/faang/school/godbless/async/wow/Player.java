package faang.school.godbless.async.wow;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Player {

    String name;
    int level;
    int experience;

    public Player completeQuest(Quest quest) {
        this.experience += quest.reward();
        return this;
    }
}

