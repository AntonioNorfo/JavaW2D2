import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero intero che rappresenta il numero di parole da inserire:");
        int N = sc.nextInt();
        sc.nextLine();

        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        for (int i = 0; i < N; i++) {
            System.out.println("Inserisci la parola #" + (i + 1) + ":");
            String parola = sc.nextLine();

            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }

        System.out.println("Parole duplicate:");
        if (paroleDuplicate.isEmpty()) {
            System.out.println("Nessuna parola duplicata.");
        } else {
            for (String parola : paroleDuplicate) {
                System.out.println(parola);
            }
        }

        System.out.println("Numero di parole distinte: " + paroleDistinte.size());

        System.out.println("Parole distinte:");
        for (String parola : paroleDistinte) {
            System.out.println(parola);
        }

        System.out.println("\nInserisci il numero di elementi casuali da generare:");
        int numeroElementi = sc.nextInt();

        List<Integer> numeriCasuali = generaNumeriCasuali(numeroElementi);
        System.out.println("Lista numeri casuali ordinata:");
        System.out.println(numeriCasuali);

        List<Integer> listaConInverso = creaListaConInverso(numeriCasuali);
        System.out.println("Lista con elementi seguiti dal loro inverso:");
        System.out.println(listaConInverso);

        Boolean pari = null;
        while (pari == null) {
            System.out.println("\nVuoi stampare i valori in posizioni pari? (true/false oppure digita 0 per uscire):");
            String input = sc.next();

            if (input.equals("0")) {
                System.out.println("Uscita dal programma.");
                sc.close();
                return;
            } else if (input.equalsIgnoreCase("true")) {
                pari = true;
            } else if (input.equalsIgnoreCase("false")) {
                pari = false;
            } else {
                System.out.println("Input non valido. Inserisci true, false o 0 per uscire.");
            }
        }

        stampaPosizioniPariDispari(listaConInverso, pari);
        sc.close();
    }


    public static List<Integer> generaNumeriCasuali(int N) {
        Random rand = new Random();
        List<Integer> numeri = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numeri.add(rand.nextInt(101));
        }
        Collections.sort(numeri);
        return numeri;
    }

    public static List<Integer> creaListaConInverso(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> inversa = new ArrayList<>(lista);
        Collections.reverse(inversa);
        nuovaLista.addAll(inversa);
        return nuovaLista;
    }

    public static void stampaPosizioniPariDispari(List<Integer> lista, boolean pari) {
        System.out.println(pari ? "Valori in posizioni pari:" : "Valori in posizioni dispari:");
        for (int i = 0; i < lista.size(); i++) {
            if (pari && i % 2 == 0) {
                System.out.println("Posizione " + i + ": " + lista.get(i));
            } else if (!pari && i % 2 != 0) {
                System.out.println("Posizione " + i + ": " + lista.get(i));
            }
        }
    }
}
