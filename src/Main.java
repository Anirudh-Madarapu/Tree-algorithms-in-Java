public class Main {
    public static void main(String[] args){
        Tree<String> t = new Tree<String>();
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> five = new Node<Integer>(5);
        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> seven = new Node<Integer>(7);
                                   //this is how my Tree  looks
        t.addValue("one");  //               (1)
        t.addValue("two");//              /       \
        t.addValue("three");//        (2)            (3)
        t.addValue("four");//        /  \            /  \
        t.addValue("five");//     (4)   (5)        (6)   (7)
        t.addValue("six");//     /  \   /   \      / \
        t.addValue("seven");//  (8) (9)(10) (11) (12) (13)
        t.addValue("eight");
        t.addValue("nine");
        t.addValue("ten");
        t.addValue("eleven");
        t.addValue("tweleve");
        t.addValue("thirteen");


        Node<String> n = t.getHead(); //let us deal with nodes for sometime
        Node<String> n2 = n.getLeft();//these nodes are just to test methods of node instead of calling them directly from tree
        Node<String> n3 = n.getRight();

        System.out.println(n.childCount());
        System.out.println(n2.getRight().childCount());
        System.out.println(n3.childCount());
        System.out.println(n3.getRight().childCount());
        System.out.println(n2.getLeft().childCount());//it looks like our tree is working just fine
        System.out.println("depth: " + n3.depth());

        t.pathToRoot("eight");
        System.out.println("visited: " + n2.getLeft().isVisited());

        System.out.println(t.siblings("six"));

       //let us make a method which finds paths


        System.out.println("visited: " + n2.getRight().isVisited());

        System.out.println("visited: " + n.getLeft().getLeft().isVisited());
        n.findPath("ten");
        n.findPath("tweleve");

        System.out.println(t.getHead().getLeft().isVisited() + " getleft");
        System.out.println(t.getHead().getRight().isVisited() + " getright");

        System.out.println(t.LeastCommonSubsumer("ten","six"));
        System.out.println(t.LeastCommonSubsumer("ten","two"));
        System.out.println(t.LeastCommonSubsumer("four","eleven"));
        System.out.println(t.LeastCommonSubsumer("seven","six"));
        System.out.println(t.LeastCommonSubsumer("two","six"));

        System.out.println(t.depth());


       //System.out.println(sumTree.getHead().getRight().getValue()+" k ");
       Traversals<String> t2 = new Traversals<String>();
       System.out.println("inorder: ");
        t2.inorder(t.getHead());
        System.out.println();

        System.out.println("postorder: ");
        t2.postorder(t.getHead());
        System.out.println();

        System.out.println("preorder: ");
        t2.preorder(t.getHead());
        System.out.println();

        t.pathToRoot("six");

        t.pathToRoot("seven");

        //let us deal with a sum tree


        Tree<Integer> sumTree = new Tree<Integer>();

        sumTree.addValue(30);
        sumTree.addValue(8);
        sumTree.addValue(4);
        sumTree.addValue(4);

        sumTree.addValue(6);
        sumTree.addValue(5);
        sumTree.addValue(3);



         System.out.println(sumTree.isSumTree(sumTree.getHead()));
         //outputs true it looks like our method is working fine
         t.getHead().inOrderC();


   }
}
