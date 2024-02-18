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
    private List<Moves> moves ;

//    comeback and create constructors


    private Game(int dimension, List<Player> players, List<WinningStrategies> winningStrategies) {
        this.board = new Board(dimension) ;
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.INPROG ;
        this.nextplayerindex = 0 ;
        this.moves = new ArrayList<>() ;
    }

    public static Builder getBuilder(){
        return new Builder() ;
    }

    public void printBoard() {
        board.printBoard() ;
    }

    public void makeMove() {
        Player player = players.get(nextplayerindex);
        Cell cell = player.makeMove(board);
        Moves move = new Moves(cell, player);
        moves.add(move) ;
        if(checkWinner(move,board)){
            gameState = GameState.CONCLUDED ;
            winner = player ;
            return ;
        }
        if(moves.size()== board.getDimension()* board.getDimension()){
            gameState = GameState.DRAW ;
            return ;
        }
        nextplayerindex++ ;
        nextplayerindex = nextplayerindex%players.size() ;
    }

    private boolean checkWinner(Moves move, Board board) {
        for(WinningStrategies winningstrategy:winningStrategies){
            if(winningstrategy.checkWinner(board,move)){
                return true ;
            }
        }
        return false ;
    }

    public void undo() {
        Moves lastMove = removeLastMove();

        if (lastMove == null) return;

        updateCellandUndoStrategies(lastMove);

        updateNextPlayer();
    }

    private void updateCellandUndoStrategies(Moves lastMove) {
        Cell cell = lastMove.getCell();
        cell.setCellstate(CellState.EMPTY);
        cell.setPlayer(null);

        for(WinningStrategies winningStrategies1:winningStrategies){
            winningStrategies1.undo(board, lastMove) ;
        }
    }

    private Moves removeLastMove() {
        if(moves.size()==0){
            System.out.println("No moves to undo");
            return null;
        }
        Moves lastMove = moves.get(moves.size()-1) ;
        moves.remove(lastMove) ;
        return lastMove;
    }

    private void updateNextPlayer() {
        if(nextplayerindex!=0){
            nextplayerindex-- ;
        }else{
            nextplayerindex = players.size()-1 ;
        }
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
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
