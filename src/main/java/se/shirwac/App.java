package se.shirwac;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    
    public static void main(String[] args) {
       int[] birdsPerDay = { 0, 2, 5, 3, 7, 8, 4 };
       BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
       birdCount.run();
       
       
    }
}
