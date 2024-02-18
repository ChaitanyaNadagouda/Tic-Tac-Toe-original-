package WinStrategies;

import Models.Board;
import Models.Moves;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategies{
    Map<Character,Integer> leftDisgonalMap = new HashMap<>() ;
    Map<Character,Integer> rightDisgonalMap = new HashMap<>() ;
    @Override
    public boolean checkWinner(Board board, Moves moves) {

        int row = moves.getCell().getRow() ;
        int col = moves.getCell().getCol() ;
        char symbol = moves.getPlayer().getSymbol() ;
        if(row==col){
            if(!leftDisgonalMap.containsKey(symbol)){
                leftDisgonalMap.put(symbol,0) ;
            }
            leftDisgonalMap.put(symbol,leftDisgonalMap.get(symbol)+1) ;
            if(board.getDimension()==leftDisgonalMap.get(symbol)){
                System.out.println("You have won via : left diagonal");
                return true ;
            }
//            check if cell is part of right diagonal
        }
        if((row+col)==board.getDimension()-1){
            if(!rightDisgonalMap.containsKey(symbol)){
                rightDisgonalMap.put(symbol,0) ;
            }
            rightDisgonalMap.put(symbol,rightDisgonalMap.get(symbol)+1) ;
            if(board.getDimension()==rightDisgonalMap.get(symbol)){
                System.out.println("You have won via : rightDiagonal " );
                return true ;
            }
        }
        return false ;
    }

    @Override
    public void undo(Board board, Moves lastMove) {
        int row = lastMove.getCell().getRow() ;
        int col = lastMove.getCell().getCol() ;
        char symbol = lastMove.getPlayer().getSymbol() ;
        if(row==col){
            leftDisgonalMap.put(symbol,leftDisgonalMap.get(symbol)-1) ;
        }
        if(row+col==(board.getDimension()-1)){
            rightDisgonalMap.put(symbol,rightDisgonalMap.get(symbol)-1) ;
        }
    }
}
