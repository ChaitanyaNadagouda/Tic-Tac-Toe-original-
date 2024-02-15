package Models;

public class Player {
    int id ;
    String playername ;
    char symbol ;
    PlayerType playertype ;

    public Player(int id, String playername, char symbol, PlayerType playertype) {
        this.id = id;
        this.playername = playername;
        this.symbol = symbol;
        this.playertype = playertype;
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
}
