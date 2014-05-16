public class BeerSong{

    public static void main(String[] args){
        int beerNum = 99;
        String word = "bottles";

        while(beerNum > 0){

            if (beerNum == 1){
                word = "bottle";
            }

            System.out.println(beerNum + " " + word + "of beer on wall");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Takes one down.");

            beerNum = beerNum -1;
            }

        System.out.println("No more of beer on the wall");
        }
}
