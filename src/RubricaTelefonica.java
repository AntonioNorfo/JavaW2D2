import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {
    // Mappa per memorizzare i contatti
    private Map<String, String> contatti;

    public RubricaTelefonica() {
        contatti = new HashMap<>();
    }

    public void inserisciContatto(String nome, String telefono) {
        contatti.put(nome, telefono);
        System.out.println("Contatto inserito: " + nome + " - " + telefono);
    }

    public void cancellaContatto(String nome) {
        if (contatti.remove(nome) != null) {
            System.out.println("Contatto " + nome + " cancellato.");
        } else {
            System.out.println("Contatto " + nome + " non trovato.");
        }
    }

    public String cercaNumeroDaNome(String nome) {
        String numero = contatti.get(nome);
        if (numero != null) {
            System.out.println("Il numero di " + nome + " è " + numero);
        } else {
            System.out.println("Contatto " + nome + " non trovato.");
        }
        return numero;
    }

    public String cercaNomeDaNumero(String telefono) {
        for (Map.Entry<String, String> entry : contatti.entrySet()) {
            if (entry.getValue().equals(telefono)) {
                System.out.println("Il numero " + telefono + " appartiene a " + entry.getKey());
                return entry.getKey();
            }
        }
        System.out.println("Nessun contatto trovato per il numero " + telefono);
        return null;
    }


    public void stampaTuttiContatti() {
        if (contatti.isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            System.out.println("Lista di tutti i contatti:");
            for (Map.Entry<String, String> entry : contatti.entrySet()) {
                System.out.println("Nome: " + entry.getKey() + ", Numero: " + entry.getValue());
            }
        }
    }
}

