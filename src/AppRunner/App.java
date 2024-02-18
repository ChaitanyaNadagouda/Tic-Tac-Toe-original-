package AppRunner;

import Controllers.GameController;
import Models.*;
import WinStrategies.ColWinningStrategy;
import WinStrategies.DiagonalWinningStrategy;
import WinStrategies.RowWinningStrategy;
import WinStrategies.WinningStrategies;
import exception.DuplicateSymbolException;
import exception.MoreThanOneBotException;
import exception.PlayersCountMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountMismatchException, MoreThanOneBotException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in) ;
        int dimension = 3 ;
        List<Player> playerList = new ArrayList<>() ;
        List<WinningStrategies> winningStrategies = new ArrayList<>() ;
        playerList.add(new Player(1,"Keerthi",'X', PlayerType.HUMAN)) ;
        playerList.add(new Bot(2,"GPT",'O', PlayerType.BOT,BotDifficultyLevel.EASY)) ;

        winningStrategies.add(new ColWinningStrategy()) ;
        winningStrategies.add(new DiagonalWinningStrategy()) ;
        winningStrategies.add(new RowWinningStrategy()) ;

        Game game = gameController.startGame(dimension,playerList,winningStrategies) ;
        while(game.getGameState().equals(GameState.INPROG)){
            /*
            1) print it
            do you want to undo ?
            2) make move
             */
            game.printBoard();
            System.out.println("Does anyone want to undo(Y/ N) ");
            String undo = scanner.next();
            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue ;
            }
            gameController.makeMove(game) ;
        }
        if(GameState.CONCLUDED.equals(game.getGameState())){
            System.out.println(game.getWinningplayer().getPlayername()+ " , Congrats! You Won the Game");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("ITS DRAW, Match Tied");
        }
    }
}
