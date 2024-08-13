package voo;

public class Voo {
    private final String numeroVoo;
    private final int capacidadeTotal;
    private int assentosReservados;

    public Voo(String numeroVoo, int capacidadeTotal) {
        this.numeroVoo = numeroVoo;
        this.capacidadeTotal = capacidadeTotal;
        this.assentosReservados = 0;
    }

    public synchronized boolean reservarAssento() {
        if (assentosReservados < capacidadeTotal) {
            assentosReservados++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Voo{" +
                "numeroVoo='" + numeroVoo + '\'' +
                ", capacidadeTotal=" + capacidadeTotal +
                ", assentosReservados=" + assentosReservados +
                '}';
    }
}
