/*
  *To change this license header, choose License Headers in Project Properties.
  *To change this template file, choose Tools | Templates
  *and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;





/*
 
  *@author Antonio
 */
public class CardDealer {
   
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    
    
    private static final CardDealer instance = new CardDealer();
    private CardDealer(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
      
    }
    public static CardDealer getInstance() {
        return instance;
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!",0,4,7,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Botas de investigacion",600,3,4,TreasureKind.shoe));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",500,3,5,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("A prueba de babas",400,2,5,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Botas de lluvia acida",800,1,1,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Casco minero",400,2,4,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Ametralladora Thompson",600,4,8,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Camiseta de la UGR",100,1,7,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",400,3,6,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",300,2,3,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Fez alopodo",700,3,5,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Hacha prehistorica",500,2,5,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",900,4,8,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Gaita",500,4,5,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Insecticida",300,2,3,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",700,4,6,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Garabato mistico",300,2,2,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("La fuerza Mr.T",1000,0,0,TreasureKind.necklace));
        unusedTreasures.add(new Treasure("La rebeca metalica",400,2,3,TreasureKind.armor));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",200,3,4,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Necro playboycon",300,3,5,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Lanzallamas",800,4,8,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Necro comicon",100,1,1,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Necronomicon",800,5,7,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Linterna a 2 manos",400,3,6,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Necro-gnomicon",200,2,4,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Necrotelecom",300,2,3,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Porra preternatural",200,2,3,TreasureKind.oneHand));
        unusedTreasures.add(new Treasure("Tentaculo de pega",200,0,1,TreasureKind.helmet));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",500,0,1,TreasureKind.shoe));
        unusedTreasures.add(new Treasure("Shogulador",600,1,1,TreasureKind.bothHand));
        unusedTreasures.add(new Treasure("Varita de atizamiento",400,3,4,TreasureKind.oneHand));
        
               
    }
    
    private void initMonsterCardDeck(){
        BadConsequence bc;
        bc= new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.Descarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList(Arrays.asList(TreasureKind.oneHand)));       
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14,bc, new Prize(4,1)));
        bc= new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0); 
        unusedMonsters.add(new Monster("El rey de rosa", 13, bc,new Prize(4,2)));
        bc= new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList());
        unusedMonsters.add(new Monster("Chibithulhu", 2, bc,new Prize(1,1)));
        bc= new BadConsequence("Pierdes tu armadura visible y otra oculta ", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList(Arrays.asList(TreasureKind.armor)));
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc,new Prize(2,1)));
        bc= new BadConsequence("El primordial bostezo contagioso", 0, new ArrayList(Arrays.asList(TreasureKind.shoe)), new ArrayList()); 
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc,new Prize(1,1)));
        bc= new BadConsequence("Pierdes todos los tesoros visibles", 0, 10, 0);//son 10 el maximo de cartas  bajadas es 6 pero por si acaso hay alguna carta que te deja tener más elementos
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, bc,new Prize(3,1)));
        bc= new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bc,new Prize(2,1)));
        bc= new BadConsequence("Sientes bichos bajo la ropa.Descarta la armadura visible", 5, new ArrayList(Arrays.asList(TreasureKind.armor)), new ArrayList());
        unusedMonsters.add(new Monster("Bichgooth", 2, bc,new Prize(1,1)));
        bc= new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, bc,new Prize(1,1)));
        bc= new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",true);
        unusedMonsters.add(new Monster("Los hondos", 8, bc,new Prize(2,1)));
        bc= new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bc,new Prize(2,1)));
        bc= new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.oneHand)), new ArrayList());
        unusedMonsters.add(new Monster("Dameargo", 1, bc,new Prize(2,1)));
        bc= new BadConsequence("Da mucho asquito", 3, 0, 0);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, bc,new Prize(1,1)));
        bc= new BadConsequence("No le hace gracia que pronuncien mal su nombre.Estas muerto",true);
        unusedMonsters.add(new Monster("YskhtihyssgGoth", 12, bc,new Prize(3,1)));
        bc= new BadConsequence("La familia te atrapa, Estás muerto", true);
        unusedMonsters.add(new Monster("Familia feliz", 1, bc,new Prize(4,1)));
        bc= new BadConsequence("la quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2,  new ArrayList(Arrays.asList(TreasureKind.bothHand)), new ArrayList());
        unusedMonsters.add(new Monster("Roboggoth", 8, bc,new Prize(2,1)));
        bc= new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,  new ArrayList(Arrays.asList(TreasureKind.helmet)), new ArrayList());
        unusedMonsters.add(new Monster("El espia", 5, bc,new Prize(1,1)));
        bc= new BadConsequence("Menudo susto te llevas", 2, 5, 0);
        unusedMonsters.add(new Monster("El lenguas", 20, bc,new Prize(1,1)));
        bc= new BadConsequence("Te faltan manos para tanta cabeza", 3, 10, 0);
        unusedMonsters.add(new Monster("Bicefalo", 20, bc,new Prize(1,1)));
    
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    
    private void shuffleMonsters(){
       Collections.shuffle(unusedMonsters);
    }
    
    
    
    public Treasure nextTreasure(){
        if(this.unusedTreasures.isEmpty()){
            for (Treasure usedTreasure : this.usedTreasures) {
                unusedTreasures.add(usedTreasure);
                
            }
            this.usedTreasures.removeAll(unusedTreasures);
        }
            shuffleTreasures();
            Treasure Next=this.unusedTreasures.get(0);
            usedTreasures.add(Next);
            this.unusedTreasures.remove(0);
            return Next;
        
    }
    
    public Monster nextMonster(){
        if(this.unusedMonsters.isEmpty()){
            for (Monster usedMonster : this.usedMonsters) {
                unusedMonsters.add(usedMonster);
               
            }
             usedMonsters.removeAll(unusedMonsters);
        }
        shuffleMonsters();
        Monster Next=this.unusedMonsters.get(0);
        this.unusedMonsters.remove(0);
        usedMonsters.add (Next);
        return Next;
    }
    
    
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    
    
    public void giveMonsterBack(Monster m){
        this.usedMonsters.add(m);
    }
    
    public void initCards(){
        this.initTreasureCardDeck();
        shuffleTreasures();
        this.initMonsterCardDeck();
        shuffleMonsters();
    }
    @Override
    public String toString() {
        return "\nMonstruos que no han entrado en combate  = " + unusedMonsters
        + "\nMonstruos descartados = " + usedMonsters
        + "\nTesoros que puedes usar = " + unusedTreasures
        + "\nTesoros descartados = " + usedTreasures;
       
    }
}
