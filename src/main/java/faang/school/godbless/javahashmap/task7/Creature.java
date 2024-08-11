package faang.school.godbless.javahashmap.task7;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"name"})
@AllArgsConstructor
public abstract class Creature {

    protected String name;
    protected Integer level;
    protected Integer attack;
    protected Integer defence;
    protected Integer speed;
    protected final Integer defaultHp;
    protected Integer currentHp;
    protected Integer quantity;

    public abstract Integer getDamage();
}
