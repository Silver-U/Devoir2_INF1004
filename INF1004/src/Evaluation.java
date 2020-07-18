import java.util.ArrayList;
import java.util.Stack;

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
                        pile.push(Math.sqrt(a));
                    }
                }
            } else
            {
                pile.push(Double.parseDouble(s));
            }
        }
        return pile.pop();
    }

}
