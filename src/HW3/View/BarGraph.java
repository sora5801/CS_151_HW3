package HW3.View;

import javax.swing.*;
import java.awt.*;



public class BarGraph implements Icon {
    private int x;
    private int y;
    private Color color;
    private int height;

    public BarGraph(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
        this.height = 300; //default  rectangle height
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(this.x, this.y, 50, this.height);


    }

    public void setY(int y){
        this.y = y;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return this.height;
    }

    @Override
    public int getIconWidth() {
        return 80;
    }

    @Override
    public int getIconHeight() {
        return 500;
    }
}
