package faang.school.godbless.BJS2_8924;

import lombok.Getter;

import java.util.Date;

@Getter
public class Data {
    private Integer id;
    private String value;
    // делать timestamp нет смысла тк при удалении хвоста или замене головы мы не имеем власти
    // над остальной цепочкой, не сможем поставить предпоследний эл хвоста при его удаленни, например
    // свяжем значения указателями значения кэша
    // ссылки на след и пред элементы соответственно
    public Data next;
    public Data prev;

    public Data(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
}
