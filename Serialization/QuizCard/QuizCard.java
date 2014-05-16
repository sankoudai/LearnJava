
public class QuizCard{
    private String question;
    private String answer;
    
    // Constructor
    QuizCard(String q, String a){
        question = q;
        answer  =a ;
    }

    String getQuestion(){
        return question;
    }

    String getAnswer(){
        return answer;
    }
}
