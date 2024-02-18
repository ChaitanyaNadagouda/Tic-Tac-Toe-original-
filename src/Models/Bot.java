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
    @Override
    public Cell makeMove(Board board){
        System.out.println("Get Ready for GPT's Move");
        Cell cell = botPlayingStrategy.makeMove(board);
        cell.setCellstate(CellState.FILLED) ;
        cell.setPlayer(this);

        return cell ;

    }
}
