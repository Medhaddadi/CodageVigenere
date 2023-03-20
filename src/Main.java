import java.util.Arrays;

import static java.lang.Character.toUpperCase;

public class Main {
    public static void main(String[] args) {
        System.out.println(CryptageVignere.longueurCle(CryptageVignere.removeSpecialCharacters("Lbsfw qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc qvzgsfqb jk oqzgkbc")));
        //tester tout les methodes de la class CryptageVignere
        CryptageVignere cryptage = new CryptageVignere(" Bonjour, je suis un texte clair", "cle");
        System.out.println(cryptage.chiffrement(" Bonjour, je suis un texte clair", "cle"));
        System.out.println(cryptage.dechiffrement("Cqzgkbc, jk oqzgkbc un xqzgkbc fqzgkbc", "cle"));
        System.out.println(CryptageVignere.longueurCle("Cqzgkbc, jk oqzgkbc un xqzgkbc fqzgkbc"));
        System.out.println(CryptageVignere.longueurCle("Cqzgkbc, jk oqzgkbc un xqzgkbc fqzgkbc"));


        //tester la fonction de cryptage de vignere
        String textClair = "Bonjour, je suis un texte clair";
        String cle = "cle";
        CryptageVignere cryptageVignere = new CryptageVignere(textClair, cle);
        String textChiffre = cryptageVignere.chiffrement(textClair, cle);
        System.out.println(textChiffre);
    }
}