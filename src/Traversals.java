public class Traversals<T> {
    // we need not have any code in traversals object
    public Traversals() {

    }

    public void inorder(Node<T> newnode) {
        if (newnode != null) {
            // System.out.println("Test 1");
            inorder(newnode.getLeft());
            // System.out.println("Test 2");
            System.out.print(newnode.getValue() + ", ");
            // System.out.println("Test 3");
            inorder(newnode.getRight());
            // System.out.println("Test 4");

        }
        return;
    }

    public void postorder(Node<T> newnode) {
        if (newnode != null) {
           //  System.out.println("Test 1");
            postorder(newnode.getLeft());
            // System.out.println("Test 2");
            postorder(newnode.getRight());
            System.out.print(newnode.getValue() + ", ");
            // System.out.println("Test 3");
            // System.out.println("Test 4");
        }
        return;
    }

    public void preorder(Node<T> newnode) {
        if (newnode != null) {
            System.out.print(newnode.getValue() + ", ");
            // System.out.println("Test 1");
            preorder(newnode.getLeft());
            // System.out.println("Test 2");
            preorder(newnode.getRight());

            // System.out.println("Test 3");
            // System.out.println("Test 4");

        }
        return;
    }

}
