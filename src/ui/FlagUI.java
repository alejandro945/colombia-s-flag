package ui;

import model.FlagColor;
import thread.FlagColorThread;

public class FlagUI {
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ESC = "\u001b[";
    private static final int COLORFLAGNUMBER = 3;
    private static final int COLORWIDTH = 80;
    private static final int[] COLORHEIGTHS = new int[] { 16, 24, 32 };
    private static final int[] COLORVPOSITIONS = new int[] { 0, 16, 24 };
    private static final String[] COLORS = new String[] { ANSI_YELLOW_BACKGROUND, ANSI_BLUE_BACKGROUND,
            ANSI_RED_BACKGROUND };
    private static final int[] COLORSLEEPTIMES = new int[] { 15, 40, 50 };
    private FlagColorThread[] ft;
    private FlagColor[] flagcolor;

    public FlagUI() {
        flagcolor = new FlagColor[COLORFLAGNUMBER];
        ft = new FlagColorThread[COLORFLAGNUMBER];
        initFlagColors();
        initFlagColorThreads();
    }

    public void initFlagColors() {
        for (int i = 0; i < COLORFLAGNUMBER; i++) {
            flagcolor[i] = new FlagColor(COLORWIDTH, COLORHEIGTHS[i], COLORS[i], COLORVPOSITIONS[i]);
        }
    }

    public void initFlagColorThreads() {
        for (int i = 0; i < COLORFLAGNUMBER; i++) {
            ft[i] = new FlagColorThread(flagcolor[i], this, COLORSLEEPTIMES[i]);
        }
    }

    public void refresh(int h, int v, String c) {
        if (c.equals(ANSI_YELLOW_BACKGROUND)) {
            System.out.print(ESC + h + "G" + ESC + v + "d" + c + " " + ANSI_RESET);
        } else if (c.equals(ANSI_BLUE_BACKGROUND)) {
            System.out.print(ESC + h + "G" + ESC + v + "d" + c + " " + ANSI_RESET);
        } else {
            System.out.print(ESC + h + "G" + ESC + v + "d" + c + " " + ANSI_RESET);
        }
    }

    public void init() throws InterruptedException {
        for (int i = 0; i < ft.length; i++) {
            ft[i].start();
        }
    }

}
