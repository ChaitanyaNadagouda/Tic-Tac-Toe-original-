package WinningStrategies;

import Models.Board;
import Models.Moves;

public interface WinningStrategies {
    boolean checkWinner(Board board, Moves moves) ;
}
