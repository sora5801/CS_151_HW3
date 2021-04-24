package HW3;

import HW3.Controller.Controller;
import HW3.Controller.Message;
import HW3.Model.Model;
import HW3.View.View;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        Model model = new Model();
        View view = new View(queue, model.getName(), model.getClasses());
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}