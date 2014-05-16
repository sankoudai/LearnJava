public class test_price_polymorphism{
    public static void main(String[] args) {
        Animal a = new Dog();
        // Dog d = a;
    }
}


public class Animal{
    String name;
}

class Dog extends Animal{
    String color;
}
