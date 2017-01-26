import java.io.BufferedWriter;
import java.io.FileWriter;

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
     *
     * @param t
     * @return
     */
    public static Tree negateAll(Tree t) {

        if (t.isEmpty()) {
            return new Tree();
        } else {
            return new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
        }
    }


    /**
     * Exercise 2: Mirror image (10%)
     * static Tree mirror(Tree a)
     * Given a tree a, construct and return a tree that is the mirror image of a along the left-right axis.
     * The tree on the left is the mirror image of the tree on the right, and vice versa.
     *
     * @param t
     * @return
     */
    public static Tree mirror(Tree t) {

        if (t.isEmpty()) {
            return new Tree();
        } else {
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
     *
     * @param t
     * @return
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
     *
     * @param a
     * @return
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
     *
     * @param a
     * @return
     */
    public static boolean isSearchTree(Tree a) {

        return isSearchTreeHelper(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     *
     * @param a
     * @param min
     * @param max
     * @return
     */
    public static boolean isSearchTreeHelper(Tree a, int min, int max) {

        if (a.isEmpty()) {
            return true;
        } else if (a.getValue() < min || a.getValue() > max) {
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
     *
     * @param a
     */
    public static void printDescending(Tree a) {

        if(a.isEmpty()) {
            return;
        } else {
            printDescending(a.getRight());
            System.out.print(a.getValue());
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
     *
     * @param a
     * @return
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
     *
     * @param x
     * @param a
     * @return Tree with specified element removed if element cannot be found tree is not changed.
     */
    public static Tree delete(int x, Tree a) {

        if (a.isEmpty()) {
            return new Tree();
        } else if ( x > a.getValue() ) {
            return new Tree(a.getValue(), a.getLeft(), delete(x, a.getRight()));
        } else if ( x < a.getValue() ) {
            return new Tree(a.getValue(), delete(x, a.getLeft()), a.getRight());
        } else {
            // value is found here
            if( !a.getRight().isEmpty() && !a.getLeft().isEmpty()) {
                int M = max(a.getLeft());
                return new Tree(M, delete(M, a.getLeft()), a.getRight());
            } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()){
                return delete(x, new Tree());
            } else if (a.getLeft().isEmpty() && !a.getRight().isEmpty()){
                return new Tree(a.getRight().getValue(),  delete(x, a.getLeft()), new Tree());
            } else {
                return new Tree(a.getLeft().getValue(), new Tree(), delete(x, a.getRight()));
            }
        }
    }

    // Exercise 9
    public static boolean isHeightBalanced(Tree a) {

        if (a.isEmpty()) {
            throw new IllegalStateException("The tree is empty");
        } else if ( a.getLeft().isEmpty() || a.getRight().isEmpty()  ){
            return true;
        } else if ( (a.getLeft().getHeight() - a.getRight().getHeight()) > 1 ) {
            return false;
        } else {
            return (isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight()));
        }
    }

    // Exercise 10

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

    public static Tree deleteHB(int x, Tree a) {

        if (a.isEmpty()) {
            return new Tree();
        } else if ( x > a.getValue() ) {
            return balance(new Tree(a.getValue(), a.getLeft(), deleteHB(x, a.getRight())));
        } else if ( x < a.getValue() ) {
            return balance(new Tree(a.getValue(), deleteHB(x, a.getLeft()), a.getRight()));
        } else {
            // value is found here
            if( !a.getRight().isEmpty() && !a.getLeft().isEmpty()) {
                int M = max(a.getLeft());
                return new Tree(M, deleteHB(M, a.getLeft()), a.getRight());
            } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()){
                return deleteHB(x, new Tree());
            } else if (a.getLeft().isEmpty() && !a.getRight().isEmpty()){
                return new Tree(a.getRight().getValue(),  deleteHB(x, a.getLeft()), new Tree());
            } else {
                return new Tree(a.getLeft().getValue(), new Tree(), deleteHB(x, a.getRight()));
            }
        }
    }

    /**
     * @param a
     * @return
     */
    public static Tree balance(Tree a){

        Tree t = new Tree();
        int height = (a.getLeft().getHeight() - a.getRight().getHeight() );

        if (height < -1 ) {
            // right left case
            if (a.getRight().getLeft().getHeight() > a.getRight().getRight().getHeight()) {
                return leftRotate(new Tree(a.getValue(), a.getLeft(), rightRotate(a.getRight())));
            // left case
            } else {
                return leftRotate(a);
            }
        } else if (height > 1){
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
     * Rotates left around the given node.
     *
     * @param pivot
     * @return
     */
    public static Tree rightRotate(Tree pivot) {

        Tree b = (pivot.getLeft().getRight().isEmpty())? new Tree():pivot.getLeft().getRight();
        Tree right = new Tree(pivot.getValue(), b, pivot.getRight());
        return new Tree(pivot.getLeft().getValue(), pivot.getLeft().getLeft(), right);
    }

    /**
     * Rotates right around the given node.
     *
     * @param pivot
     * @return
     */
    public static Tree leftRotate(Tree pivot) {

            Tree b = (pivot.getRight().getLeft().isEmpty())? new Tree():pivot.getRight().getLeft();
            Tree left = new Tree(pivot.getValue(), pivot.getLeft(), b);
            return new Tree(pivot.getRight().getValue(), left, pivot.getRight().getRight());
    }

    /**
     * Helper method to create balanced binary search trees quickly.
     *
     * @param a
     * @param start
     * @param end
     * @return
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

        //System.out.println(insertHB(56,insertHB(89,insertHB(78,insertHB(44, a)))));
//        System.out.println("u" + u);
//        System.out.println(balance(u));
//        System.out.println("v" + v);
//        System.out.println(balance(v));
        //System.out.println(w);
//        System.out.println("w" + w);
//        System.out.println(balance(w));
//        System.out.println("x" + x);
//        System.out.println(balance(x));
//        System.out.println(negateAll(t));
//        System.out.println(t);
//        System.out.println(mirror(t));
//        System.out.println(postorder(t));
//        System.out.println(a);
//          System.out.println(allPositive(a));
//        System.out.println(isSearchTree(t));
//        printDescending(t);
//        System.out.println(max(t));
//        System.out.println(delete(8, t));
//        System.out.println(isHeightBalanced(t));
//
//        System.out.println(x);
//        System.out.println(balance(x));
        //System.out.println(v);
        //System.out.println(leftRotate(x.getLeft()));
       // System.out.println(rightRotate(v));

        System.out.println( new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55)))));
        //System.out.println(rightRotate(v));

//
//        System.out.println(U);
//        System.out.println(delete(25, U));

        //System.out.println(a);
        //System.out.println(insertHB(26, a));
//        System.out.println("unbalanced");
//        System.out.println(delete(40, a));
//        System.out.println("balanced");
        //System.out.println(a);
//        System.out.println("unbalanced");
//        System.out.println(delete(55, delete(38,delete(40, a))));
//        System.out.println("balanced");
//        System.out.println(deleteHB(55, deleteHB(38,deleteHB(40, a))));
        }
    }


