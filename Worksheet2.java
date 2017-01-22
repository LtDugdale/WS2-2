import java.io.BufferedWriter;
import java.io.FileWriter;

/** @author
 *
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {

    // Exercise 1

    public static Tree negateAll(Tree t) {

        if (t.isEmpty()) {
            return new Tree();
        } else {
            return new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
        }
    }

    // Exercise 2

    public static Tree mirror(Tree t) {

        if (t.isEmpty()) {
            return new Tree();
        } else {
            return new Tree(t.getValue(),mirror(t.getRight()) , mirror(t.getLeft()));
        }
    }

    // Exercise 3

    public static List postorder(Tree t) {

        if (t.isEmpty()) {
            return List.empty();
        }
        else {
            return ListOps.addToEnd( ListOps.append( postorder(t.getLeft()), postorder(t.getRight())), t.getValue());
        }
    }

    // Exercise 4

    public static boolean allPositive(Tree a) {

        if (a.isEmpty()) {
            throw new IllegalStateException("The list is empty");
        } else if ( a.getLeft().isEmpty() || a.getRight().isEmpty()  ){
            return ( a.getValue() > 0 );
        } else if (a.getValue() < 0) {
            return false;
        } else{
            return (allPositive(a.getLeft()) && allPositive(a.getRight()));
        }
    }

    // Exercise 5

    public static boolean isSearchTree(Tree a) {

        if (a.isEmpty()) {
            throw new IllegalStateException("The list is empty");
        } else if ( a.getLeft().isEmpty() || a.getRight().isEmpty()  ){
            return true;
        } else if ( a.getLeft().getValue() > a.getValue() || a.getRight().getValue() < a.getValue() ) {
            return false;
        } else{
            return (allPositive(a.getLeft()) && allPositive(a.getRight()));
        }
    }

    // Exercise 6

    public static void printDescending(Tree a) {

        if(a.isEmpty()) {
            return;
        } else {
            printDescending(a.getRight());
            System.out.print(a.getValue());
            printDescending(a.getLeft());
        }
    }

    // Exercise 7 test again

    public static int max(Tree a) {

        if (a.isEmpty()){
            throw new IllegalStateException("The tree is empty");
        } else if(a.getRight().isEmpty()){
            return a.getValue();
        } else {
            return max(a.getRight());
        }
    }

    // Exercise 8
    public static Tree delete(int x, Tree a) {
        return a;
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

        System.out.println(negateAll(t));
        System.out.println(t);
        System.out.println(mirror(t));
        System.out.println(postorder(t));
        System.out.println(allPositive(t));
        System.out.println(isSearchTree(t));
        printDescending(t);
        System.out.println(max(t));


        }
    }


