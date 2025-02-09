class NonFlyingBird extends Bird{
    NonFlyingBird(String name){
        super(name);
    }

    void walk(){
        System.out.println(name = " is walking.");
    }

    @override

    void move(){
        walk();
    }
}