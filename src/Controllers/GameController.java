package Controllers;

import Models.Game;
import Models.Player;
import WinStrategies.WinningStrategies;
import exception.DuplicateSymbolException;
import exception.MoreThanOneBotException;
import exception.PlayersCountMismatchException;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerlist , List<WinningStrategies> winningStrategies) throws DuplicateSymbolException, PlayersCountMismatchException, MoreThanOneBotException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerlist)
                .setWinningStrategies(winningStrategies)
                .build() ;
    }
    public void printBoard(Game game){
        game.printBoard() ;
    }
}
