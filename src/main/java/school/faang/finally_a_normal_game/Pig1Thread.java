package school.faang.finally_a_normal_game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig1Thread extends PigThread{
    public Pig1Thread() {
        super("Nif-Nif", "straw");
    }

    @Override
    public void run(){
      buildHouse(2000);
    }
}
