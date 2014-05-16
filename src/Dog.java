class Dog{
    String name;
    public static void main(String[] args){
        // Make a Dog and access it
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";
        
        //Now a Dog array
        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        //Now access Dogs using array references
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        // Name of myDog[2]?
        // System.out.print("Last dog's name is ");
        // System.out.println(myDogs[2].name);

        //Loops
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x +1;
        }
    }

    public  void bark(){
        System.out.println(name + " says Ruff!");
    }

    public  void eat(){}
    public  void chaseCat() {}
}
