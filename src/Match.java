public class Match {
    Fighter fighter1;
    Fighter fighter2;
    int minWeight;
    int maxWeight;

    public Match(Fighter fighter1, Fighter fighter2, int minWeight, int maxWeight){
        this.fighter1=fighter1;
        this.fighter2=fighter2;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;
    }

    public void play(){
        if (isCheck()){
            if(firstShot()==1) { //ilk vurusu fighter1 yapar
                System.out.println("ilk vuruşu fighter1 yapacak.");
                while (this.fighter1.health > 0 && this.fighter2.health > 0) {
                    System.out.println("*---------------------*");

                    this.fighter2.health = this.fighter1.hit(this.fighter2);
                    if (isWin()) {
                        break;
                    }

                    this.fighter1.health = this.fighter2.hit(this.fighter1);
                    if (isWin()) {
                        break;
                    }
                    printHealth();
                }
            }
            if(firstShot()==0) { //ilk vurusu fighter2 yapar
                System.out.println("ilk vuruşu fighter2 yapacak.");
                while (this.fighter1.health > 0 && this.fighter2.health > 0) {
                    System.out.println("*---------------------*");

                    this.fighter1.health = this.fighter2.hit(this.fighter1);
                    if (isWin()) {
                        break;
                    }

                    this.fighter2.health = this.fighter1.hit(this.fighter2);
                    if (isWin()) {
                        break;
                    }
                    printHealth();
                }
            }
        }
        else{
            System.out.println("Sporcu sikletleri aynı değil.");
        }
    }

    public boolean isCheck(){
        return (this.fighter1.weight>=this.minWeight && this.fighter1.weight<=this.maxWeight) && (this.fighter2.weight>=this.minWeight && this.fighter2.weight<=this.maxWeight);
    }

    public boolean isWin(){
        if(this.fighter1.health<=0){
            System.out.println(fighter2.name+" kazandı.");
            return true;
        }
        if(this.fighter2.health<=0){
            System.out.println(fighter1.name+" kazandı.");
            return true;
        }
        return false;
    }

    public int firstShot(){
        double first=Math.random()*100;

        if(first<=50.0){

            return 1;
        }
        else {
            return 0;
        }
    }

    public void printHealth(){
        System.out.println(this.fighter1.name + " Kalan can : " + this.fighter1.health);
        System.out.println(this.fighter2.name + " Kalan can : " + this.fighter2.health);
    }

}
