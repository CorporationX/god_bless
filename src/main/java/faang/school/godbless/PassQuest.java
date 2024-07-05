package faang.school.godbless;

@FunctionalInterface
interface PassQuest {
    PlayerQuest changePlayer(PlayerQuest player, Quest quest);
}
