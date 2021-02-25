package second;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class SplayTreeTest {

    private SplayTree tree;

    @BeforeEach
    public void init() {
        tree = new SplayTree();
    }

    @Test
    public void clearEmptyTreeTest() {
        tree.clear();
        assertEquals(0, tree.count());
    }

    @Test
    public void clearNonEmptyTreeTest() {
        tree.insert(1);
        tree.clear();
        assertEquals(0, tree.count());
    }

    @Test
    public void emptyRootTest() {
        assertEquals(tree.root, null);
    }

    @Test
    public void insertRootEmptyTreeTest() {
        tree.insert(2);
        assertNotNull(tree.root);
        assertEquals(2, tree.root.value);
    }

    @Test
    public void insertRootNonEmptyTreeTest() {
        tree.insert(2);
        tree.insert(3);

        assertNotNull(tree.root);
        assertEquals(3, tree.root.value);
    }

    @Test
    public void insertZigTest() {
        tree.insert(10);
        tree.insert(20);

        assertNotNull(tree.root);
        assertEquals(tree.root.value, 20);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 10);
    }

    @Test
    public void insertZigZigTest() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);

        assertNotNull(tree.root);
        assertEquals(tree.root.value, 5);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 10);
        assertNotNull(tree.root.right.right);
        assertEquals(tree.root.right.right.value, 20);
    }

    @Test
    public void insertZigZagTest() {
        tree.insert(5);
        tree.insert(20);
        tree.insert(10);

        assertNotNull(tree.root);
        assertEquals(tree.root.value, 10);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 5);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 20);
    }

    @Test
    public void removeEmptyTreeTest() {
        tree.remove(0);
        assertEquals(tree.count(), 0);
    }

    @Test
    public void removeRootTest() {
        tree.insert(1);
        tree.remove(1);
        assertEquals(tree.count(), 0);
    }

    @Test
    public void removeNonExistingValueTest() {
        tree.insert(1);
        tree.remove(0);
        assertEquals(tree.count(), 1);
    }

    @Test
    public void removeZigTest() {
        tree.insert(10);
        tree.insert(20);
        tree.remove(10);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 20);
    }

    @Test
    public void removeZigZigTest() {
        tree.insert(20);
        tree.insert(10);
        tree.remove(5);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 10);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 5);
    }

    @Test
    public void removeZigZagTest() {
        tree.insert(20);
        tree.insert(8);
        tree.insert(5);
        tree.insert(10);
        tree.remove(8);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 5);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 10);
        assertNotNull(tree.root.right.right);
        assertEquals(tree.root.right.right.value, 20);
    }

    @Test
    public void dfs() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(200);
        tree.insert(300);
        tree.insert(1);

        Integer previous = null;
        for (SplayTreeNode node : tree) {
            if (previous != null) {
                assertTrue(node.value > previous);
            }
            previous = node.value;
        }
    }

    @Test
    public void contains() {
        tree.insert(1);
        tree.insert(2);

        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertFalse(tree.contains(3));
    }

    @Test
    public void find() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        tree.contains(2);

        assertNotNull(tree.root);
        assertEquals(tree.root.value, 2);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 1);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 3);
    }

}
