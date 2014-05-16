public class test_constructor{
    public static void main(String[] args) {
      Dog  d = new Dog(1);
      System.out.println(d.size);

    }
}

class Dog{
    int size;
    private Dog(){
        size = 10;
    }

    public Dog(int s){
        size = s;
    }
}
