package HW3.Controller;

public class UpdateMessage implements Message {

    private String redNumber;
    private String blueNumber;
    private String greenNumber;

    public UpdateMessage(String red, String green, String blue) {
        redNumber = red;
        greenNumber = green;
        blueNumber = blue;
    }

    public String getRedNumber(){
        return redNumber;
    }

    public String getBlueNumber(){
        return blueNumber;
    }

    public String getGreenNumber(){
        return greenNumber;
    }


}
