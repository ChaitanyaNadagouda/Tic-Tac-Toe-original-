package Models;

import WinStrategies.WinningStrategies;
import exception.DuplicateSymbolException;
import exception.MoreThanOneBotException;
import exception.PlayersCountMismatchException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board ;
    private int nextplayerindex ;
    private List<Player> players ;
    private Player winner ;
    private GameState gameState ;
    private List<WinningStrategies> winningStrategies ;

//    comeback and create constructors


    private Game(int dimension, List<Player> players, List<WinningStrategies> winningStrategies) {
        this.board = new Board(dimension) ;
        this.players = players;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder() ;
    }

    public void printBoard() {
        board.printBoard() ;
    }

    public static class Builder{
        private List<Player> players ;
        private List<WinningStrategies> winningStrategies ;
        private int dimension ;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0 ;
        }

        public Game build() throws MoreThanOneBotException, DuplicateSymbolException, PlayersCountMismatchException {
            /*
            1)validate oly 1 bot
            2) validate unique symbols
            3) validate dimensions and player count
             */
            validateBotCount() ;
            validateUniqueSymbolForPlayers() ;
            validateDimensionAndPlayerCount() ;
            return new Game(dimension,players,winningStrategies) ;
        }

        private void validateDimensionAndPlayerCount() throws PlayersCountMismatchException {
            if(players.size()!=(dimension-1)){
                throw new PlayersCountMismatchException() ;
            }
        }

        private void validateUniqueSymbolForPlayers() throws DuplicateSymbolException {
            Set<Character> symbols = new HashSet<>() ;
            for(Player player:players){
                if(symbols.contains(player.getSymbol())){
                    throw new DuplicateSymbolException();
                }else{
                    symbols.add(player.getSymbol()) ;
                }
            }
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0 ;
            for(Player player:players){
                if(player.getPlayertype().equals(PlayerType.BOT)){
                    botCount++ ;
                }
            }
            if(botCount>1){
                throw new MoreThanOneBotException() ;
            }
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this ;
        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this ;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this ;
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getNextplayerindex() {
        return nextplayerindex;
    }

    public void setNextplayerindex(int nextplayerindex) {
        this.nextplayerindex = nextplayerindex;
    }

    public List<Player> getPlayerslist() {
        return players;
    }

    public void setPlayerslist(List<Player> players) {
        this.players = players;
    }

    public Player getWinningplayer() {
        return winner;
    }

    public void setWinningplayer(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
