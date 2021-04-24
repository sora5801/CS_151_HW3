package HW3.Controller;

public class ResetMessage implements Message {
    private String course;

    public ResetMessage(String str) {
        this.course = str;
    }

    public String getCourse() {
        return course;
    }
}
