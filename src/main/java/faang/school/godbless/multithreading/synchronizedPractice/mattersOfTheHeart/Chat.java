package faang.school.godbless.multithreading.synchronizedPractice.mattersOfTheHeart;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Chat {
    private User firstUser;
    private User secondUser;

}
