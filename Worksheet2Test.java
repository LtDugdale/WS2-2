import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author Alexandros Evangelidis
 *
 *
 */

public class Worksheet2Test {

    /**
     * Testing addToTree method
     */
    @Test
    public void addToTreeTest1() {
        int [] a = {60, 55, 50, 45, 40, 35, 30, 25, 10};
        Tree actual = Worksheet2.addToTree(a, 0, a.length-1);
    }
    /**
     * Testing negateAll method
     */
    @Test
    public void negateAllTest1(){

        Tree a = new Tree (-6, new Tree(-4, new Tree( 2, new Tree(1, new Tree(-2), new Tree()),
                new Tree()), new Tree(5, new Tree(), new Tree())), new Tree(-8, new Tree(7, new Tree(),
                new Tree()), new Tree(9, new Tree(), new Tree())));
        Tree actual = Worksheet2.negateAll(a);
        Tree expected = new Tree (6, new Tree(4, new Tree( -2, new Tree(-1, new Tree(2), new Tree()),
                        new Tree()), new Tree(-5, new Tree(), new Tree())), new Tree(8, new Tree(-7, new Tree(),
                        new Tree()), new Tree(-9, new Tree(), new Tree())));

        assertEquals(expected, actual );
    }

    @Test
    public void negateAllTest2(){

        Tree a = new Tree ();
        Tree actual = Worksheet2.negateAll(a);
        Tree expected = new Tree ();

        assertEquals(expected, actual );
    }

    @Test
    public void negateAllTest3(){

        Tree a = new Tree (-6, new Tree(-4, new Tree( -2, new Tree(-1, new Tree(-2), new Tree()),
                new Tree()), new Tree(-5, new Tree(), new Tree())), new Tree(-8, new Tree(-7, new Tree(),
                new Tree()), new Tree(-9, new Tree(), new Tree())));
        Tree actual = Worksheet2.negateAll(a);
        Tree expected = new Tree (6, new Tree(4, new Tree( 2, new Tree(1, new Tree(2), new Tree()),
                new Tree()), new Tree(5, new Tree(), new Tree())), new Tree(8, new Tree(7, new Tree(),
                new Tree()), new Tree(9, new Tree(), new Tree())));

        assertEquals(expected, actual );
    }

    /**
     * Testing mirror method
     */
    @Test
    public void mirrorTest1(){

        Tree a = new Tree(20, new Tree(), new Tree(30, new Tree(), new Tree(40)));
        Tree actual = Worksheet2.mirror(a);
        Tree expected = new Tree(20, new Tree(30, new Tree(40), new Tree()), new Tree());
        assertEquals(expected, actual );
    }

    @Test
    public void mirrorTest2(){

        Tree a = new Tree();
        Tree actual = Worksheet2.mirror(a);
        Tree expected = new Tree();
        assertEquals(expected, actual );
    }

    /**
     * Testing postorder method
     */
    @Test
    public void postorderTest1(){

        Tree a = new Tree();
        List actual = Worksheet2.postorder(a);
        List expected = new List();
        assertEquals(expected, actual);
    }

    @Test
    public void postorderTest2(){

        Tree a = new Tree(30, new Tree(20, new Tree(10), new Tree(25)), new Tree(40, new Tree(35), new Tree(50)));
        List actual = Worksheet2.postorder(a);
        List expected = List.cons(10, List.cons(25, List.cons(20, List.cons(35, List.cons(50, List.cons(40, List.cons(30, List.empty())))))));
        assertEquals(expected, actual);
    }

    @Test
    public void postorderTest3(){

        Tree a = new Tree(30, new Tree(), new Tree(40, new Tree(), new Tree(50)));
        List actual = Worksheet2.postorder(a);
        List expected = List.cons(50, List.cons(40, List.cons(30, List.empty())));
        assertEquals(expected, actual);
    }

    /**
     * Testing allPositive method
     */
    @Test
    public void allPositiveTest1(){

        Tree a = new Tree();
        boolean actual = Worksheet2.allPositive(a);
        assertTrue(actual);
    }

    @Test
    public void allPositiveTest2(){

        Tree a = new Tree(30, new Tree(20, new Tree(10), new Tree(25)), new Tree(40, new Tree(35), new Tree(50)));
        boolean actual = Worksheet2.allPositive(a);
        assertTrue(actual);
    }

    @Test
    public void allPositiveTest3(){

        Tree a = new Tree(30, new Tree(-20, new Tree(-10), new Tree(-25)), new Tree(-40, new Tree(-35), new Tree(-50)));
        boolean actual = Worksheet2.allPositive(a);
        assertFalse(actual);
    }

    @Test
    public void allPositiveTest4(){

        Tree a = new Tree(30, new Tree(20, new Tree(-10), new Tree(25)), new Tree(40, new Tree(35), new Tree(-50)));
        boolean actual = Worksheet2.allPositive(a);
        assertFalse(actual);
    }

    /**
     * Testing isSearchTree method
     */
    @Test
    public void isSearchTreeTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10), new Tree(25)), new Tree(40, new Tree(35), new Tree(50)));
        boolean actual = Worksheet2.isSearchTree(a);
        assertTrue(actual);
    }

    @Test
    public void isSearchTreeTest2(){

        Tree a = new Tree(30, new Tree(20, new Tree(10), new Tree(45)), new Tree(40, new Tree(35), new Tree(50)));
        boolean actual = Worksheet2.isSearchTree(a);
        assertFalse(actual);
    }

    @Test
    public void isSearchTreeTest3(){

        Tree a = new Tree();
        boolean actual = Worksheet2.isSearchTree(a);
        assertTrue(actual);
    }

    /**
     * Testing max method
     */
    @Test
    public void maxTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10), new Tree(25)), new Tree(40, new Tree(35), new Tree(50)));
        int actual = Worksheet2.max(a);
        int expected = 50;
        assertEquals(expected,actual);
    }

    @Test
    public void maxTest2(){
;
        try {
            Tree a = new Tree();
            int actual = Worksheet2.max(a);
        } catch (Exception e) {
            assertEquals("The tree is empty", e.getMessage());
        }
    }

    @Test
    public void maxTest3(){

        Tree a = new Tree(30);
        int actual = Worksheet2.max(a);
        int expected = 30;
        assertEquals(expected,actual);
    }

    /**
     * Testing delete method
     */
    @Test
    public void deletetTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(20, a);
        Tree expected = new Tree(30, new Tree(15, new Tree(10, new Tree(5), new Tree()), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deletetTest2(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(99, a);
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deletetTest3(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(30, a);
        Tree expected = new Tree(27, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree())), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deletetTest4(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(5,Worksheet2.delete(22, Worksheet2.delete(27, Worksheet2.delete(25, Worksheet2.delete(40, a)))));
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(), new Tree(15)), new Tree()), new Tree(37, new Tree(35, new Tree(32), new Tree()), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }



}
