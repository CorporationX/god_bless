package Zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Participant implements Runnable{
    private String name;

    public void joinConference(){
        System.out.println("Пользователь " + name + " присоединился к конференции");
    }


    @Override
    public void run() {

    }
}
