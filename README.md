# For First Question

# Add Method

Before first question, I implemented add method. I have made my method such that it attains perfect bianry tree.My add method works based on recursion. Whenever we add something using addValue or add method, the number of children count will go up by one. The add method recursively changes and points to a certain node until it hits the base cases. For example, if the node is 5th node, intutively it should go to right of 1st left node. The add method will decide this for us. By defauly, our add method points to head. First, as this is an odd number, 5%2 is 1, therefore, our pointer has to be moved to right, but this step will not be done until the recursion method hits the base cases. Therefore, this step(5%2 = 1, move to right) will be added to stack until base step gets hit. The 5/2(5/2 = 2) will be passed into the same method. 2 is the base case. Therefore, our pointer will move to left from the head. Next, the recusive step that has been staying in stack will be executed. Which means, our pointer will now move to right from its previous postion. If we look at the trajectory of our node, first it has been moved to left. Second, it has been to right. The add method also increases numChild count of every node that it passes through while recursive travel step.
For example, when 5 is added, the numChildren attribute of node 1 and node 2 will get incremented by 1. For example, before 5 was added, number of children for head was 3. After 5 has been added number of children for head will be 4. Same goes for node 2.

                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \                /  \
              /     \              /    \
             (4)      (5)         (6)   (7)
             /  \    /   \        / \
            /    \  /     \      /   \
           (8) (9) (10)  (11)  (12) (13)
# Add Method time complexity and space complexity

    Time complexity:
      O(n)

    Space complexity:

      O(n)


# For Second Question

# depth() method

The depth method will iterate through the tree to compute the maximum depth. The loop works based on numChildren attribute. For example, consider the tree below,
the tree has 14 children in total. Right node has 5 children and left node has 9 children. If we were to call the depth method for the below tree. It will first check which node has highest number of children. In our case, left node has more number of children. Therefore, our pointer node will to left and increment the integer attribute called depth by 1. Now our pointer node is on left node(2). The loop will find which node has more number of children. Left of 2 has more children. Therefore our node will increment depth attribute by 1 and move left(4). This way until the loop reaches node with value 90, the loop will follow the same process. By the end of our loop, we will have the depth.

                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \                /  \
              /     \              /    \
             (4)      (5)         (6)   (7)
             /  \    /   \        / \
            /    \  /     \      /   \
           (8) (9) (10)  (11)  (12) (13)
          /
         (23)
            \
            (90)

# depth() Method time complexity and space complexity

    Time Complexity:

      O(n)

    Space Complexity:

      O(1)


# pathToRoot() method

The pathToRoot method uses one attribute and one non-static method of the Node. When we call pathToRoot method of the tree, it will call the pathToRoot method of the head node of the tree. Each node has pathToRoot and takes in a value to which path has to be found. Every time we call pathToRoot method of the tree, it will call the pathToRoot of the node. In the node, the pathToRoot will first call a method called forgetpath(). Forgetpath() is a method which will mark all children nodes that have been visited as unvisited by changing the isVisited boolean value to false. The forgetpath() is very important as we don't want to travel through the nodes that were marked visited by previous pathToRoot traversals. Once forgetPath() has been executed successfully, we will call findPath(). findPath() is a method that will mark all the nodes from head to the target node as visited by changing the isVisited() boolean value to true. For example, consider the following tree, if we call findPath(9), the method will explore every node by calling itself recursively on left and right nodes. Once the node with given value has been found, the recusrive method will stop going left or right and preeding recursive calls that are on stack will get executed. In other words, finding a node with given value is the base case. So the node will be marked as visited. When we call pathToFind(9), the pointer will mark will mark node(9) visited once it has been found. The recursive algorithm has an if statment that says if either  left node or right has been marked visited, mark this node as visited too. Therefore, once the node(9) has been marked visited, the node(4)'s if statment that are waiting in stack will get executed. The node(4) will be marked visited. Now the method executes for node(2), node(2)'s left node has been marked visited so node(2) will also be marked visited. Now the method will come to node(1) as left of node(1) is visited, node(1) is also visited now. Once findpath() completes its job, we will iterate throught the tree again. However, this time we will not iterate through all nodes. We will visit nodes that have been marked as visited and add them to the linkedlist. For example, in the situation that we considered previously, 1->2->4->9 will be added to the LinkedList while the iteration is taking place. Once the iteration is done, all the the node values from head to given value will be added into the linked list. Once every value has been added into the linkedlist, we will call the toString() method of the linkedList. The toString() method outputs all values from head to end node by iterating using a while loop.

                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \
              /     \
             (4)      (5)
             /  \    /   \
            /    \  /     \
           (8) (9) (10)  (11)
# pathToRoot() Method time complexity and space complexity

    Time complexity:

      O(n)

      Altough toString() of linkedlist and while loop after findpath() takes O(n), the O(n) is dominant.

    Space complexity:

     O(n)

# siblings() method

For siblings method, I am using a boolean attribute called siblingsVisit. Every node has siblingsVisit boolean and this is set to false by default.The siblings method will call the siblingstour method which works exactly same as pathToFind() method, but in pathToFind() we mark visited boolean as true. However, in siblingsVisit, we will mark siblingVist boolean as true. On top of that, in the base case, we will also mark the final node's finals boolean true. The finals boolean indicates if the upcoming node is final or not. The final boolean is very  important for LeastCommonSubsumer as well. The final boolean tells us if the node on right or node on left is the value for which are finding the sibling or not. For example, if we call siblings(4), node(4)'s finals boolean will be marked true. When we traverse through the tree to reach node(2) the method will detect that node(4) is final. Therefore it will return node(5). Everytime we call siblingstour, the method also calls a method called unmark. Again, the unmark method is exactly same as that of forgetpath() method. It will mark all siblingVisit boolean attributes false.

Once we have a path to the node to whom we want to find the sibling, it's the matter of checking left and right nodes to see whose isSibling is true. If we want to find node(4)'s sibling, node(1), nod(2), node(4) will be marked isSibling true. The node(4)'s finals boolean will be true as well. From head, we will check if right or left siblings is true. node(2) siblings boolean is true so we will change the pointer to (2). Now from node(2) we will check if right or left's siblings boolean or finals boolean is true. The node(2)'s left finals boolean is true. Therefore, we will return node(2)'s right node.


                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \
              /     \
             (4)      (5)
             /  \    /   \
            /    \  /     \
           (8) (9) (10)  (11)

  # siblings() method time complexity and space complexity

    Time complexity:

      O(n)

    Space complexity:

      O(n)

# LeastCommonSubsumer() method

The leastCommonSubsumer() method uses findPath() method that we discusses in one of the above methods. The only difference this time is that we will call the findPath() method two times for two give attributes. In other words, leastCommonSubsumer() takes in two different values and calls findPath() for both the values. This way the common path for both these nodes will be marked true. Once findPath() method has been called twice, we will go through the tree to find which which nodes have been marked as visited. The node where branching takes place is our leastCommonSubsumer(). For example, if we call leastCommonSubsumer(54,67), node(1), node(2), node(5), node(54), node(67) will all be marked as visited. Therefore, their visited boolean will be marked true. Once we traverse through the tree, at node(5) we will notice that both right() and left() are visited. We will stop iteration here and return node(5) as this the node where branching takes place in the common path.

                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \
              /     \
             (4)      (5)
                     /   \
                    (54)   (67)

# For second Question

For the second question, I drew various types of trees in the class called treeInstances.java. Please refer that class to see all the diagrams and implementation of my trees.

# For third question

For the third question, I wrote methods called inorder, preorder, and postorder. For every type of traversal, we need to pass a node. For every method, I passed head of the tree.

   Post order:

   When postorder() is called it will recusrively call itself on left node first and then on right node until the node on left and right are zero. Assume the following tree. When we call post order, the method will call recursively until it reaches node(8), once node(8) is reached, it will print 8. Then the previous call that is in stack will get executed, so 9 will get printed. Once these two nodes are done, 4 will get printed. This way, postorder will print children first and then their parents later.

   Inorder:

   Inorder works on the same principle as above, but instead of printing the value after calling left and right nodes, it will call the method on left node, prints itself and then calls the method on right node.

   Pre order:

   Pre order also works based on the same principle as those of inorder and postorder. In pre order, the value of the node gets printed first, then the method will be called for left node and then method will be called on right node.

  # Time Complexity and Space Complexity of all three traversals:

     Time complexity:

      O(n)

     Space Complexity:

      O(n)

                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \                /  \
              /     \              /    \
             (4)      (5)         (6)   (7)
             /  \    /   \        / \
            /    \  /     \      /   \
           (8) (9) (10)  (11)  (12) (13)

  # For question 4

  For question 4, I have used a nest while loops. The key idea here, as bose told me, is pointers. There has to be a way to come back to the node that we have visited. First we will set two pointers, temp and temp2. One pointer will by default will point to head and other pointer is just a node. We will instantitate a while loop here. The while loop will iteratively go through the tree. The temp will point to head initially, whereas for temp2 the method will go left of temp and then go keep on go till right until the right child is null. Once the right child is null, we will make point temp2's right child to temp. This way we still have a way to come to our head. If temp2's right is same as temp, we will check if temp's left is null. If its not, we go to left of the temp child. We continue the same process until temp's left is null. Once we reach temp's left equals null, that means we have come to left most node of the tree. We will return the value of this node and go to right. You might be wondering that there is no right child to last child. However, as we have been establsihing connection between temp and temp2, we can go back to parent. We will return the parent and remove temp2's connection with temp. Now, we will go to right tree and do the same process until we reach the right most node of the tree.

  To get better picture of the method(), we will consider the follwing example.

  Our algorithm will first go to 2 and reach 5. Now, 5's right will be 1. Later, our method will go to left and establish the connection between 4 and 2. Next, our algorithm will move to 4. 4 is temp2 here and 2 is temp. 4's right node is same as temp. Therefore, 4 will get printed and connection between 4 and 2 will be removed and temp will be set to 2. Then we will go to right from 2. 5's right is 1. If we go to left of 1 and keep going until we find right null, we will visit 1 again. This time, we will break connection between 5 and 1 and print them. Now, we will move to right from 1 which is 3. The above process will get repeated for node(3) as well. When we reach 7, temp will be null as 7.getRight() will never pint to anything.

  # inOrderC() method time complexity and space complexity

    Time complexity:

      O(1)

    Space complexity:

      O(n)

                         (1)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (2)                 (3)
               /   \                /  \
              /     \              /    \
             (4)      (5)         (6)   (7)


      Time




  # For question 5

  For question 5, I have used a method called isSumTree(). When isSumTree() is called, it will call the sum() method of the Node which takes in an integer and a node. The sum() is similar to post order traversal, the only difference in sum is that we are adding the values of the node to the given integer parameter rather than printing them out. The sum method returns the passed parameter(Integer). The returned Integer value has sum of all nodes of the tree including the head. Therefore once the sum is returned we will subract head value from the sum and see if the sum is equal to head.

  Consider the following Tree, the sum will do an preorder traversal of the tree and add all values to the Integer sum. In this case, sum is 60. But this sum also includes headValue. Therefore, we will subtract headvalue() from the sum which give 30. We will check if 30 is equal to head value. If it is equal, we will return true. Else, we will return false.

  # isSumTree() method time complexity and space complexity

    Time Complexity:
     O(n)
    Space Complexity:
     O(n)

                         (30)
                       /     \
                      /       \
                     /         \
                    /           \
                   /             \
                (8)                 (4)
               /   \                /  \
              /     \              /    \
             (4)      (6)         (5)   (3)

