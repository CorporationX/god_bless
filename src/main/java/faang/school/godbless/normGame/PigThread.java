package faang.school.godbless.normGame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PigThread extends Thread{
    @NonNull
    private String pigName;
    @NonNull
    private String material;

}
