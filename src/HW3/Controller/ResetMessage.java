package HW3.Controller;

public class ResetMessage implements Message {

    public ResetMessage() {

    }

    @Override
    public String getRedNumber() {
        return "0";
    }

    @Override
    public String getBlueNumber() {
        return "0";
    }

    @Override
    public String getGreenNumber() {
        return "0";
    }
}
