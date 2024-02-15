package Models;

import BotPlayingStrategies.BotPlayingStrategy;
import botplayingstrategy.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel ;
    private BotPlayingStrategy botPlayingStrategy ;

    public Bot(int id, String playername, char symbol, PlayerType playertype, BotDifficultyLevel botDifficultyLevel) {
        super(id, playername, symbol, playertype);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel) ;
    }
}
