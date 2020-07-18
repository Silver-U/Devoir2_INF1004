import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tokenizer
{
    //cette fonction consiste en fractionne l'expression arithmetique en plusieurs caractere et chiffre qui le
    //constitue pour le stockers dans un arraylist de string
    public static ArrayList<String> Tokens_transformation(String expression)
    {
        ArrayList<String> array_tokens = new ArrayList<String>();

        //le constructeur StringTokenizer sert a divise un String en token, il prend en
        //parametre le string en question , le/les elements de division et l'inclusion des elenebts de divisions
        StringTokenizer tokens = new StringTokenizer(expression, "()/*-+$", true);

        for (int i = 0; tokens.hasMoreTokens(); i++)
        {
            array_tokens.add(tokens.nextToken());
        }
        return array_tokens;

    }
}
