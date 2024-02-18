package WinStrategies;

import Models.Board;
import Models.Moves;

public interface WinningStrategies {
    boolean checkWinner(Board board, Moves moves) ;

    void undo(Board board, Moves lastMove);

}
