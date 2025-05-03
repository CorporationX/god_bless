package school.faang.wow;

import lombok.Getter;

@Getter
public enum RewardType {
    SILVER(100), GOLD(50);
    private final int prize;

    RewardType(int prize) {
        this.prize = prize;
    }
}
