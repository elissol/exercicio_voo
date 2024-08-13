package voo;

public class Reserva implements Runnable {
    private final Voo voo;

    public Reserva(Voo voo) {
        this.voo = voo;
    }

    @Override
    public void run() {
        if (voo.reservarAssento()) {
            System.out.println(Thread.currentThread().getName() + ": Assento reservado com sucesso.");
        } else {
            System.out.println(Thread.currentThread().getName() + ": Falha na reserva, voo cheio.");
        }
    }
}