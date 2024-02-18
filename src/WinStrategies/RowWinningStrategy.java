package WinStrategies;

import Models.Board;
import Models.Moves;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Character,Integer>> map = new HashMap<>() ;
    @Override
    public boolean checkWinner(Board board, Moves moves) {
        int row = moves.getCell().getRow() ;
        char symbol = moves.getPlayer().getSymbol() ;
        if(!map.containsKey(row)){
            map.put(row,new HashMap<>()) ;
        }
        Map<Character,Integer> rowMap = map.get(row) ;
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol,0) ;
        }
        rowMap.put(symbol,rowMap.get(symbol)+1) ;
        if(board.getBoard().size()==(rowMap.get(symbol))){
            System.out.println("You have won via : " + row) ;
            return true ;
        }
        return false ;
    }

    @Override
    public void undo(Board board, Moves lastMove) {
        int row = lastMove.getCell().getRow() ;
        char symbol = lastMove.getPlayer().getSymbol() ;
        Map<Character,Integer> rowMap = map.get(row) ;
        rowMap.put(symbol,rowMap.get(symbol)-1) ;
    }


}
