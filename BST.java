import java.lang.Math;
import java.util.*;

public class BST {

  static class Node {

    private int key;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    private Node() {
      this.key = -1;
      this.parent = null;
      this.leftChild = null;
      this.rightChild = null;
    } //Node()

    private Node (int key) {
      this();
      this.key = key;
    }

    private Node(int key, Node parent, Node leftChild, Node rightChild) {
      this.key = key;
      this.parent = parent;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }

    public void setKey( int key) {
      this.key = key;
    }

    public int getKey() {
      return this.key;
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public Node getParent() {
      return this.parent;
    }

    public void setLeftChild(Node leftChild) {
      this.leftChild = leftChild;
    }

    public Node getLeftChild() {
      return this.leftChild;
    }

    public void setRightChild(Node rightChild) {
      this.rightChild = rightChild;
    }

    public Node getRightChild() {
      return this.rightChild;
    }

  } // Node

  private Node root;
  private int counter;

  public BST() {
    this.root = null;
    this.counter = 0;
  } //BST()

  /**
  * checks to see if the left and right children are null
  * increments the size if the children are not null
  * @return counter
  */


  public int size() {
   return this.counter;
  } //size

  /**
   * Adds element to the tree according to binary search tree structure
   * @param element integer added to tree
   */
  public void insert(int element) {
      // If tree is empty, makes the element the root
      if (this.size() == 0) {
          this.root = new Node(element);
          this.counter++;
          return;
      } // if

      Node temp = this.root;

      // Loops until element is placed in tree
      while (temp != null) {
          // Checks if element is already in tree
          if (element == temp.getKey()) {
              System.out.println("Element is already in the tree!");
              return;
          } // if
          // Moves left on tree
          if (element < temp.getKey()) {
              if (temp.getLeftChild() != null) {
                  temp = temp.getLeftChild();
              } else {
                  Node newNode = new Node(element);
                  temp.setLeftChild(newNode);
                  newNode.setParent(temp);
                  this.counter++;
                  return;
              } // if
            // Moves right on tree
          } else {
              if (temp.getRightChild() != null) {
                  temp = temp.getRightChild();
              } else {
                  Node newNode = new Node(element);
                  temp.setRightChild(newNode);
                  newNode.setParent(temp);
                  this.counter++;
                  return;
              } // if
          } // if
      } // while

  } // insert





  public void delete(int element) {
    root = deleteHelper(root, element);
    this.counter--;
  } // delete

    /**
   * A recursive function to delete an existing node in BST
   */
  Node deleteHelper(Node root, int key) {

    if (root == null) {
      return root;
    }

    if (key < root.key) {
      root.leftChild = deleteHelper(root.leftChild, key);
    } else if (key > root.key) {
      root.rightChild = deleteHelper(root.rightChild, key);
    } else {
        if (root.leftChild != null && root.rightChild != null) {
            Node check = root;
            Node temp = maxValue(check.leftChild);
            root.key = temp.key;
            root.leftChild = deleteHelper(root.leftChild, temp.key);
        } else if (root.leftChild != null) {
            return root.leftChild;
        } else if (root.rightChild != null) {
            return root.rightChild;
        } else {
            root = null;
        } // if
    } // if
    return root;
  } // deleteHelper

    /**
   * Helper method for delete to determine
   * maximum value
   */
  Node maxValue(Node root) {
      if (root == null) {
          return null;
      } else {
          Node maxKey = root;
          while (maxKey.rightChild != null) {
              maxKey = maxKey.rightChild;
          } // while
          return maxKey;
      } // if
  } // maxValue


  public void preorder() {
      if (this.root == null) {
          System.out.println("Tree is empty. Nothing to traverse.");
      } // if
      preorderHelper(root);
  } // preorder


  public void postorder() {
      if (this.root == null) {
          System.out.println("Tree is empty. Nothing to traverse.");
      } // if
    postorderHelper(root);
  } //postorder



    /**
     * Prints the elements of the tree inorder, meaning checking
     * the left subtree, the node, and the right subtree
     */
  public void inorder() {
      if (this.root == null) {
        System.out.println("Tree is empty. Nothing to traverse.");
        return;
      } // if
      inorderHelper(root);
  } //inorder


  private void preorderHelper(Node current) {
    if (current == null) {
      return;
    }
    System.out.print(current.key + " ");

    preorderHelper(current.leftChild);
    preorderHelper(current.rightChild);
  } //preorderHelper


  private void postorderHelper(Node current) {

    if (current == null) {
      return;
    }

    postorderHelper(current.leftChild);
    postorderHelper(current.rightChild);

    System.out.print(current.key + " ");
  } //postorderHelper


    /**
     * Helper method for inorder that recursively checks left
     * and right nodes for order
     * @param current node being checked
     */
  private void inorderHelper (Node current) {
      if (current.getLeftChild() != null) {
          inorderHelper(current.getLeftChild());
      } // if
      System.out.print(current.key + " ");
      if (current.getRightChild() != null) {
          inorderHelper(current.getRightChild());
      } // if
  } //inorderHelper

   public static void main(String[] args) {
      BST tree = new BST();

      tree.insert(4);

      tree.insert(5);

      tree.insert(2);

      tree.insert(9);

      tree.insert(6);

      tree.insert(11);

      tree.insert(10);

      tree.insert(8);

      tree.insert(1);

      tree.insert(14);

      System.out.println("Example 1: preorder traversal");

      System.out.println("Expected:\t" + "4 2 1 5 9 6 8 11 10 14");

      System.out.print("Your Tree:\t");

      tree.preorder();

      System.out.println("\nExample 2: postorder traversal");

      System.out.println("Expected:\t" + "1 2 8 6 10 14 11 9 5 4");

      System.out.print("Your Tree:\t");

      tree.postorder();

      System.out.println("\nExample 3: inorder traversal");

      System.out.println("Expected:\t" + "1 2 4 5 6 8 9 10 11 14");

      System.out.print("Your Tree:\t");

      tree.inorder();

      tree.delete(1);

      System.out.println("\nExample 4: preorder traversal after a deleting a "

      + "leaf");

      System.out.println("Expected:\t" + "4 2 5 9 6 8 11 10 14");

      System.out.print("Your Tree:\t");

      tree.preorder();

      tree.delete(6);

      System.out.println("\nExample 5: preorder traversal after a deleting a "

      + "node with one child");

      System.out.println("Expected:\t" + "4 2 5 9 8 11 10 14");

      System.out.print("Your Tree:\t");

      tree.preorder();

      tree.delete(9);

      System.out.println("\nExample 6: preorder traversal after a deleting a "

      + "node with two children");

      System.out.println("Expected:\t" + "4 2 5 8 11 10 14");

      System.out.print("Your Tree:\t");

      tree.preorder();

      System.out.println("\nExample 7: size of the tree after insertions and "

      + "deletions");

      System.out.println("Expected:\t" + "7");

      System.out.println("Your Tree:\t" + tree.size());

   } // main

} // BST
