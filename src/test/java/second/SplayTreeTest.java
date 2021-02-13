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
    public void clearTest() {
        tree.insert(1);
        assertTrue(tree.count() > 0);
        tree.clear();
        assertEquals(0, tree.count());
        tree.insert(1);
        assertEquals(1, tree.count());
    }

    @Test
    public void insertRootTest() {
        assertEquals(tree.root, null);

        tree.insert(2);
        assertNotNull(tree.root);
        assertEquals(2, tree.root.value);

        tree.insert(3);
        assertNotNull(tree.root);
        assertEquals(3, tree.root.value);
        assertNotNull(tree.root.left);
        assertEquals(2, tree.root.left.value);

        tree.clear();
        assertNull(tree.root);

        tree.insert(4);
        assertNotNull(tree.root);
        assertEquals(4, tree.root.value);

        tree.insert(1);
        assertNotNull(tree.root);
        assertEquals(1, tree.root.value);
        assertNotNull(tree.root.right);
        assertEquals(4, tree.root.right.value);

        tree.insert(1);
        assertNotNull(tree.root);
        assertEquals(1, tree.root.value);
        assertNotNull(tree.root.left);
        assertEquals(1, tree.root.left.value);
        assertNotNull(tree.root.right);
        assertEquals(4, tree.root.right.value);

        tree.clear();
        assertNull(tree.root);
    }

    @Test
    public void insert() {
        tree.insert(10);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 10);

        tree.insert(20);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 20);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 10);

        tree.insert(15);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 15);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 10);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 20);

        tree.insert(5);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 5);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 10);
        assertNotNull(tree.root.right.right);
        assertEquals(tree.root.right.right.value, 15);
        assertNotNull(tree.root.right.right.right);
        assertEquals(tree.root.right.right.right.value, 20);
    }

    @Test
    public void remove() {
        tree.insert(1);
        assertEquals(tree.count(), 1);
        tree.remove(0);
        assertEquals(tree.count(), 1);
        tree.remove(1);
        assertEquals(tree.count(), 0);

        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(0);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 0);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 1);
        assertNotNull(tree.root.right.right);
        assertEquals(tree.root.right.right.value, 2);
        assertNotNull(tree.root.right.right.right);
        assertEquals(tree.root.right.right.right.value, 3);

        tree.remove(2);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 1);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 0);
        assertNotNull(tree.root.right);
        assertEquals(tree.root.right.value, 3);

        tree.remove(3);
        assertNotNull(tree.root);
        assertEquals(tree.root.value, 1);
        assertNotNull(tree.root.left);
        assertEquals(tree.root.left.value, 0);
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

}
