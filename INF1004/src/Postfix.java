import java.util.ArrayList;

public class Postfix
{
    //cette methode est le coeur du programme qui selon les critires qu'on a implemente va nous
    //stocker les tokens(les sous expression de l'expressions arithmetique) de l'expression arithmetique dans un arbre binaire
    public static Binary_tree Transform(ArrayList<String> infix)
    {

        Binary_tree postfix = new Binary_tree("");
        int i = 0;
        Node current = postfix.getRoot();
        while (i < infix.size())
        {

            current = new Node(infix.get(i));
            Node parent = current;


            if(infix.get(i).equals("("))
            {
                current.Add("", "left");
                current = current.left_child;
            }
            else if (infix.get(i).matches("\\+|-|/|\\*"))
            {
                current.setData(infix.get(i));
                current.Add("", "left");
                current = current.right_child;
            }
            else if (infix.get(i).equals("$"))
            {
                current.setData(infix.get(i));
                current.Add("", "right");
                current = current.right_child;
            }
            else if(infix.get(i).equals(")"))
            {
                current.Add("null", "left");
                current = parent;
            }
            else
            {
                current.setData(infix.get(i));
                current = parent;
            }

            i++;
        }

        return postfix;

    }
}
