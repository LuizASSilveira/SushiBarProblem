import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor(5);

        while (true){
            Random number = new Random();
            Thread.sleep(number.nextInt(1000));//comendo
            new Client( monitor ).start();
        }

    }
}

