package derschrank.sprint01.task07.bjstwo_44435;

import lombok.Getter;

@Getter
public enum Spell {
    LUMOS("Люмос", "Освещает кончик волшебной палочки, позволяя видеть в темноте"),
    NOX("Нокс", "Гасит свет, созданный заклинанием Люмос"),
    WINGARDIUM_LEVIOSA("Вингардиум Левиоса", "Позволяет поднять предмет в воздух и управлять его движением"),
    EXPELLIARMUS("Экспеллиармус", "Разоружает противника, выбивая палочку или оружие из его рук"),
    RIDDIKULUS("Риддикулус", "Преображает боггарта в нечто смешное, чтобы лишить его силы"),
    ACCIO("Акцио", "Притягивает к заклинателю предмет на расстоянии"),
    ALOHOMORA("Алохомора", "Открывает запертые двери и замки"),
    SCURGIFY("Скурджифи", "Используется для очистки или удаления грязи"),
    REPARO("Репаро", "Чинит поврежденные предметы"),
    TARANTALLEGRA("Таранталлегра", "Заставляет противника неконтролируемо танцевать");

    private final String nameRus;
    private final String description;

    Spell(String name, String descrition) {
        this.nameRus = name;
        this.description = descrition;
    }

    @Override
    public String toString() {
        return String.format("%s / %s - %s", name(), nameRus, description);
    }
}
