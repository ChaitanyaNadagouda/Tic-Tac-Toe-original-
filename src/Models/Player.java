package Models;

import java.util.Scanner;

public class Player {
    int id ;
    String playername ;
    char symbol ;
    PlayerType playertype ;
    private Scanner scanner ;

    public Player(int id, String playername, char symbol, PlayerType playertype) {
        this.id = id;
        this.playername = playername;
        this.symbol = symbol;
        this.playertype = playertype;
        scanner = new Scanner(System.in) ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayertype() {
        return playertype;
    }

    public void setPlayertype(PlayerType playertype) {
        this.playertype = playertype;
    }

    public Cell makeMove(Board board) {
        System.out.println(this.playername+ ", Its your Turn to make a move , enter row and col");
        int row = scanner.nextInt() ;
        int col = scanner.nextInt() ;
        while(validateMove(row,col,board)==false){
            System.out.println(this.playername+ ", Invalid move,please try again ");
            row = scanner.nextInt() ;
            col = scanner.nextInt() ;
        }
//        no we have valid move and now make move
        Cell cell = board.getBoard().get(row).get(col) ;
        cell.setPlayer(this);
        cell.setCellstate(CellState.FILLED);

        return cell ;
    }

    private boolean validateMove(int row, int col, Board board) {
        if(row>=board.getDimension() || row<0){
            return false ;
        }
        if(col>=board.getDimension() || col<0){
            return false ;
        }
        if(CellState.FILLED.equals(board.getBoard().get(row).get(col).getCellstate())){
            return false ;
        }
        return true ;
    }
}
