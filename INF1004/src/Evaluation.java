import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Double.parseDouble;

public class Evaluation
{
    public static Double Post(ArrayList<String> express_evaluer)
    {
        Stack<Double> pile = new Stack<>();
        Double a, b;

        for (String s : express_evaluer)
        {
            if (s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-") || s.equals("$"))
            {
                System.out.println("operateur");
                switch (s)
                {
                    case "+" -> {
                        a = pile.pop();
                        b = pile.pop();
                        pile.push(a + b);
                    }
                    case "-" -> {
                        a = pile.pop();
                        b = pile.pop();
                        pile.push(a - b);
                    }
                    case "*" -> {
                        a = pile.pop();
                        b = pile.pop();
                        pile.push(a * b);
                    }
                    case "/" -> {
                        a = pile.pop();
                        b = pile.pop();
                        pile.push(b / a);
                    }
                    case "$" -> {
                        a = pile.pop();
                        System.out.println(a);
                        pile.push(Math.sqrt(a));
                        System.out.println("squareriit");
                    }
                }
            }
            else
            {
                pile.push(Double.parseDouble(s));
                System.out.println("operande");
            }
        }
        return pile.pop();
    }

}
