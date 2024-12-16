package school.faang.task_44559.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class SpellEvent {
    private int id;
    private SpellType type;
    private String description;
}
