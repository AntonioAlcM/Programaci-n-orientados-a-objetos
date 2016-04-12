/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
public class Napakalaki {
    private Monster CurrentMonster;
    private CardDealer dealer;
    private Player CurrentPlayer;
    private ArrayList<Player> players;
    //Parte Singleton000
    private static final Napakalaki instance = new Napakalaki();
    private Napakalaki(){
        CurrentMonster=null;
        dealer=CardDealer.getInstance();
         CurrentPlayer=null;
        players=new ArrayList();
    }
    public static Napakalaki getInstance() {
        return instance;
    }
    //Fin Parte de singleton
    
    
    
    private void initPlayers(ArrayList<String> names){
       for(String nombre:names){
            players.add(new Player(nombre));
        }
    }

    private Player nextPlayer(){
        Player aux = new Player("auxiliar");
        if(CurrentPlayer==null){
              int player=(int) (Math.random()*(players.size()));
              CurrentPlayer=players.get(player);
              
        }else{
             int indice=players.indexOf(CurrentPlayer);
             if( indice+1==players.size()){
                 CurrentPlayer=players.get(0);
             }
             if(indice+1<players.size()){
                 CurrentPlayer=players.get(indice+1);
             }
            
        }
        
        return CurrentPlayer;
    }
    
    private boolean nexTurnAllowed(){
        if(this.CurrentPlayer==null){
            return true;
        }else{
            return this.CurrentPlayer.validState();
        }
    }
    
    public CombatResult developCombat(){
       CombatResult CR=CurrentPlayer.combat(CurrentMonster);
       dealer.giveMonsterBack(CurrentMonster);
       return CR;
        
    
    }
    public void discardVisibleTreasures(ArrayList<Treasure> Treasures){
        for (Treasure Treasure : Treasures) {
            CurrentPlayer.discardVisibleTreasure(Treasure);
            dealer.giveTreasureBack(Treasure);
        }
        
                
    }
    public void discardHiddenTreasures(ArrayList<Treasure> Treasures){
        for (Treasure Treasure : Treasures) {
            CurrentPlayer.discardHiddenTreasure(Treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> Treasures){
        for (Treasure Treasure : Treasures) {   
            CurrentPlayer.makeTreasureVisible(Treasure);
          
        }
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){
        boolean canI=CurrentPlayer.buyLevels(visible, hidden);
        return canI;
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        this.dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return CurrentPlayer;
    
    }
    
    public Monster getCurrentMonster(){
        return CurrentMonster;
    
    }
    
    public boolean nextTurn(){
        boolean stateOK = false;    
        stateOK=this.nexTurnAllowed();   
        if(stateOK){
            this.CurrentMonster=dealer.nextMonster();
            this.CurrentPlayer=this.nextPlayer();
            boolean dead=CurrentPlayer.isDead();
            if(dead){
                this.CurrentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result==CombatResult.WinAndWinGame;
    
    }
    @Override
    public String toString() {
        return 
        "\nNombre del jugador = " + players
        + "\nRepartidor: " + dealer
        + "\nMonstruo con el que te enfrentas: " + CurrentMonster
        + "\nJugador Actual: " + CurrentPlayer;
    }
    
    
}
