import java.util.* ;

public class DotComBust{
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuess = 0;

    private void setUpGame(){
        //make some DotComs and add to ArrayList
        DotCom dotCom1 = new DotCom();
        dotCom1.setName("Petes.com");
        DotCom dotCom2 = new DotCom();
        dotCom2.setName("eToys.com");
        DotCom dotCom3 = new DotCom();
        dotCom3.setName("Go2.com");
        dotComsList.add(dotCom1);
        dotComsList.add(dotCom2);
        dotComsList.add(dotCom3);

        // set locations
        for (DotCom dotComToSet: dotComsList){
            ArrayList<String> newLocation =helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }

        // Opening speech for player
        System.out.println("You goal is to sink three dot coms.");
        System.out.println(("Pets.com, eToys.com, Go2.com"));
        System.out.println("Try to sink them all in fewest number of guesses");
    } // close setUpGame method

    private void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        } // close while

        finishGame();
    } // close startPlaying method


    private void checkUserGuess(String userGuess){
        numOfGuess ++;
        String result = "miss";

        for (DotCom dotComToTest : dotComsList){
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        } //close for

        System.out.println(result);
    }


    private void finishGame(){
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuess <= 18) {
            System.out.println("It only takes you " + numOfGuess + " guesses.");
            System.out.println("You got out before your options sank.");
        }else {
            System.out.println("Took you long enough. " + numOfGuess + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }// close finishGame

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    } // close main
}
