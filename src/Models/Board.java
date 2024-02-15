package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int dimension ;
    List<List<Cell>> board ;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>() ;
//        create the 2d board
        for(int i=0;i<dimension;i++){
            board.add(new ArrayList<>()) ;
//            for every inside 1d list create cells
            for(int j=0;j<dimension;j++){
                board.get(i).add(new Cell(i,j)) ;
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
