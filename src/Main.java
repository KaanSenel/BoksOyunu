public class Main {

    public static void main(String[] args) {
	// write your code here
        Fighter f=new Fighter("X",15,100,70,50);

        Fighter f2= new Fighter("Y",15,100,75,48);

        Match match=new Match(f,f2,70,80);

        match.play();
    }
}
