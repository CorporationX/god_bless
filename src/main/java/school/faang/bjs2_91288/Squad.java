package school.faang.bjs2_91288;

import lombok.AllArgsConstructor;

import java.lang.reflect.Method;
import java.util.List;

@AllArgsConstructor
public class Squad<T> {
    private String name;
    private List<T> squad;

    public int calculateSquadPower() {
        int totalPower = 0;
        try {
            for (T person : squad) {
                Method getPowerMethod = person.getClass().getMethod("getPower");
                Object result = getPowerMethod.invoke(person);
                if (result instanceof Integer) {
                    totalPower += (Integer) result;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return totalPower;
    }
}
