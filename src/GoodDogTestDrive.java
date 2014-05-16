class GoodDogTestDrive{
    public static void main(String[] args) {
        GoodDog gdog = new GoodDog();
        gdog.setSize(70);
        gdog.bark();
        System.out.println("Good dog has size of " + gdog.getSize());
    }
}
