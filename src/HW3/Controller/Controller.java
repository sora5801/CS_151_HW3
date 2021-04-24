package HW3.Controller;

import HW3.Model.Model;
import HW3.View.View;

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    Model model;
    View view;

    public Controller(BlockingQueue<Message> queue, Model model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop() {
        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                // do nothing
            }

            if(message.getClass() == UpdateMessage.class) {
                // button update was clicked
                UpdateMessage nameMessage = (UpdateMessage) message;
                model.setName(nameMessage.getName()); // update model
                view.updateNameInView(model.getName()); // update view
            }
            else if(message.getClass() == ResetMessage.class) {
                // button Reset was clicked
                // update model and view
                ResetMessage resetMessage = (ResetMessage) message;
                model.addClass(resetMessage.getCourse());
                view.updateListOfClassesInView(model.getClasses());
            }

        }
    }
}
