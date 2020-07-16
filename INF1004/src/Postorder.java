public class Postorder
{
    public  static void Path(Node root)
    {
        //parcours et affichage de l'expressionj arithmetique en postordre
        if (root != null)
        {
            Path (root.left_child);
            Path (root.right_child);
            System.out.println(root);
            /*switch (root)
            {
                case "/" :
                    break;
                case "*" :
                    break;
                case "-" :
                    break;
                case "+" :
                    break;
                case "" :
                    break;
                case "/" :
                    break;

            }*/

        }

    }
}
