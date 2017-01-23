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
     * Given a tree a, produce and return a list containing the values in a by trvaersing the nodes in postorder,
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
            throw new IllegalStateException("The tree is empty");
        } else if ( a.getLeft().isEmpty() || a.getRight().isEmpty()  ){
            return ( a.getValue() > 0 );
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

        if (a.isEmpty()) {
            throw new IllegalStateException("The tree is empty");
        } else if ( a.getLeft().isEmpty() || a.getRight().isEmpty()  ){
            return true;
        } else if ( a.getLeft().getValue() > a.getValue() || a.getRight().getValue() < a.getValue() ) {
            return false;
        } else{
            return (allPositive(a.getLeft()) && allPositive(a.getRight()));
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
            if( !a.getRight().isEmpty() && !a.getLeft().isEmpty()) {
                int M = max(a.getLeft());
                return new Tree(M, delete(M, a.getLeft()), a.getRight());
            } else if (a.getLeft().isEmpty() && a.getRight().isEmpty()){
                return delete(x, new Tree());
            } else if (a.getLeft().isEmpty()){
                return new Tree(a.getRight().getValue(), new Tree(), delete(x, a.getRight()));
            } else  {
                return new Tree(a.getLeft().getValue(), delete(x, a.getLeft()), new Tree());
            }
        }

    }



    // Exercise 9
    public static boolean isHeightBalanced(Tree a) {
        return true;
    }

    // Exercise 10

    public static Tree insertHB(int x, Tree a) {
        return new Tree();
    }

    public static Tree deleteHB(int x, Tree a) {
        return new Tree();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Tree t = new Tree (6,
                new Tree(4,
                        new Tree( 2,
                                new Tree(1, new Tree(), new Tree()),
                                new Tree()),
                        new Tree(5, new Tree(), new Tree())),
                new Tree(8, new Tree(7, new Tree(), new Tree()),
                        new Tree(9, new Tree(), new Tree())));


//        System.out.println(negateAll(t));
//        System.out.println(t);
//        System.out.println(mirror(t));
//        System.out.println(postorder(t));
//        System.out.println(allPositive(t));
//        System.out.println(isSearchTree(t));
//        printDescending(t);
//        System.out.println(max(t));
        System.out.println(delete(4, t));


        }
    }


