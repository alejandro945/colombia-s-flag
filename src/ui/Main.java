package ui;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("\u001b[" + "2J"); // CLEAN CONSOLE
        FlagUI fu = new FlagUI();
        fu.init();
    }
}
