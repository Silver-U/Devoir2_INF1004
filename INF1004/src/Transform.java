import java.util.ArrayList;
import java.util.Stack;

public class Transform
{
    //postfixe est une methode qui retourne une expression postfixe a partir d'une expression postfixe
    //elle a ete contruite a partir des regles de transformations d'une expression infixe en postfixe
    public static ArrayList<String> Postfixe(ArrayList<String> infix_express)
    {
        Stack<String> operator = new Stack<>();
        ArrayList<String> postfix_express = new ArrayList<>();

        for (int i = 0; i < infix_express.size(); i++)
        {

            //ce if a pour objectif ne nous envoyer a l'iterration suivante si le tokens de not
            //expression arithnetique est un espace
            if (infix_express.get(i).equals(" "))
            {
                continue;
            }

            if (infix_express.get(i).equals("("))
            {
                operator.push("(");
            }
            //la methode .matches("\\+|-|/|\\*|$") utiliser ici permet de comparer un String a plusieurs caracteres
            else if (infix_express.get(i).matches("\\+|-|/|\\*|$"))
            {
                if (operator.empty())
                {
                    operator.push(infix_express.get(i));
                } else
                {
                    if (operator.peek().equals("/") || operator.peek().equals("*") || operator.peek().equals("+") || operator.peek().equals("-") || operator.peek().equals("$"))
                    {
                        if (Transform.Priorite(operator.peek()) == Transform.Priorite(infix_express.get(i)))
                        {
                            postfix_express.add(operator.pop());
                            operator.push(infix_express.get(i));
                        } else
                        {
                            if (Transform.Priorite(operator.peek()) < Transform.Priorite(infix_express.get(i)))
                            {
                                operator.push(infix_express.get(i));

                            } else
                            {
                                postfix_express.add(operator.pop());
                                operator.push(infix_express.get(i));
                            }
                        }


                    } else
                    {
                        operator.push(infix_express.get(i));
                    }
                }
            } else if (infix_express.get(i).equals(")"))
            {
                while (!(operator.peek().equals("(")))
                {
                    postfix_express.add(operator.pop());
                }
                operator.pop();
            } else if (infix_express.get(i).equals("$"))
            {
                if (operator.empty())
                {
                    operator.push(infix_express.get(i));
                } else
                {
                    postfix_express.add(operator.pop());
                }
            } else
            {
                postfix_express.add(infix_express.get(i));
            }
        }

        if (!operator.empty())
        {
            while (!operator.empty())
            {
                postfix_express.add(operator.pop());
            }
        }
        return postfix_express;
    }

    //cette methode permet de retourner la priorite d'un operateur qui est
    //essentiel a savoir pour la conversion
    public static int Priorite(String oper)
    {
        int a = 0;
        switch (oper)
        {
            case "-":
            case "+":
                a = 1;
            case "/":
            case "*":
                a = 2;
            case "$":
                a = 3;
        }
        return a;
    }
}
