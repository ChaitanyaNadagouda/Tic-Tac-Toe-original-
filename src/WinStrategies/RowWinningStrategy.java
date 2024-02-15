package WinStrategies;

import Models.Board;
import Models.Moves;

public class RowWinningStrategy implements WinningStrategies{
    @Override
    public boolean checkWinner(Board board, Moves moves) {
        return false;
    }
}
