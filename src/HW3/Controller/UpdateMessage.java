package HW3.Controller;

public class UpdateMessage implements Message {
    String name;

    public UpdateMessage(String str) {
        this.name = str;
    }

    public String getName() {
        return name;
    }
}
