import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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

        // Gestione numeri casuali e inversione
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
                System.out.println("Uscita dalla funzionalità.");
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

        RubricaTelefonica rubrica = new RubricaTelefonica();

        while (true) {
            System.out.println("\n--- Gestione Rubrica ---");
            System.out.println("1. Inserisci un contatto");
            System.out.println("2. Cancella un contatto");
            System.out.println("3. Cerca un numero da un nome");
            System.out.println("4. Cerca un nome da un numero");
            System.out.println("5. Stampa tutti i contatti");
            System.out.println("0. Esci dalla rubrica");
            System.out.print("Scegli un'opzione: ");
            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Inserisci il numero: ");
                    String numero = sc.nextLine();
                    rubrica.inserisciContatto(nome, numero);
                    break;
                case 2:
                    System.out.print("Inserisci il nome da cancellare: ");
                    nome = sc.nextLine();
                    rubrica.cancellaContatto(nome);
                    break;
                case 3:
                    System.out.print("Inserisci il nome da cercare: ");
                    nome = sc.nextLine();
                    rubrica.cercaNumeroDaNome(nome);
                    break;
                case 4:
                    System.out.print("Inserisci il numero da cercare: ");
                    numero = sc.nextLine();
                    rubrica.cercaNomeDaNumero(numero);
                    break;
                case 5:
                    rubrica.stampaTuttiContatti();
                    break;
                case 0:
                    System.out.println("Uscita dalla rubrica.");
                    return;
                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }

    public static List<Integer> generaNumeriCasuali(int N) {
        Random rand = new Random();
        List<Integer> numeri = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numeri.add(rand.nextInt(101)); // Numeri tra 0 e 100
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
