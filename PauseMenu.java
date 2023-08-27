import java.util.Scanner;

class PauseMenu {
    private boolean paused;

    public PauseMenu() {
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }

    public void Pause() {
        paused = !paused;
    }
}
