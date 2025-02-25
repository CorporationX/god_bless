package school.faang.BJS2_62167;

public final class ConstAndMessage {
    public static final String SHUTTING_DOWN_MESSAGE = "Shutting down QuestSystem Executor...";
    public static final String PLAYER_STARTED_QUEST = "Player {} has started a new quest {}";
    public static final String PLAYER_COMPLETED_QUEST = "Player {} has completed a quest {}";
    public static final String PLAYER_EXPERIENCE_POINTS =
            "{} has completed the quest and now has {} experience points.";
    public static final String WAITING_ALL_QUESTS_FINISH = "Waiting for all quests to finish...";
    public static final String ALL_QUESTS_FINISHED = "All quests have finished.";
    public static final int SHUTTING_DOWN_TIMEOUT = 5;
    public static final int THREAD_COUNT = 2;
    public static final long QUEST_TIMEOUT = 1000;

    private ConstAndMessage() {}
}