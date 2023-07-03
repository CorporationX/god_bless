package faang.school.godbless.Sprint4Future.SuperheroBattle;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pair<F, S> implements Serializable {

    final public F first;
    final public S second;

    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}

