package voo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String[] args) {
        //capacidade de 10 assentos
        Voo voo = new Voo("V123", 10);

        // Cria 5 Threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 15 tarefas de reserva
        for (int i = 0; i < 15; i++) {
            executor.submit(new Reserva(voo));
        }

        // encerramento
        executor.shutdown();
        
        try {
            // conclusão das tarefas
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // impressão da lista 
        System.out.println(voo);
    }
}
