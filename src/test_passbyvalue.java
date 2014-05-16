class Dog{
    String name;


    public  void bark(){
        System.out.println(name + " says Ruff!");
    }

    public  void eat(){}
    public  void chaseCat() {}

}


class test_passbyvalue{
    public static void main(String[] args){
        // Make a Dog and access it
        Dog dog1 = new Dog();
        dog1.name = "Shadow the old dog";
        dog1.bark();

        test_passbyvalue tester = new test_passbyvalue();
        tester.test_pass(dog1);

        dog1.bark();
    }

    public void test_pass(Dog argdow){
        Dog newdog = new Dog();
        newdog.name = "Rid the new dog";

        argdow = newdog;
    }
}
