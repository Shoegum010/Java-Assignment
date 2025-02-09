class Sparrow extends FlyingBird{
    Sparrow(){
        super("Sparrow");
    }
}

class Penguin extends NonFlyingBird{
    Penguin(){
        super("Penguin");
    }
}

public class Main{
    public static void Main(String[] args){
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        sparrow.move();
        penguin.move();
    }
}