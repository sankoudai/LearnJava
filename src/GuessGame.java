class GuessGame{
    Player p1;
    Player p2;
    Player p3;

    void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        boolean p1isright = false;
        boolean p2isright = false;
        boolean p3isright = false;

        int target = (int) (Math.random()*10);

        while (true) {
            System.out.println("The number to guess: " + target);

            p1.guess();
            p2.guess();
            p3.guess();

            if (p1.number == target) {
                p1isright = true;
            }
            if (p2.number == target) {
                p2isright = true;
            }
            if (p3.number == target) {
                p3isright = true;
            }

            if (p1isright || p2isright ||p3isright) {
                System.out.println("We have a winner!");
                System.out.println("Is player1 right? " + p1isright);
                System.out.println("Is player2 right? " + p2isright);
                System.out.println("Is player3 right? " + p3isright);
                break;
            }
        }
    }
}
