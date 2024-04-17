public class treeInstances {

    public static void main(String[] args){
        //instaniating integer nodes
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> five = new Node<Integer>(5);
        Node<Integer> six = new Node<Integer>(6);
        Node<Integer> seven = new Node<Integer>(7);
        Node<Integer> eight = new Node<Integer>(8);

      //Tree 1
     //----------------------------------------------------------------------------------

        Tree<Integer> tree1 = new Tree<Integer>();


        //let us make the following tree
        /*
                         (1)
                        /   \           depth: 4
                       (2)  (3)
                       / \
                     (4) (5)
                         /
                        (6)
                       /  \
                    (8)    (7)


        */


        tree1.addValue(1);
        Node<Integer> headnode = tree1.getHead();
        headnode.assignLeft(two);//we will add assignleft of node to two
        headnode.assignRight(three);//assign head's right as three
        headnode.getLeft().assignLeft(four);
        headnode.getLeft().assignRight(five);
        headnode.getLeft().getRight().assignLeft(six);
        headnode.getLeft().getRight().getLeft().assignRight(seven);
        headnode.getLeft().getRight().getLeft().assignLeft(eight);

        //Now let us test our tree
        System.out.println(tree1.depth()); //this should return 4

        //Now let us if the values have been added the way we want them to be added

        System.out.println(tree1.getHead().getValue()); //shoudl output  1
        System.out.println(tree1.getHead().getLeft().getValue()); //shoudl output  2
        System.out.println(tree1.getHead().getRight().getValue()); //shoudl output  3
        System.out.println(tree1.getHead().getLeft().getLeft().getValue()); //shoudl output  4
        System.out.println(tree1.getHead().getLeft().getRight().getValue()); //shoudl output  5
        System.out.println(tree1.getHead().getLeft().getRight().getLeft().getValue()); //shoudl output  6
        System.out.println(tree1.getHead().getLeft().getRight().getLeft().getRight().getValue()); //shoudl output  7

        //all the statements above printed 1,2,3,4,5,6,7 as expected. Therefore, my tree is capable of representing



     //----------------------------------------------------------------------------------


     //Tree 2
        Tree<String> tree2 = new Tree<String>();
        tree2.addValue("Anirudh");
        Node<String> c = new Node<String>("Charisma");
        Node<String> s = new Node<String>("susan");
        Node<String> b = new Node<String>("brandon");
        Node<String> y = new Node<String>("yerita");
        Node<String> e = new Node<String>("emanuel");
        Node<String> q = new Node<String>("queen");
        Node<String> r = new Node<String>("rogers");
        Node<String> k = new Node<String>("kyra");

     //let us make the following tree
     /*
                           (A)
                        /      \           depth: 4
                       (C)      (S)
                       / \      / \
                     (B) (Y)  (E)  (Q)
                                   /
                                 (R)
                                    \
                                    (K)

        */
        tree2.getHead().assignLeft(c);
        tree2.getHead().assignRight(s);
        tree2.getHead().getLeft().assignLeft(b);
        tree2.getHead().getLeft().assignRight(y);
        tree2.getHead().getRight().assignLeft(e);
        tree2.getHead().getRight().assignRight(q);
        tree2.getHead().getRight().getRight().assignLeft(r);
        tree2.getHead().getRight().getRight().getLeft().assignRight(k);

        System.out.println("Inorder: "+ tree2.toString() );//this will out put list of all string values



     //----------------------------------------------------------------------------------
     //Tree 2
     Tree<String> tree3 = new Tree<String>();
     tree3.addValue("Anirudh");

     //let us make the following tree
     /*
                            (A)
                          /      \           depth: 4
                        (C)      (S)
                       /  \      / \
                     (B)  (Y)   (K) (R)
                     / \
                  (E)  (Q)


        */
        tree3.getHead().assignLeft(c);
        tree3.getHead().assignRight(s);
        tree3.getHead().getLeft().assignLeft(b);
        tree3.getHead().getLeft().assignRight(y);
        tree3.getHead().getLeft().getLeft().assignLeft(e);
        tree3.getHead().getLeft().getLeft().assignRight(q);

        tree3.getHead().getRight().assignRight(r);
        tree3.getHead().getRight().assignLeft(k);



        System.out.println("Inorder: "+ tree3.toString() );//this will out put list of all string values

    }


}
