package TPs.Introduction;

import java. util.*;

public class Calculatrice {

    static Scanner scan = new Scanner(System.in);

    public static void compute(){
        char c='O';
        float a=0,b=0;
        char op='0';
        boolean badEntry = true;
        while(c=='O'){
            while(badEntry) {
                try {
                    a = Float.parseFloat(read("Entrez la première valeure :"));
                    badEntry=false;
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer une valeur numérique ! Ex : 3.14");
                }
            }
            badEntry=true;
            while(badEntry) {
                op = read("Choississez un opérateur (+,-,*,/) :").charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    badEntry = false;
                } else {
                    System.out.println("Opérateur '" + op + "' non valide !");
                }
            }
            badEntry=true;
            while(badEntry) {
                try {
                    b=Float.parseFloat(read("Entrez la deuxième valeure :"));
                    badEntry=false;
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer une valeur numérique ! Ex : 3.14");
                }
            }
            switch (op){
                case '+' :
                    System.out.println("Le résultat vaut " + add(a,b));
                    break;
                case '-' :
                    System.out.println("Le résultat vaut " + min(a,b));
                    break;
                case '*' :
                    System.out.println("Le résultat vaut " + mul(a,b));
                    break;
                case '/' :
                    if(b != 0) {
                        System.out.println("Le résultat vaut " + div(a, b));
                    } else
                    {
                        System.out.println("Division par 0 impossible !");
                    }
                    break;
            }
            c = read("Voulez-vous refaire une opération ? (Oui/Non)").charAt(0);
        }
    }

    private static float add(float a, float b)
    {
        return a+b;
    }

    private static float min(float a, float b)
    {
        return a-b;
    }

    private static float mul(float a, float b) {
        return a*b;
    }

    private static float div(float a, float b){
        return a/b;
    }

    private static String read(String message){
        System.out.println(message);
        return scan.next();
    }
}