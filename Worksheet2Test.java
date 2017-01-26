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
    public void deleteTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(20, a);
        Tree expected = new Tree(30, new Tree(15, new Tree(10, new Tree(5), new Tree()), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deleteTest2(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(99, a);
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deleteTest3(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(30, a);
        Tree expected = new Tree(27, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree())), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deleteTest4(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.delete(5,Worksheet2.delete(22, Worksheet2.delete(27, Worksheet2.delete(25, Worksheet2.delete(40, a)))));
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(), new Tree(15)), new Tree()), new Tree(37, new Tree(35, new Tree(32), new Tree()), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
    }

    @Test
    public void deleteTest5(){

        Tree a = new Tree(25, new Tree(20, new Tree(), new Tree(22, new Tree(), new Tree(23))), new Tree());
        Tree actual = Worksheet2.delete(20, a);
        Tree expected = new Tree(25, new Tree(22, new Tree(), new Tree(23)), new Tree());
        assertEquals(expected,actual);
    }

    /**
     * Testing isHeightBalanced method
     */
    @Test
    public void isHeightBalancedTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        boolean actual = Worksheet2.isHeightBalanced(a);
        assertTrue(actual);
    }

    @Test
    public void isHeightBalancedTest2(){

        Tree a = new Tree();
        boolean actual = Worksheet2.isHeightBalanced(a);
        assertTrue(actual);
    }

    @Test
    public void isHeightBalancedTest3(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(), new Tree(15)), new Tree()), new Tree(37, new Tree(35, new Tree(32), new Tree()), new Tree(50, new Tree(45), new Tree(55))));
        boolean actual = Worksheet2.isHeightBalanced(a);
        assertFalse(actual);
    }

    @Test
    public void isHeightBalancedTest4(){

        Tree a = new Tree(30);
        boolean actual = Worksheet2.isHeightBalanced(a);
        assertTrue(actual);
    }

    /**
     * Testing insertHB method
     */
    @Test
    public void insertHBTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.insertHB(2, Worksheet2.insertHB(1,a));
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(2, new Tree(1), new Tree(5)), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void insertHBTest2(){

        Tree a = new Tree();
        Tree actual = Worksheet2.insertHB(2, Worksheet2.insertHB(1,a));
        Tree expected = new Tree(1, new Tree(), new Tree(2));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void insertHBTest3(){

        Tree a = new Tree();
        boolean hb = Worksheet2.isHeightBalanced( Worksheet2.insertHB(2, Worksheet2.insertHB(1,Worksheet2.insertHB(30, Worksheet2.insertHB(-2, Worksheet2.insertHB(90, Worksheet2.insertHB(200, Worksheet2.insertHB(504, Worksheet2.insertHB(22, Worksheet2.insertHB(90, a))))))))));
        boolean st =  Worksheet2.isSearchTree(Worksheet2.insertHB(2, Worksheet2.insertHB(1,Worksheet2.insertHB(30, Worksheet2.insertHB(-2, Worksheet2.insertHB(90, Worksheet2.insertHB(200, Worksheet2.insertHB(504, Worksheet2.insertHB(22, Worksheet2.insertHB(90, a))))))))) );
        boolean actual = hb && st;
        assertTrue(actual);

    }

    @Test
    public void insertHBTest4(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.insertHB(30, a);
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    /**
     * Testing deleteHB method
     */
    @Test
    public void deleteHBTest1(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(2, new Tree(1), new Tree(5)), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.deleteHB(2, Worksheet2.deleteHB(1,a));
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void deleteHBTest2(){

        Tree a = new Tree(30, new Tree(20), new Tree());
        Tree actual = Worksheet2.deleteHB(30, Worksheet2.deleteHB(20, Worksheet2.deleteHB(50, a)));
        Tree expected = new Tree();
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void deleteHBTest3(){

        Tree a = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        Tree actual = Worksheet2.deleteHB(89807,  a);
        Tree expected = new Tree(30, new Tree(20, new Tree(10, new Tree(5), new Tree(15)), new Tree(25, new Tree(22), new Tree(27))), new Tree(40, new Tree(35, new Tree(32), new Tree(37)), new Tree(50, new Tree(45), new Tree(55))));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void deleteHBTest4(){

        Tree a = new Tree(10, new Tree(5, new Tree(1), new Tree(6)), new Tree(15, new Tree(14), new Tree(20, new Tree(19), new Tree())));
        Tree actual = Worksheet2.deleteHB(14,  a);
        Tree expected = new Tree(10, new Tree(5, new Tree(1), new Tree(6)), new Tree(19, new Tree(15), new Tree(20)));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));


    }

    /**
     * Testing balance method
     */
    @Test
    public void balanceTest1(){

        Tree a = new Tree(10, new Tree(), new Tree(20, new Tree(15), new Tree()));
        Tree actual = Worksheet2.balance(a);
        Tree expected = new Tree(15, new Tree(10), new Tree(20));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void balanceTest2(){

        Tree a = new Tree(10, new Tree(), new Tree(20, new Tree(), new Tree(30)));
        Tree actual = Worksheet2.balance(a);
        Tree expected = new Tree(20, new Tree(10), new Tree(30));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void balanceTest3(){

        Tree a = new Tree(30, new Tree(20, new Tree(10), new Tree()), new Tree());
        Tree actual = Worksheet2.balance(a);
        Tree expected = new Tree(20, new Tree(10), new Tree(30));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }

    @Test
    public void balanceTest4(){

        Tree a = new Tree(30, new Tree(20, new Tree(), new Tree(25)), new Tree());
        Tree actual = Worksheet2.balance(a);
        Tree expected = new Tree(25, new Tree(20), new Tree(30));
        assertEquals(expected,actual);
        assertTrue(Worksheet2.isSearchTree(actual));
        assertTrue(Worksheet2.isHeightBalanced(actual));
    }



}
