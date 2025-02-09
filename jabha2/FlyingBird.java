calss FlyingBird extends Bird{
    
    FlyingBird(String name){
        super(name);
    }

    void fly(){
        System.out.println(name + "is flying.");
    }

    @override
    void move(){
        fly();
    }
}