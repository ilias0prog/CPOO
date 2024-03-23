package TPs.Introduction;

// Rappel nom de classe = nom de fichier !!!!
public class Hello {

    public static void sayHello(){
        System.out.println("Hello world !");
    }

    public static void sayHello(String [] args){
        System.out.println("Hello ");
        for (String s : args) {
            System.out.println(s);
        }
    }
}