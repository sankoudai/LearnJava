
class Movie{
    String title;
    String genre;
    int rating;

    void playIt(){
        System.out.println("Playing the movie");
    }
}

class MovieTestDrive  {

    public static void main(String[] args){
        Movie one = new Movie();
        one.title = "Gone with the stock";
        one.genre = "Tragic";
        one.rating = -2;
        one.playIt();

    }
}
