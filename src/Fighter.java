public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    public Fighter(String name,int damage, int health, int weight, int dodge ){
        this.name=name;
        this.damage=damage;
        this.health=health;
        this.weight=weight;
        if(dodge<=100 && dodge>=0){
            this.dodge=dodge;
        }
        else {
            this.dodge=0;
        }
    }

    public int hit(Fighter fighter){
        System.out.println(this.name+" isimli oyuncu "+fighter.name+" isimli oyuncuya "+this.damage+" hasar vurdu.");
        if(fighter.isDodge()){
            System.out.println(fighter.name+" isimli oyuncu saldırıyı blokladı. sağlığı : "+fighter.health);
            System.out.println("---------------------");
            return fighter.health;
        }
        if(fighter.health-this.damage<0){
            return 0;
        }
        return fighter.health-this.damage;
    }

    public boolean isDodge(){
        double random=Math.random()*100;
        return random<=this.dodge;
    }
}
