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

        ArrayList<String> expression_arithmmetique_postfixe = new ArrayList<String>();

        System.out.println("execution de la conversion de l'expression infixe en postfixe");
        expression_arithmmetique_postfixe = Transform.Postfixe(tokens_expression_arithmetique);
        System.out.println("..............\n.................\nconversion termine.");
        System.out.println("Voici votre expression arithmetique en affichage postfixe :");

        for (int i = 0; i < expression_arithmmetique_postfixe.size(); i++)
        {
            System.out.print(expression_arithmmetique_postfixe.get(i) +" ");
        }

        System.out.println();
        System.out.println("Execution de l'affichage postordre.....");
        System.out.println("operation terminee voici votre expression arithmetique postfixe.");

        System.out.println("Evaluation de l'expression postfixe......");
        System.out.println("Le resultat de l'evaluation est:" + Evaluation.Post(expression_arithmmetique_postfixe));
    }
}
