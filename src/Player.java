class Player{
    int number;

    void guess(){
        number = (int) (Math.random()*10);
        System.out.println("I guess it to be:" + number);
    }
}
