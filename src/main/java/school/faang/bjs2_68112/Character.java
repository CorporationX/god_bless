package school.faang.bjs2_68112;

public abstract class Character {
    private String name; //Имя;
    private Integer power; // Сила;
    private Integer agility; // Ловкость;
    private Integer intellect; // Интеллект;
    private Integer health = 100; // Здоровье. У всех персонажей по умолчанию 100.

    // Сделать в Character два конструктора:
    // один принимает только имя (и присваивает базовые значения характеристикам:
    //      5 для силы, ловкости и интеллекта, что делает его универсальным персонажем, подходящим
    // для начальных этапов игры),
    // а другой все доступные параметры, кроме здоровья — оно имеет значение по умолчанию.
    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, Integer power, Integer agility, Integer intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }
}
