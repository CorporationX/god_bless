package school.faang.sprint4.task_62260;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Order {
    private static int idGenerator;
    private final int id = idGenerator++;
    @Setter
    private Status status = Status.TO_DO;
}
