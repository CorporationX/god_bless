package school.faang.bjs2_85909;

import lombok.Getter;

@Getter
public class IdGenerator {
    private int currentId = 1;

    public int genNextId() {
        return currentId++;
    }
}
