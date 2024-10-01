import java.util.HashSet;
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

        sc.close();
    }
}
