package HW3.View;

import HW3.Controller.Message;
import HW3.Controller.UpdateMessage;
import HW3.Controller.ResetMessage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Sources:
 * Box Spacing: https://stackoverflow.com/questions/8335997/how-can-i-add-a-space-in-between-two-buttons-in-a-boxlayout
 */

public class View extends JFrame {
    BlockingQueue<Message> queue;
    JTextField redTextField;
    JTextField greenTextField;
    JTextField blueTextField;
    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;
    JLabel redBarLabel;
    JLabel greenBarLabel;
    JLabel blueBarLabel;
    JButton updateButton;
    JButton resetClassButton;

    JLabel studentNameLabel;
    JLabel allClassesLabel;


    public View(BlockingQueue<Message> queue, String name, ArrayList<String> classes) {
       // this.setRootPaneCheckingEnabled(false);
       // System.out.println("layout before is " + this.getLayout().toString());
       // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       // System.out.println("layout after is " + this.getLayout().toString());
        this.queue = queue;

        this.studentNameLabel = new JLabel(name);
        this.allClassesLabel = new JLabel(classes.toString());

        this.redTextField = new JTextField(10);
        redTextField.setMaximumSize(redTextField.getPreferredSize());
        redTextField.setText("10");
        this.greenTextField = new JTextField(10);
        greenTextField.setMaximumSize(greenTextField.getPreferredSize());
        greenTextField.setText("2");
        this.blueTextField = new JTextField(10);
        blueTextField.setMaximumSize(blueTextField.getPreferredSize());
        blueTextField.setText("6");

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());


        BarGraph redGraph = new BarGraph(Color.RED,0, 250);
        BarGraph blueGraph = new BarGraph(Color.BLUE, 0, 350);
        BarGraph greenGraph = new BarGraph(Color.GREEN, 0, 450);


        redLabel = new JLabel("Red: ");
        redLabel.setLocation(50, 100);
        greenLabel = new JLabel("Green: ");
        greenLabel.setLocation(50, 250);
        blueLabel = new JLabel("Blue: ");
        blueLabel.setLocation(50, 400);
        this.updateButton = new JButton("Update");
        this.resetClassButton = new JButton("Reset");

        redBarLabel = new JLabel(redGraph);
        greenBarLabel = new JLabel(greenGraph);
        blueBarLabel = new JLabel(blueGraph);

        JPanel controlPanel = new JPanel();
        JPanel barPanel = new JPanel();

        updateButton.addActionListener(e -> {
            String redValue = redTextField.getText();
            String greenValue = greenTextField.getText();
            String blueValue = blueTextField.getText();
            if(Integer.parseInt(redValue) >= 0 && Integer.parseInt(greenValue) >= 0 &&
            Integer.parseInt(blueValue) >= 0) {
                try {
                    Message msg1 = new UpdateMessage(redValue);
                    Message msg2 = new UpdateMessage(greenValue);
                    Message msg3 = new UpdateMessage(blueValue);
                    queue.put(msg1);
                    queue.put(msg2);
                    queue.put(msg3);
                    redGraph.setY(500 - 25 * Integer.parseInt(redValue));
                    redGraph.setHeight(25 * Integer.parseInt(redValue));
                    blueGraph.setY(500 - 25 * Integer.parseInt(blueValue));
                    blueGraph.setHeight(25 * Integer.parseInt(blueValue));
                    greenGraph.setY(500 - 25 * Integer.parseInt(greenValue));
                    greenGraph.setHeight(25 * Integer.parseInt(greenValue));
                    redBarLabel.repaint();
                    greenBarLabel.repaint();
                    blueBarLabel.repaint();
                } catch (InterruptedException exception) {
                    // do nothing
                }
            }
        });

        resetClassButton.addActionListener(e -> {
            String redValue = "0";
            String greenValue = "0";
            String blueValue = "0";
            try {
                Message msg1 =  new ResetMessage(redValue);
                Message msg2 = new ResetMessage(greenValue);
                Message msg3 = new ResetMessage(blueValue);
                queue.put(msg1);
                queue.put(msg2);
                queue.put(msg3);
                redTextField.setText("0");
                greenTextField.setText("0");
                blueTextField.setText("0");
                redGraph.setHeight(0);
                blueGraph.setHeight(0);
                greenGraph.setHeight(0);
                redBarLabel.repaint();
                greenBarLabel.repaint();
                blueBarLabel.repaint();
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

   //     this.add(studentNameLabel);
     //   this.add(allClassesLabel);

      //  this.setRootPaneCheckingEnabled(false);
       // BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
      //  this.setLayout(boxlayout);

       // barPanel.setLayout(new FlowLayout());
        barPanel.add(redBarLabel);
        barPanel.add(greenBarLabel);
        barPanel.add(blueBarLabel);

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(Box.createRigidArea(new Dimension(0, 90)));
        controlPanel.add(redLabel);
        controlPanel.add(redTextField); //I've added invisible spacing between (Source, Box Spacing)
        controlPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        controlPanel.add(greenLabel);
        controlPanel.add(greenTextField);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        controlPanel.add(blueLabel);
        controlPanel.add(blueTextField);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        controlPanel.add(updateButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        controlPanel.add(resetClassButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        controlPanel.add(barPanel);

        displayPanel.add(controlPanel, BorderLayout.WEST);
        displayPanel.add(barPanel, BorderLayout.CENTER);

        this.add(displayPanel);
        //this.add(controlPanel);


       // this.add(redLabel);
       // this.add(redTextField);
        //this.add(greenLabel);
       // this.add(greenTextField);
       // this.add(blueLabel);
       // this.add(blueTextField);
       // this.add(updateButton);
       // this.add(resetClassButton);
       // this.add(barLabel);


      //  setContentPane(new DrawPane());

        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void updateNameInView(String value) {
        this.studentNameLabel.setText(value);
    }

    public void updateListOfClassesInView(ArrayList<String> classes) {
        this.allClassesLabel.setText(classes.toString());
    }
}
