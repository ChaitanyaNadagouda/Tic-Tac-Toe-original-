package botplayingstrategy;

import BotPlayingStrategies.BotPlayingStrategy;
import BotPlayingStrategies.EasyBotPlayingStrategy;
import Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        return new EasyBotPlayingStrategy() ;
    }
}
