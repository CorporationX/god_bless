package faang.school.godbless.BJS210929;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial  {

    private String trialName;

    public void pass(Knight knight) {
        try {
            System.out.println(String.format("Рацарь %s начинает испытание %s ", knight.getName(), trialName));
            Thread.sleep(5000);
            System.out.println(String.format("Рацарь %s заканчивает испытание %s ", knight.getName(), trialName));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
