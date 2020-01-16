package com.dandy1988;

import java.util.Scanner;

public class Interrupter extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String symbol = null;
        while (symbol==null){
            symbol = scanner.nextLine();
            this.interrupt();
        }
        System.out.println("Player have enterupted");

    }
}
