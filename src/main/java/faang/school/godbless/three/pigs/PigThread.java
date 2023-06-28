package faang.school.godbless.three.pigs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class PigThread extends Thread {
    private String pigName;
    private int material;
}
