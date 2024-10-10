package school.BJS2_33604;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {

    private String name;
    private List<Item> items;

    public Character(String name) {
        this.name = name;
        items = new ArrayList<>();
        //добавил LinkedList думая про замену в середине для улучшения производительности, там же просто ссылки переписать
        //а пока решал вспомнил про set, а тут не переделал
    }
}
