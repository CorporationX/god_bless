package hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "���������";
        String lumos = "�����";
        String expelliarmus = "�������������";

        System.out.println("��������� ��������� ��� ���������� ������!\n");

        spellCaster.cast(alohomora, (spell) -> "����� ���� ������� � ������� ���������� " + spell);
        spellCaster.cast(lumos, (spell) -> "��� ����� ��� ������ � ������� ���������� " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "��������� ���������� � ������� ���������� " + spell);
    }
}
