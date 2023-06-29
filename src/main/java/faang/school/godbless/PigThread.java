package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private int material;
    private static final List<String> MATERIALS = List.of("соломы", "палок", "кирпичей");

    @Override
    public void run(){
        System.out.printf("%s начал строить свой дом из %s \n", getPigName(), MATERIALS.get(getMaterial()));
        try {
            Thread.sleep(1000L *getMaterial());
            System.out.printf("%s все ещё строит свою хату !\n", getPigName());
            Thread.sleep(4000L *getMaterial());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s наконец достроил хату из %s !\n", getPigName(), MATERIALS.get(getMaterial()));
    }
}
