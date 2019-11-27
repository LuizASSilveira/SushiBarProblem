import java.util.Random;

public class Client extends Thread{
    Monitor monitor;

    public Client(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
//            System.out.println(this.getName() + " Chegou no Sushi");
            this.monitor.enter(); //pega uma cadeira
            System.out.println(this.getName() + " Comendo");
            Random number = new Random();
            Thread.sleep(number.nextInt(5000));//comendo
            this.monitor.leave();
            System.out.println(this.getName() + " Foi Embora");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
