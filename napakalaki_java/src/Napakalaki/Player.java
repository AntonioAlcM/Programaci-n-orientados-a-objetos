/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author donas11
 */
public class Player {
    private boolean dead=true;
    private String name="";
    private int level=0;
    private ArrayList<Treasure> visibleTreasures= new ArrayList();
    private ArrayList<Treasure> hiddenTreasures= new ArrayList();
    
    private BadConsequence PedingBadconsecuence=null; 
    
    public Player(String name){
        this.name = name;
        this.level = 1;
    }
   
    
    private void bringToLife(){
        dead=false;
    }
    
    private int getCombatLevel(){
        int bonus=level;
            if (this.howManyVisibleTreasures(TreasureKind.necklace) >0) {
            for (Treasure visibleTreasure : visibleTreasures) {
                bonus += visibleTreasure.getMaxBonus();
            }   
            }else{
            for (Treasure visibleTreasure : visibleTreasures) {
                bonus += visibleTreasure.getMinBonus();
            }  
            }
        
        return bonus;
        
    }
    
    private void incrementLevels(int i){
       int nlevel=this.level;
       if(nlevel+i>=10){
                this.level=10;
       }else{
           this.level+=i;
       }
    }
    
    private void decrementLevels(int i){
       int nlevel=this.level;
       if(nlevel-i<1){
           this.level=1;
       }else{
           nlevel-=i;
           this.level=nlevel;
       }
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.PedingBadconsecuence=b;      
            
    }
    
    private void dielfNOTreasures(){
        if(this.hiddenTreasures.isEmpty()==true && this.visibleTreasures.isEmpty()==true){
            this.dead=true;
        }
    }

    private void discandNecklacelfVisible(){
        CardDealer cd=CardDealer.getInstance();
        for (int i=0;i<visibleTreasures.size();i++){
            if(visibleTreasures.get(i).getType()==TreasureKind.necklace) {
                cd.giveTreasureBack(visibleTreasures.get(i));//pasa al mazo de descartes cardDealer
                visibleTreasures.remove(i);
            }
        }
    }
            
    private void die(){
        this.level=1;
        CardDealer dealer=CardDealer.getInstance();
        
        for (Treasure visibleTreasure : visibleTreasures) {
            dealer.giveTreasureBack(visibleTreasure);
        }
        visibleTreasures.clear();
        
        for (Treasure hiddenTreasure : hiddenTreasures) {
            dealer.giveTreasureBack(hiddenTreasure);
        }
        hiddenTreasures.clear();
        this.dielfNOTreasures();
    }

    private float computerGoldCoinsValue(ArrayList<Treasure> T){
        float buylevel=0;
        for (Treasure visibleTreasure : T) {
           buylevel+= visibleTreasure.getGoldCoins();
        }
       
        return buylevel;
    }
    
    private boolean canIBuyLevels(int i){
        return this.level+i <= 10;
    }
    
    private void applyPrize(Monster currentMonster){
        int nlevels=currentMonster.getLevelsGained();
        this.incrementLevels(nlevels);
        int nTreasures=currentMonster.getTreasuresGained();
        if(nTreasures>0){
            CardDealer dealer=CardDealer.getInstance();
            for(int i=1;i<=nTreasures;i++){
                Treasure treasure=dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
        
        
    }
    
    private void applyBadConsequence(BadConsequence Bad){
        int nlevel=Bad.getLevels();
        this.decrementLevels(nlevel);
        this.PedingBadconsecuence=Bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(PedingBadconsecuence);
    }
    
    private boolean canMakeTreasureVisible(Treasure T){
        if(this.howManyVisibleTreasures(T.getType()) == 1 && T.getType()!=TreasureKind.oneHand ){
            return false;
        }
        if(visibleTreasures.size()==6){//en el juego de Munckins existen cartas que puede que tengas otra mano
            return false;              //pero según el guion el maximo seria 6   
        }
        if(( this.howManyVisibleTreasures(TreasureKind.bothHand) == 1) && T.getType()==TreasureKind.oneHand  ){
            return false;
        } 
        if(this.howManyVisibleTreasures(TreasureKind.oneHand)== 2 && T.getType()==TreasureKind.oneHand){
            return false;
        }
        if(( this.howManyVisibleTreasures(TreasureKind.oneHand) > 0) &&  T.getType()==TreasureKind.bothHand ){
            return false;
        } 
        return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int num=0;
        for (Treasure visibleTreasure : visibleTreasures) {
            if (visibleTreasure.getType() == tKind) {
                num++;
            }
        }
        return num;
    }
    
    public boolean isDead(){
        return this.dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    
    }
   
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
            
    public CombatResult combat(Monster m){
        int myLevel=this.getCombatLevel();
        int monsterlevel=m.getCombatlevel();
        CombatResult combat = null;
        if(myLevel>monsterlevel){
            this.applyPrize(m);
            if (level >=10)
                combat=CombatResult.WinAndWinGame;
            else
                combat=CombatResult.Win;
                
        }else{
        Dice dice=Dice.getInstance();
        int escape=dice.nextNumber();
        if(escape<5){
            boolean amIDead=m.kills();
            if(amIDead==true){
                this.die();
                combat=CombatResult.LoseAndDie;
            }else{
            BadConsequence bad=m.getBadConsecuence();
            combat=CombatResult.Lose;
            this.applyBadConsequence(bad);
            }
        }else
            combat=CombatResult.LoseAndEscape;
        }
        this.discandNecklacelfVisible();
        return combat;
    }
           
    public void makeTreasureVisible(Treasure t){
    boolean canI=this.canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    
    }
            
    public void discardVisibleTreasure(Treasure T){
        visibleTreasures.remove(T);
        if(PedingBadconsecuence!=null && !PedingBadconsecuence.isEmpty()){
            PedingBadconsecuence.substractVisibleTreasure(T);
        }
        this.dielfNOTreasures();
        
    }
            
    public void discardHiddenTreasure(Treasure T){
        hiddenTreasures.remove(T);
        if(PedingBadconsecuence!=null && !PedingBadconsecuence.isEmpty()){
            PedingBadconsecuence.substractHiddenTreasure(T);
        }
        this.dielfNOTreasures();
    }
            
    public boolean buyLevels(ArrayList<Treasure> visible,ArrayList<Treasure> hidden){
        float LevelsMayBought;
        LevelsMayBought=computerGoldCoinsValue(visible);
        LevelsMayBought+=computerGoldCoinsValue(hidden);
        int nlevel;
        nlevel=(int) (LevelsMayBought/1000);
        boolean canI=canIBuyLevels(nlevel);
        if (canI){
            this.incrementLevels(nlevel);
        }
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        CardDealer dealer=CardDealer.getInstance();
        for (Treasure visible1 : visible) {
            dealer.giveTreasureBack((Treasure) visible1);
        }
        
        for (Treasure hidden1 : hidden) {
            dealer.giveTreasureBack((Treasure) hidden1);  
        }
        return canI;
    }
            
    public boolean validState(){
        return ((this.PedingBadconsecuence == null ||this.PedingBadconsecuence.isEmpty()==true) && this.hiddenTreasures.size() < 5);
    }
            
    public void initTreasures(){
        CardDealer dealer=CardDealer.getInstance();
        Dice dice=Dice.getInstance();
        this.bringToLife();
        Treasure treasure=dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number=dice.nextNumber();
        if(number>1){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number==6){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
            
    public boolean hasVisibleTreasures(){
        return this.visibleTreasures.size()>0;
    }
            
    public int getLevels(){
        return this.level;
    }
    
    public String getName(){
        return this.name;
    }
    @Override
     public String toString() {
        return 
         "\nNombre del Jugador:" + this.name
        + "\nNivel = " + Integer.toString(level)
        + "\nTesoros visibles que tienes= " + this.visibleTreasures
        + "\nTesoros ocultos que tienes= " + this.hiddenTreasures;
    }
}
