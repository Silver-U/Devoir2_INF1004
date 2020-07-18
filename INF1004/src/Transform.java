import java.util.ArrayList;
import java.util.Stack;

public class Transform
{
    public static ArrayList<String> Postfixe (ArrayList<String> infix_express)
    {
        Stack<String> operator = new Stack<>();
        ArrayList<String> postfix_express = new ArrayList<>();

        for (int i = 0; i < infix_express.size(); i++)
        {
            if (infix_express.get(i).equals("(") )
            {
                operator.push("(");
            }
            //infix_express.get(i).matches("\\+|-|/|\\*|$")
            else if (infix_express.get(i).matches("\\+|-|/|\\*|$"))
            {
                if (operator.empty())
                {
                    operator.push(infix_express.get(i));
                }
                else
                {
                    if (operator.peek().equals("/") || operator.peek().equals("*") || operator.peek().equals("+") || operator.peek().equals("-") || operator.peek().equals("$"))
                    {
                        if (Transform.Priorite(operator.peek()) == Transform.Priorite(infix_express.get(i)))
                        {
                            postfix_express.add(operator.pop());
                            operator.push(infix_express.get(i));
                        }
                        else
                        {
                            if (Transform.Priorite(operator.peek()) < Transform.Priorite(infix_express.get(i)))
                            {
                                operator.push(infix_express.get(i));

                            }
                            else
                            {
                                postfix_express.add(operator.pop());
                                operator.push(infix_express.get(i));
                            }
                        }


                    }
                    else
                    {
                        operator.push(infix_express.get(i));
                    }
                }
            }
            else if (infix_express.get(i).equals(")"))
            {
                while (!(operator.peek().equals("(")))
                {
                    postfix_express.add(operator.pop());
                }
                operator.pop();
            }
            else
            {
                postfix_express.add(infix_express.get(i));
            }
        }

        if(!operator.empty())
        {
            while(!operator.empty())
            {
                postfix_express.add(operator.pop());
            }
        }
        return postfix_express;
    }

    //cette methode permet de retourner la priorite d'un operateur qui est
    //essentiel a savoir pour la conversion
    public static int Priorite (String oper)
    {
        int a = 0;
       switch (oper)
       {
           case "-" :
           case "+" :
               return a = 1;
           case "/" :
           case "*" :
               return a = 2;
           case "$" :
               return a = 3;
       }
       return a;
    }
}
