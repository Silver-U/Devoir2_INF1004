import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {

        String expression_arithmetique;
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenue dans le programme de conversion d'expression arithmetique");
        System.out.println("infixe en postfixe, nous allons evaluez le resultat de maniere ");
        System.out.println("automatique et vous donnez un resultat , tout ce que vous devez faire");
        System.out.println("c'est entrer l'expression en question.");
        expression_arithmetique = scan.nextLine();

        //initialisation directe de notre arraylist avec les tokens issuent de l'expression arithmetique
        ArrayList<String> tokens_expression_arithmetique = new ArrayList<String>(Tokenizer.Tokens_transformation(expression_arithmetique));

        //ordonancement des tokens dans l'arbre binaire
        System.out.println(".......ordonnancement de l'expression arithmtique dans un arbre binaire.");
        Binary_tree binary_tree_of_expression = Postfix.Transform(tokens_expression_arithmetique);

        System.out.println("Execution de l'affichage postordre.....");
        Postorder.Path(binary_tree_of_expression.getRoot());
        System.out.println("operation terminee voici votre expression arithmetique postfixe.");
    }
}
