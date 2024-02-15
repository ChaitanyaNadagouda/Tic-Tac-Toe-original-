package AppRunner;

import Controllers.GameController;
import Models.Game;
import Models.Player;
import Models.PlayerType;
import WinStrategies.ColWinningStrategy;
import WinStrategies.DiagonalWinningStrategy;
import WinStrategies.RowWinningStrategy;
import WinStrategies.WinningStrategies;
import exception.DuplicateSymbolException;
import exception.MoreThanOneBotException;
import exception.PlayersCountMismatchException;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountMismatchException, MoreThanOneBotException {
        GameController gameController = new GameController();
        int dimension = 3 ;
        List<Player> playerList = new ArrayList<>() ;
        List<WinningStrategies> winningStrategies = new ArrayList<>() ;
        playerList.add(new Player(1,"Keerthi",'X', PlayerType.HUMAN)) ;
        playerList.add(new Player(2,"GPT",'O', PlayerType.BOT)) ;

        winningStrategies.add(new ColWinningStrategy()) ;
        winningStrategies.add(new DiagonalWinningStrategy()) ;
        winningStrategies.add(new RowWinningStrategy()) ;

        Game game = gameController.startGame(dimension,playerList,winningStrategies) ;
        game.printBoard();
    }
}
