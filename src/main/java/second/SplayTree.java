package second;

import java.util.Iterator;
import java.util.Stack;

public class SplayTree implements Iterable<SplayTreeNode> {

    public class SplayTreeIterator implements Iterator<SplayTreeNode> {
        private Stack<SplayTreeNode> stack = new Stack<>();
        private SplayTreeNode current;

        private SplayTreeIterator(SplayTreeNode root) {
            current = root;
        }

        public SplayTreeNode next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            SplayTreeNode splayTreeNode = current;
            current = current.right;

            return splayTreeNode;
        }

        public boolean hasNext() {
            return (!stack.isEmpty() || current != null);
        }
    }
    public Iterator<SplayTreeNode> iterator() {
        return new SplayTreeIterator(root);
    }

    SplayTreeNode root = null;
    int count;

    public void clear(){
        root = null;
        count = 0;
    }

    public SplayTree(){
        clear();
    }

    public SplayTree(int value){
        insert(value);
    }

    public void insert(int value) {
        SplayTreeNode node = root;
        SplayTreeNode parent = null;

        while (node != null) {
            parent = node;
            if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        node = new SplayTreeNode(value);
        node.parent = parent;

        if (parent == null) {
            root = node;
        } else if (value < parent.value) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        splay(node);
        count++;
    }

    private SplayTreeNode findNode(int value) {
        SplayTreeNode node = root;
        while (node != null) {
            if (value < node.value) {
                node = node.left;
            } else if (value > node.value) {
                node = node.right;
            } else {
                splay(node);
                return node;
            }
        }

        return null;
    }

    public boolean contains(int value){
        return findNode(value) != null;
    }

    public void remove(SplayTreeNode node){
        if (node == null) {
            return;
        }

        splay(node);

        if ((node.left != null) && (node.right != null)) {
            SplayTreeNode min = node.left;
            while (min.right != null) {
                min = min.right;
            }
            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        } else if (node.right != null) {
            node.right.parent = null;
            root = node.right;
        } else if (node.left != null) {
            node.left.parent = null;
            root = node.left;
        } else {
            root = null;
        }

        node.parent = null;
        node.left = null;
        node.right = null;
        count--;
    }

    public void remove(int value){
        SplayTreeNode node = findNode(value);
        remove(node);
    }

    public void makeLeftChildParent(SplayTreeNode child, SplayTreeNode parent) {
        if ((child == null) || (parent == null) || (parent.left != child) || (child.parent != parent)) {
            throw new RuntimeException("Incorrect node");
        }

        if (parent.parent != null) {
            if (parent == parent.parent.left) {
                parent.parent.left = child;
            } else {
                parent.parent.right = child;
            }
        }
        if (child.right != null) {
            child.right.parent = parent;
        }

        child.parent = parent.parent;
        parent.parent = child;
        parent.left = child.right;
        child.right = parent;
    }

    public void makeRightChildParent(SplayTreeNode child, SplayTreeNode parent) {
        if ((child == null) || (parent == null) || (parent.right != child) || (child.parent != parent)) {
            throw new RuntimeException("Incorrect node");
        }

        if (parent.parent != null) {
            if (parent == parent.parent.left) {
                parent.parent.left = child;
            } else {
                parent.parent.right = child;
            }
        }
        if (child.left != null) {
            child.left.parent = parent;
        }

        child.parent = parent.parent;
        parent.parent = child;
        parent.right = child.left;
        child.left = parent;
    }

    private void splay(SplayTreeNode x) {
        while (x.parent != null) {
            SplayTreeNode parent = x.parent;
            SplayTreeNode grand = parent.parent;
            if (grand == null) {
                if (x == parent.left) {
                    makeLeftChildParent(x, parent);
                } else {
                    makeRightChildParent(x, parent);
                }
            } else {
                if (x == parent.left) {
                    if (parent == grand.left) {
                        makeLeftChildParent(parent, grand);
                        makeLeftChildParent(x, parent);
                    } else {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                } else {
                    if (parent == grand.left) {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } else {
                        makeRightChildParent(parent, grand);
                        makeRightChildParent(x, parent);
                    }
                }
            }
        }
        root = x;
    }

    public int count(){
        return count;
    }

}
