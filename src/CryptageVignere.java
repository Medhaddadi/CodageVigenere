import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.toUpperCase;

public class CryptageVignere {
    public static int nombreMaxilOperations = 0;
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CryptageVignere(String textClair, String cle) {
    }

    //cette function permet de convertir un texte en tableau de nombre des positions de chaque lettre dans l'alphabet
    public int[] codageNumerique(String text) {
        int[] tab = new int[text.length()];
        int i = 0;
        for (char c : text.toCharArray()) {
            tab[i] = alphabet.indexOf(toUpperCase(c));
            i++;
        }
        return tab;
    }
    //cette function permet de convertir un tableau de nombre en texte en utilisant l'alphabet comme reference pour les lettres
    public String codageTexte(int[] tab) {
        String text = "";
        for (int i : tab) {
            text += alphabet.charAt(i);
        }
        return text;
    }
//cette function permet de chiffrer un texte en utilisant la methode de vignere
    public String chiffrement(String textClair, String cle) {
        int[] tabClair = codageNumerique(textClair);
        int[] tabCle = codageNumerique(cle);
        int[] tabChiffre = new int[tabClair.length];
        for (int i = 0; i < tabClair.length; i++) {
            tabChiffre[i] = (tabClair[i] + tabCle[i % tabCle.length]) % alphabet.length();
        }
        return codageTexte(tabChiffre);
    }

    //cette function permet de dechiffrer un texte en utilisant la methode de vignere
    public String dechiffrement(String textChiffre, String cle) {
        int[] tabChiffre = codageNumerique(textChiffre);
        int[] tabCle = codageNumerique(cle);
        int[] tabClair = new int[tabChiffre.length];
        for (int i = 0; i < tabChiffre.length; i++) {
            tabClair[i] = (tabChiffre[i] + 26 - tabCle[i % tabCle.length]) % alphabet.length();
        }
        return codageTexte(tabClair);
    }

    //cette function permet de trouver la longueur de la cle en utilisant la methode de vignere
    public static int pgcd(int a, int b) {
        if (b == 0) return a;
        return pgcd(b, a % b);
    }

    //cette function permet de trouver le pgcd des distances entre les repetitions d'une sequence de 3 lettres
    public static int pgcdDistancesEntreRepetitions(String texte, int i) {
        String sequence = texte.substring(i, i + 3);
        List<Integer> distances = new ArrayList<Integer>();
        int index = texte.indexOf(sequence, i + 3);
        while (index != -1) {
            distances.add(index - i - 3);
            index = texte.indexOf(sequence, index + 1);
        }
        if (distances.isEmpty()) {
            return 0;
        } else {
            System.out.println(distances);
            int pgcd = distances.get(0);
            for (int j = 1; j < distances.size(); j++) {
                pgcd = pgcd(pgcd, distances.get(j));
                nombreMaxilOperations++;
            }
            System.out.println("pgcd = " + pgcd);
            return pgcd;
        }
    }

    //cette function permet de trouver la longueur de la cle en utilisant la methode de vignere
    public static int longueurCle(String texteCrypte) {
        int[] pgcds = new int[texteCrypte.length() - 3];
        for (int i = 0; i < texteCrypte.length() - 3; i++) {
            pgcds[i] = pgcdDistancesEntreRepetitions(texteCrypte, i);
        }
        // recherche du PGCD commun entre les PGCDs pour différentes positions i
        int longueurCle = 1;
        for (int pgcd : pgcds) {
            longueurCle = pgcd(longueurCle, pgcd); // utilisation de la fonction pgcd pour trouver le PGCD commun
        }
        return longueurCle;
    }



    //cette function permet de supprimer les caracteres speciaux d'un texte et de le convertir en majuscule
    public static String removeSpecialCharacters(String text) {
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z' || text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                newText += text.charAt(i);
            }
        }
        return newText;
    }

    //cette function permet de trouver la cle en utilisant la methode de vignere
    public static String trouverCle(String texteCrypte, int longueurCle) {
        String cle = "";
        for (int i = 0; i < longueurCle; i++) {
            String texte = "";
            for (int j = i; j < texteCrypte.length(); j += longueurCle) {
                texte += texteCrypte.charAt(j);
            }
            cle += trouverCle(texte, i);
        }
        return cle;
    }

}
