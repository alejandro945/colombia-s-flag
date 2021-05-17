package model;

public class FlagColor {
    private int colorWidth;
    private int colorHeight;
    private String color;
    private int hPosition;
    private int vPosition;
    private int firstPosition;

    public FlagColor(int colorWidth, int colorHeight, String color, int firstPosition) {
        this.colorWidth = colorWidth;
        this.colorHeight = colorHeight;
        this.color = color;
        hPosition = 0;
        this.firstPosition = firstPosition;
        this.vPosition = firstPosition;
    }

    public int getColorWidth() {
        return this.colorWidth;
    }

    public int getColorHeight() {
        return this.colorHeight;
    }

    public String getColor() {
        return this.color;
    }

    public int getHPosition() {
        return this.hPosition;
    }

    public int getVPosition() {
        return this.vPosition;
    }

    public void setVPosition() {
        this.vPosition = firstPosition;
    }

    public boolean finished() {
        return hPosition >= colorWidth;
    }

    public void advanceHorizontal() {
        hPosition++;
    }

    public void advanceVertical() {
        vPosition++;
    }
}
