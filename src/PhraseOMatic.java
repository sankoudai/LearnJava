public class PhraseOMatic{

    public static void main (String[] args){
        String[] wordListOne = {"24/7", "30,000 feet", "pervasive",
            "dynamic" };

        String[] wordListTwo = {"empowered", "sticky", "coorperative"};

        String[] worListThree = {"process", "minshare"};

        //  find out how many words  in lists
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = worListThree.length;

        // generate random numbers
        int rand1 = (int) (Math.random()*oneLength);
        int rand2 = (int) (Math.random()*twoLength);
        int rand3 = (int) (Math.random()*threeLength);


        //  build a phrase
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " +
            worListThree[rand3];

        // print out
        System.out.println("What we need is a " + phrase);

    }

}
