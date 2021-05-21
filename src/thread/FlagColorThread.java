package thread;

import model.FlagColor;
import ui.FlagUI;

public class FlagColorThread extends Thread {
    private FlagColor flag;
    private FlagUI flagUI;
    private int sleepTime;

    public FlagColorThread(FlagColor flag, FlagUI flagUI, int sleep) {
        this.flag = flag;
        this.flagUI = flagUI;
        this.sleepTime = sleep;
    }

    public void runHorizontal() {
        while (!flag.finished()) {
            flag.advanceHorizontal();
            runVertical();
        }
    }

    public void runVertical() {
        while (flag.getVPosition() < flag.getColorHeight()) {
            flagUI.refresh(flag.getHPosition(), flag.getVPosition(), flag.getColor());
            flag.advanceVertical();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag.setVPosition();
        runHorizontal();
    }

    @Override
    public void run() {
        runVertical();
    }

}
