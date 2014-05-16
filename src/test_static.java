public class test_static{
    public static void main(String[] args) {
        Dog d = new Dog(3);
        d.bark();
        Dog.bark();
        Dog.printCount();

        System.out.println(d.size);
        System.out.println(d.count);
        System.out.println(Dog.count);
        // System.out.println(Dog.size);
        // Static variables and methods are meant and can be called by class
        // Non-static variables and methods aren't meant adn can't be summoned by class
    }
}

class Dog{
    int size;
    static int count = 1;
    public Dog(int s){
        size = s;
        System.out.println("A new Dog is born, Yip..");
    }
    public static void bark(){
        System.out.println("Wroof, Wroof!");
    }

    public static void printCount(){
        System.out.println("There are " + count +" Dogs now");
    }
}
