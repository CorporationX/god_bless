package faang.school.godbless.BJS29796.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name;
    private State state;

    public User(String name) {
        this.name = name;
        this.state = State.ACTIVE;
    }

    public State changeState() {
        this.state.next(this);
        return this.state;
    }
}
