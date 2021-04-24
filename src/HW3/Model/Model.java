package HW3.Model;


public class Model {

    private String redValue;
    private String greenValue;
    private String blueValue;


    public void setValues(String red, String green, String blue){
        redValue = red;
        greenValue = green;
        blueValue = blue;
    }

    public String getRedValue(){
        return this.redValue;
    }

    public String getGreenValue(){
        return this.greenValue;
    }

    public String getBlueValue(){
        return this.blueValue;
    }


}
