package Classes;

public class Questions {
    private String question;
    private String goodanswer;
    private String answer2;
    private String answer3;
    private String answer4;
    private String justification;
    private int id;
    private static int idcounter=0;

    public Questions(String question, String goodanswer, String answer2, String answer3, String answer4, String justification) {
        this.question = question;
        this.goodanswer = goodanswer;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.justification = justification;
        idcounter++;
        this.id=idcounter;
        Questions q1 = new Questions("","","","","","");
    }
}
