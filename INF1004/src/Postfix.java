import java.util.ArrayList;
import java.util.Stack;

public class Postfix
{
    //cette methode est le coeur du programme qui selon les critires qu'on a implemente va nous
    //stocker les tokens(les sous expression de l'expressions arithmetique) de l'expression arithmetique dans un arbre binaire
    public static Binary_tree Transform(ArrayList<String> expression)
    {

        Binary_tree postfix = new Binary_tree();
        Node current = Binary_tree.root;
        Stack<Node> stack_nodes = new Stack<>();
        stack_nodes.push(postfix.getRoot());

        for (String s : expression)
        {
            if (s.equals("("))
            {
                current.Add("", "left");
                stack_nodes.push(current);
                current = current.getLeft_child();
                System.out.println("ouvert");
            }
            //else if (infix.get(i).matches("\\+|-|/|\\*"))
            if (s.equals("/") || s.equals("*") || s.equals("-") || s.equals("+"))
            {
                current.setData(s);
                current.Add("", "right");
                stack_nodes.push(current);
                current = current.getRight_child();
                System.out.println("operateur");
            }
            if (s.equals("$"))
            {
                current.setData(s);
                current.Add("", "right");
                current = current.getRight_child();
                System.out.println("racine");
            }
            if (s.equals(")"))
            {
                current = stack_nodes.pop();
                System.out.println("ferme");
            }
            if (!(s.equals("/") || s.equals("*") || s.equals("-") || s.equals("+") || s.equals("(") || s.equals(")") || s.equals("$")))
            {
                current.setData(s);
                System.out.println("nombre");
            }
        }

        return postfix;

    }
}
