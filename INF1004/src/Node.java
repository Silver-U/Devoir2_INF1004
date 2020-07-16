public class Node
{
    protected String data;
    protected Node left_child;
    protected Node right_child;

    public Node (String data) {
        this.data = data;
        right_child = null;
        left_child = null;
    }

    //la methode add a pour objectif d'ajouter soit un enfant a guache soit un enfant a droite
    public void Add(String data, String child)
    {
        Node current = new Node(""); Node parent = new Node(null), new_node = new Node(data);

        if (child.equals("left"))
        {
            current = current.left_child;
            if (current == null)
            {
                parent.left_child = new_node;
            }
        }
        else
        {
            current = current.right_child;
            if (current == null)
            {
                parent.right_child = new_node;
            }
        }
    }

    public String getData()
    {
        return data;
    }

    public Node getLeft_child()
    {
        return left_child;
    }

    public Node getRight_child()
    {
        return right_child;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public void setLeft_child(Node left_child)
    {
        this.left_child = left_child;
    }

    public void setRight_child(Node right_child)
    {
        this.right_child = right_child;
    }
}
