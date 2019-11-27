public class Monitor {
    private int eating = 0;         // Pessoas jantando
    private int peopleLeft = 0;     // Pessoas que foram embora
    private int tableSize;          // Qtd de lugares disponiveis
    private boolean full = false;   // Mesa ocupada pelo grupo

    public Monitor(int tableSize) {
        this.tableSize = tableSize;
    }

    //Entrar no sushi
    public synchronized void enter() {
        while (full) {
            try {
                wait(); //Aguarda mesa esvaziar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.eating += 1;
        if (this.eating == tableSize) { //Verifica se todo o grupo chegou
            this.full = true;
        }
    }

    //Sair do sushi
    public synchronized void leave() throws InterruptedException {
        peopleLeft += 1;
        if (this.peopleLeft == tableSize) { //Verifica se todo o grupo saiu
            this.eating = 0;
            this.peopleLeft = 0;
            this.full = false; //Marca mesa como disponivel
            notifyAll(); //Notifica que a mesa esta desocupada
        }
    }
}