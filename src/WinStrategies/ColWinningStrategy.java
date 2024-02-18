package WinStrategies;

import Models.Board;
import Models.Moves;
import jdk.swing.interop.DropTargetContextWrapper;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategies{
    Map<Integer,Map<Character,Integer>> map = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Moves moves) {

            int col = moves.getCell().getCol() ;
            char symbol = moves.getPlayer().getSymbol() ;
            if(!map.containsKey(col)){
                map.put(col,new HashMap<>()) ;
            }
            Map<Character,Integer> colMap = map.get(col) ;
            if(!colMap.containsKey(symbol)){
                colMap.put(symbol,0) ;
            }
            colMap.put(symbol,colMap.get(symbol)+1) ;
            if(board.getBoard().size()==(colMap.get(symbol))){
                System.out.println("You have won via :" + col);
                return true ;
            }
            return false ;
    }

    @Override
    public void undo(Board board, Moves lastMove) {
        int col = lastMove.getCell().getCol() ;
        char symbol = lastMove.getPlayer().getSymbol() ;
        Map<Character,Integer> colMap = map.get(col) ;
        colMap.put(symbol,colMap.get(symbol)-1) ;

    }
}
