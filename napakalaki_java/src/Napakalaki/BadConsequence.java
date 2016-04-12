/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author donas11
 */
public class BadConsequence {
    private String text;
    private int levels=1;
    private int nVisibleTreasures=0;
    private int nHiddenTreasures=0; 
    private boolean death=false;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text=text;
        this.levels=levels;
        nVisibleTreasures=nVisible;
        nHiddenTreasures=nHidden;
        this.death=false;
    }
    public BadConsequence(String text, boolean death){
        this.text=text;
        this.death=death;
    
    }
    
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden ){
        this.text=text;
        this.levels=levels;
        this.specificVisibleTreasures=tVisible;
        this.specificHiddenTreasures=tHidden;
        this.death=false;
    }
    
   
    public boolean isEmpty(){
        if(this.levels==0 && this.nHiddenTreasures==0 && this.nVisibleTreasures==0 && 
          (this.specificHiddenTreasures.size())==0 && (this.specificVisibleTreasures.size())==0){
            return true;
        }else{
            return false;
        }
    }
    
    public int getLevels(){
        return levels;
    }
       
    public int getNVisibleTreasures(){
         return nVisibleTreasures;
    }
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
        
    
    
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures; 
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures; 
    }
    
    
    public void substractHiddenTreasure(Treasure t){
        if(specificHiddenTreasures.size()==0){
            this.nHiddenTreasures--;
        }else{
            for(int i=0;i<specificHiddenTreasures.size();i++){        
               if(this.specificHiddenTreasures.get(i)==t.getType()){
                   this.specificHiddenTreasures.remove(i);
               }
            }
        }        
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(specificVisibleTreasures.size()==0){
            this.nVisibleTreasures--;
        }else{
            for(int i=0;i<specificVisibleTreasures.size();i++){        
               if(this.specificVisibleTreasures.get(i)==t.getType()){
                   this.specificVisibleTreasures.remove(i);
               }
            }
        } 
    }
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        BadConsequence Vacio=this ;
        boolean encontrado=false;
        this.levels=0;
        ArrayList<TreasureKind> visiTre= new ArrayList();
        ArrayList<TreasureKind> HidTre=new ArrayList();
        if(v.isEmpty() && h.isEmpty()){
            Vacio=new BadConsequence("MAl rollo",0,0,0);
            return Vacio;
        }
            for (int i=0; i<h.size(); i++) {
                    if (h.get(i).getType()== TreasureKind.necklace){
                            encontrado=true;
                    }
            }
            if(nHiddenTreasures>0 || nVisibleTreasures>0){
                    if(nHiddenTreasures>=h.size() && encontrado==false){                     
                            this.nHiddenTreasures=h.size();
                    }else if(nHiddenTreasures>=h.size() && encontrado==true){        
                            this.nHiddenTreasures=h.size()-1;
                    }
                    if(nVisibleTreasures>=v.size()&& encontrado==false){      
                            this.nVisibleTreasures=v.size();
                    }else if (nVisibleTreasures>=v.size()&& encontrado==true){  
                        this.nVisibleTreasures=v.size()-1;
                    }
                    Vacio=new BadConsequence("MAl rollo pendiente",0,this.nVisibleTreasures, this.nHiddenTreasures);
                    return Vacio;
            }else{
                    boolean enco=false;
                    if(this.specificHiddenTreasures.size()> 0 && h.size()>0 ){
                        for (int d=0; specificHiddenTreasures.size()> d; d++) {
                                    for (int k=0; enco==false && k < h.size(); k++) {
                                        if (specificHiddenTreasures.get(d).equals(h.get(k).getType())) {
                                                HidTre.add(h.get(k).getType());
                                                enco=true;
                                        }
                                    }
                        }
                    }else
                    specificHiddenTreasures=new ArrayList(HidTre); 
                    boolean encon=false;
                    if(this.specificVisibleTreasures.size()>0 && v.size()>0 ){               
                            for (int j=0; j<this.specificVisibleTreasures.size(); j++) {
                                    for (int i = 0; encon == false && i < v.size(); i++) {
                                            if (specificVisibleTreasures.get(j).equals(v.get(i).getType())){
                                                    visiTre.add(v.get(i).getType());  
                                                   encon=true;
                                            }
                                    }
                            }
                    }else
                         specificVisibleTreasures=new ArrayList(visiTre);
                       
                    Vacio=new BadConsequence("MAl rollo pendiente",levels,visiTre,  HidTre);
                    return Vacio;
            }
               
        
     
        
    }   
        
        
    
    
    public boolean myBadConsequeseIsDeath(){
        return this.death;
    
    }
    
    
    
    @Override
    public String toString(){
        return "     - Mal rollo! = " + this.text + 
                "\n     - levels! = " + Integer.toString(this.levels) 
                + "\n     - Tesoros visibles= = " + Integer.toString(nVisibleTreasures)
                + "\n     - Tesoros ocultos = " + Integer.toString(nHiddenTreasures) 
                + "\n     - Tipo de tesoro visible: "+ specificVisibleTreasures 
                + "\n     - Tipo de tesoro oculto: "+ specificHiddenTreasures;
    }
}