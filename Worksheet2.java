/**
 * @author Laurie Dugdale
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

    /**
     * Exercise 1: Negate a tree (5%)
     *
     * Given a tree of integers a, write a method that returns a new tree containing all the elements of a with
     * their sign negated, i.e., positive integers become negative and negative integers become positive.
     * ---------------------------------------------------------------------------------------------------------
     * negateAll accepts a Tree of integers, if the Tree is empty an empty tree is returned, otherwise
     * all the integers have their signs negated. e.g. -5 becomes 5 or 7 becomes -7. If a 0 is passed it remains 0.
     *
     * @param t Tree containing integers.
     * @return Tree of integers containing all the elements of the of the given tree with their sign negated.
     */
    public static Tree negateAll(Tree t) {

        // base case
        if (t.isEmpty()) {
            return new Tree();
        // recursive case
        } else {
            return new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
        }
    }


    /**
     * Exercise 2: Mirror image (10%)
     *
     * Given a tree a, construct and return a tree that is the mirror image of a along the left-right axis.
     * The tree on the left is the mirror image of the tree on the right, and vice versa.
     * ---------------------------------------------------------------------------------------------------------
     * mirror accepts a tree of integers, mirror returns a Tree of integers with all the elements mirrored vertically.
     * e.g.
     *
     *           5         |          5
     *          / \        |        /   \
     *         /   \       |       /     \
     *        /     \      |      /       \
     *       /       \     |     /         \
     *      3         8    |    8           3
     *     / \       /     |     \         / \
     *    /   \     /      |      \       /   \
     *   1     4   6       |       6     4     1
     *
     * If the Tree is empty an empty Tree is returned.
     *
     * @param t Tree containing integers.
     * @return Tree of integers with the elements of tree t mirrored vertically.
     */
    public static Tree mirror(Tree t) {

        // base case
        if (t.isEmpty()) {
            return new Tree();
        // recursive case
        } else {
            // left and right reversed to create mirror
            return new Tree(t.getValue(),mirror(t.getRight()) , mirror(t.getLeft()));
        }
    }


    /**
     * Exercise 3: Postorder traversal (10%)
     *
     * Given a tree a, produce and return a list containing the values in a by traversing the nodes in postorder,
     * i.e., for every node, all the values in the left subtree should be listed first, then all the values in the right
     * subtree and then finally the value in the node itself.
     * Hint: Recall the method for inorder traversal done in the Lecture.
     * ---------------------------------------------------------------------------------------------------------
     * postorder accepts a Tree of integers and walks the nodes in postorder. Each node is added to a List of integers
     * in the order that the tree is walked. If the Tree is empty an empty List is returned.
     *
     * @param t Tree containing integers.
     * @return List of type integer containing the elements of Tree t in a postorder sequence.
     */
    public static List postorder(Tree t) {

        if (t.isEmpty()) {
            return List.empty();
        }
        else {
            return ListOps.addToEnd( ListOps.append( postorder(t.getLeft()), postorder(t.getRight())), t.getValue());
        }
    }

    /**
     * Exercise 4: Check for positive (5%)
     *
     * Given a tree of integers a, return a boolean value indicating whether all the values in its nodes are
     * positive, i.e., ≥ 0.
     * ---------------------------------------------------------------------------------------------------------
     * allPositive accepts a Tree of integers. Returns true if all values are ≥ 0. Empty Tree returns true.
     * Otherwise if values are less than 0 allPositive returns false.
     *
     * @param a Tree containing integers.
     * @return boolean true if all the integers in Tree a are  ≥ 0.
     */
    public static boolean allPositive(Tree a) {

        if (a.isEmpty()) {
            return true;
        } else if (a.getValue() < 0) {
            return false;
        } else{
            return (allPositive(a.getLeft()) && allPositive(a.getRight()));
        }
    }

    /**
     * Exercise 5: Test for the search tree property (10%)
     *
     * Given a tree of integers a, write a method that returns a boolean value indicating whether a is a binary
     * search tree.
     * Hint: You may need helper functions to write this method. Document any helper functions you define.
     * ---------------------------------------------------------------------------------------------------------
     * binary search tree is a tree in which for every node in the tree, all the values in the left subtree are
     * smaller than It and all their values in the right are larger. Therefore there are no duplicate copies.
     * isSearchTree accepts a Tree of integers and returns false if the definition of a binary search tree is not met.
     * Returns true if given Tree is a binary search tree or if given Tree is empty.
     *
     * @param a Binary search tree containing integers.
     * @return boolean true if the structure of Tree a satisfies the conditions of a binary search tree.
     */
    public static boolean isSearchTree(Tree a) {

        return isSearchTreeHelper(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Helper method for isSearchTree
     * Recursively checks the given tree against the given max and min keys. returns false if tree does not meet
     * the properties of a binary search tree. Otherwise returns true. Also returns True if binary search tree is empty.
     *
     * @param a Binary search tree containing integers.
     * @param min is the minimum key for the subtree, must be < max.
     * @param max is the maximum key for the subtree, must be > min.
     * @return boolean true if Tree a is a binary search tree and its values are >= min and <= max.
     */
    private static boolean isSearchTreeHelper(Tree a, int min, int max) {

        if (a.isEmpty()) {
            return true;
        } else if (a.getValue() > max || a.getValue() < min) {
            return false;
        } else {
            return (isSearchTreeHelper(a.getLeft(), min, a.getValue() - 1) && isSearchTreeHelper(a.getRight(), a.getValue() + 1, max));
        }
    }

    /**
     * Exercise 6: Traversing binary search trees (10%)
     *
     * Given a binary search tree of integers a, write a method that prints the values stored in it in descending
     * order. Do this without building a separate list of the values.
     * ---------------------------------------------------------------------------------------------------------
     * Outputs the value of the given Tree a in descending order to the console, values are separated with a space.
     *
     * @param a Binary search tree containing integers.
     */
    public static void printDescending(Tree a) {

        if(a.isEmpty()) {
            return;
        } else {
            printDescending(a.getRight());
            System.out.print(a.getValue() + " ");
            printDescending(a.getLeft());
        }
    }

    /**
     * Exercise 7: Maximum value in a search tree (10%)
     *
     * Assuming that the argument tree a is a binary search tree, write an efficient method to find the maximum
     * value stored in the tree. Your method must not visit and compare all the nodes in the tree. Rather, it it
     * must traverse at most one path in the tree from the root node. This should work in O(log n) time for a
     * balanced binary tree.
     * (Hint: In a binary search tree, all the values in the left subtree of a node are less than or equal to the
     * value in the node. So, the maximum value can’t be in the left subtree, right? Where can it be?)
     * ---------------------------------------------------------------------------------------------------------
     *
     * @param a Binary search tree containing integers.
     * @return Integer with the value of the maximum value in the binary search tree. Throws exception if the tree is empty.
     */
    public static int max(Tree a) {

        if (a.isEmpty()){
            throw new IllegalStateException("The tree is empty");
        } else if(a.getRight().isEmpty()){
            return a.getValue();
        } else {
            return max(a.getRight());
        }
    }

    /**
     * Exercise 8: Deleting a value in a search tree (15%)
     *
     * Assuming that the argument tree a is a binary search tree, this method must delete the value x from a and
     * return the resulting tree. The original tree a must not be altered. Rather, you should build a new tree that
     * contains all the values of a except for one copy of x. The resulting tree must be again a binary search
     * tree.
     * Your algorithm must take time proportional to the height of the tree, which is normally O(log n).
     * (Hint: As discussed in Lecture, the node of x may have two subtrees. In that case, the node cannot be
     * simply deleted. Rather, you need to replace x in that node with the maximum value of the left subtree.)
     * ---------------------------------------------------------------------------------------------------------
     * delete is used to delete an integer from the given Tree a, returns a tree with the given integer removed.
     * If the integer cannot be found a Tree with the same values as the original is returned.
     *
     * @param x Integer representing the value to be deleted.
     * @param a Binary search tree containing integers. Tree must already a height balanced binary search tree.
     * @return Tree with specified element ( int x ) removed if element cannot be found tree is not changed.
     */
    public static Tree delete(int x, Tree a) {

        if (a.isEmpty()) {
            return new Tree();
        } else if ( x > a.getValue() ) {
            return new Tree(a.getValue(), a.getLeft(), delete(x, a.getRight()));
        } else if ( x < a.getValue() ) {
            return new Tree(a.getValue(), delete(x, a.getLeft()), a.getRight());
        } else {
            // If we're here we can get to work!
            if( !a.getRight().isEmpty() && !a.getLeft().isEmpty()) {
                int M = max(a.getLeft());
                return new Tree(M, delete(M, a.getLeft()), a.getRight());
            } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()){
                return new Tree();
            } else if (a.getLeft().isEmpty() && !a.getRight().isEmpty()) {
                return a.getRight();
            } else {
                return a.getLeft();
            }
        }
    }

    /**
     * Exercise 9: Checking for height-balanced property (5%)
     *
     * Given a tree of integers a, check to see if it is height-balanced, returning a boolean value.
     * ---------------------------------------------------------------------------------------------------------
     * isHeightBalanced accepts a Tree of integers and returns true if it is height balanced
     * e.g. left height - right height <= 1 && left height - right height >= -1
     * if Tree a is empty method returns true
     *
     * @param a Binary search tree containing integers.
     * @return Boolean true if Tree a is height balanced, or Tree a is empty.
     */
    public static boolean isHeightBalanced(Tree a) {

        if (a.isEmpty()) {
            return true;
        } else if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1 && isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight())) {
            return true;
        }
        return false;
    }

    /**
     * Exercise 10: Insertion/deletion with height-balancing (20%)
     *
     * Write modified versions of insert and delete methods that maintain the height-balanced property
     * of trees. You should assume that the input trees are height-balanced binary search trees and produce
     * results that are height-balanced binary search trees.
     * Both the methods should work in O(log n) time.
     * You may use the isHeightBalanced method in assert statements to ensure that your code works
     * correctly.
     */

    /**
     * This method is used to insert an integer into the given Tree a. Returns a Tree with the the same integers as
     * Tree a with integer x added in the appropriate place. If x is already in the tree a Tree will be returned without
     * the extra integer added. Employs the balance method to maintain the properties of an AVL tree.
     *
     * @param x Integer representing the value to be inserted.
     * @param a Binary search tree containing integers. Tree must already a height balanced binary search tree.
     * @return Tree with specified element ( int x ) inserted if element already exists, the tree is not changed.
     */
    public static Tree insertHB(int x, Tree a) {

        if (a.isEmpty()) {
            return new Tree(x);
        } else if (x < a.getValue()) {
            return balance(new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight()));
        } else if (x > a.getValue()) {
            return balance(new Tree(a.getValue(), a.getLeft(), insertHB(x, a.getRight())));
        } else {
             return a;
        }
    }

    /**
     * deleteHB is used to delete an integer from the given Tree a, returns a tree with the given integer x removed.
     * If the integer cannot be found a Tree with the same values as the original is returned.
     * Employs the balance method to maintain the properties of an AVL tree.
     *
     * @param x Integer representing the value to be deleted.
     * @param a Binary search tree containing integers.
     * @return Tree with specified element ( int x ) removed if element cannot be found tree is not changed.
     */
    public static Tree deleteHB(int x, Tree a) {

        if (a.isEmpty()) {
            return new Tree();
        } else if ( x > a.getValue() ) {
            return balance(new Tree(a.getValue(), a.getLeft(), deleteHB(x, a.getRight())));
        } else if ( x < a.getValue() ) {
            return balance(new Tree(a.getValue(), deleteHB(x, a.getLeft()), a.getRight()));
        } else {
            // If we're here we can get to work!
            if( !a.getRight().isEmpty() && !a.getLeft().isEmpty()) {
                int M = max(a.getLeft());
                return new Tree(M, delete(M, a.getLeft()), a.getRight());
            } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()){
                return new Tree();
            } else if (a.getLeft().isEmpty() && !a.getRight().isEmpty()){
                return a.getRight();
            } else {
                return a.getLeft();
            }
        }
    }

    /**
     * balance method performs the balancing necessary to maintain an AVL tree. balancing is performed in constant time.
     * The method accepts a Tree of integers. and returns a Tree of integers rearranged in the appropriate order.
     * Rotation will only be performed if the height difference between left and
     * right is 2. Otherwise the given tree is returned.
     * e.g.
     * left - right == 2 || left - right == -2
     *
     * @param a Binary search tree containing integers. Method only balances if variable height is equal to  2 or -2.
     * @return The values of Tree a rotated in the appropriate manner.
     */
    public static Tree balance(Tree a){

        int height = (a.getLeft().getHeight() - a.getRight().getHeight() );

        if (height == -2 ) {
            // right left case
            if (a.getRight().getLeft().getHeight() > a.getRight().getRight().getHeight()) {
                return leftRotate(new Tree(a.getValue(), a.getLeft(), rightRotate(a.getRight())));
            // left case
            } else {
                return leftRotate(a);
            }
        } else if (height == 2){
            // left right case
            if(a.getLeft().getRight().getHeight() >  a.getLeft().getLeft().getHeight()){
                return rightRotate(new Tree(a.getValue(), leftRotate(a.getLeft()), a.getRight()));
            // right case
            } else {
                return rightRotate(a);
            }
        } else {
            return a;
        }
    }

    /**
     * rightRotate is exclusively a helper method for the balance method and should not be used by other methods.
     * it takes a Treeand performs a single right rotate. Its a private method so no checks are made to see if the given
     * tree is appropriate to be rotated
     *
     * @param pivot Binary search tree containing integers.
     * @return Tree with the values of the binary Tree pivot rotated to the right
     */
    private static Tree rightRotate(Tree pivot) {

        Tree b = (pivot.getLeft().getRight().isEmpty()) ? new Tree():pivot.getLeft().getRight();
        Tree right = new Tree(pivot.getValue(), b, pivot.getRight());
        return new Tree(pivot.getLeft().getValue(), pivot.getLeft().getLeft(), right);
    }

    /**
     * leftRotate is exclusively a helper method for the balance method and should not be used by other methods.
     * it takes a Treeand performs a single left rotateIts a private method so no checks are made to see if the given
     * tree is appropriate to be rotated
     *
     * @param pivot Binary search tree containing integers.
     * @return Tree with the values of the binary Tree pivot rotated to the left
     */
    private static Tree leftRotate(Tree pivot) {

            Tree b = (pivot.getRight().getLeft().isEmpty()) ? new Tree():pivot.getRight().getLeft();
            Tree left = new Tree(pivot.getValue(), pivot.getLeft(), b);
            return new Tree(pivot.getRight().getValue(), left, pivot.getRight().getRight());
    }

    /**
     * Helper method to create balanced binary search trees quickly.
     *
     * @param a Array of integers in descending order, not containing duplicates.
     * @param start The start position of array a ( counting from 0 ).
     * @param end The end position of the array ( counting from 0 ).
     * @return Balanced binary search tree.
     */
    public static Tree addToTree( int [] a, int start, int end){

        if (start > end) {
            return new Tree();
        } else {
            int mid = (start + end) / 2;
            return new Tree(a[mid], addToTree(a, mid + 1, end), addToTree(a, start, mid - 1));
        }
    }

    /**
     * Main method used for quick testing as I created the methods.
     *
     * @param args
     */
    public static void main(String[] args) {

        Tree t = new Tree (6,
                new Tree(4,
                        new Tree( 2,
                                new Tree(1, new Tree(-2), new Tree()),
                                new Tree()),
                        new Tree(5, new Tree(), new Tree())),
                new Tree(8, new Tree(7, new Tree(), new Tree()),
                        new Tree(9, new Tree(), new Tree())));

        int [] A = {60, 55, 50, 45, 40, 35, 30, 25, 10};
        Tree a = addToTree(A, 0, A.length -1);
        Tree u = new Tree(10, new Tree(), new Tree(20, new Tree(15), new Tree(40)));
        Tree v = new Tree(40, new Tree(30, new Tree(20), new Tree()), new Tree());
        Tree w = new Tree(40, new Tree(), new Tree(50, new Tree(60), new Tree()));
        Tree x = new Tree(40, new Tree(20, new Tree(), new Tree(25)), new Tree());

//        System.out.println("u" + u);
//        System.out.println(balance(u));
//        System.out.println("v" + v);
//        System.out.println(balance(v));
//        System.out.println(w);
//        System.out.println("w" + w);
//        System.out.println(balance(w));
//        System.out.println("x" + x);
//        System.out.println(balance(x));
//        System.out.println(negateAll(t));
//        System.out.println(mirror(t));
//        System.out.println(postorder(t));
//        System.out.println(allPositive(a));
//        System.out.println(isSearchTree(t));
        printDescending(t);
//        System.out.println(max(t));
//        System.out.println(delete(8, t));
//        System.out.println(isHeightBalanced(t));
//        System.out.println(balance(x));
//        System.out.println(leftRotate(x.getLeft()));
//        System.out.println(rightRotate(v));
//        System.out.println(new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55)))));
//        System.out.println(U);
//        System.out.println(delete(25, U));
//        Tree ui = new Tree(20, new Tree(10, new Tree(5, new Tree(3, new Tree(2, new Tree(1), new Tree()), new Tree()), new Tree()), new Tree(6)), new Tree(25));
//        System.out.println(deleteHB(-1, ui));
//        System.out.println(Worksheet2.insertHB(2, Worksheet2.insertHB(1,insertHB(10,insertHB(25, insertHB(60, insertHB(70, insertHB(100, po))))))));
//        System.out.println(insertHB(26, a));
//        System.out.println("unbalanced");
//        System.out.println(delete(55, delete(38,delete(40, a))));
//        System.out.println("balanced");
//        System.out.println(deleteHB(55, deleteHB(38,deleteHB(40, a))));
//        System.out.println(balance(new Tree(10, new Tree(), new Tree(20, new Tree(15), new Tree()))));
//        System.out.println(balance(new Tree(10, new Tree(), new Tree(20, new Tree(), new Tree(30)))));
//        System.out.println(balance(new Tree(30, new Tree(20, new Tree(10), new Tree()), new Tree())));
//        System.out.println(balance(new Tree(30, new Tree(20, new Tree(), new Tree(25)), new Tree())));
//
//        Tree t1;
//
//        t1 = new Tree(10,
//                new Tree(5, new Tree(1, new Tree(-5), new Tree(4)), new Tree(8, new Tree(6), new Tree(9))),
//                new Tree(15, new Tree(13, new Tree(11), new Tree(14)), new Tree(20, new Tree(16), new Tree(25))));
//        System.out.println(t1);
//        t1 = Worksheet2.deleteHB(9, t1);
//        System.out.println(t1);
//
//        t1 = Worksheet2.deleteHB(8, t1);
//        System.out.println(t1);
//
//        t1 = Worksheet2.deleteHB(6, t1);
//        System.out.println(t1);

    }
    }


