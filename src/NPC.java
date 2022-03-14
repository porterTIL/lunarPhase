import javax.swing.text.View;

public class NPC implements Interaction {

    public String lookMsg = "Go jump into a black hole!";
    public String talkMsg = "Just your average looking person";
    public String pickMsg = "You sure you want to try picking this person up?";
    public String goMsg = "Where are you trying to make this person go? Not like they are going to listen to you.";
    public String dropMsg = "Like drop them into a black hole? I think not!";
    public String useMsg = "Don;t think using them would be a great idea either";
    public String name = "What's my name?";


    public void talk() {
        View.rendertext(lookMsg);
    }


    public void look() {
        View.rendertext(talkMsg);
    }


    public void pickup() {
        View.rendertext(pickMsg);
    }


    public void go() {
        View.rendertext(goMsg);
    }


    public void use() {
        View.rendertext(useMsg);
    }


    public void drop() {
        View.rendertext(dropMsg);
    }
}
