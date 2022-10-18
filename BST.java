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
  } // delete

  /*
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
      if (root.leftChild == null) {
        return root.rightChild;
      } else if (root.rightChild == null) {
        return root.leftChild;
      }

      root.key = minValue(root.rightChild);
      root.rightChild = deleteHelper(root.rightChild, key);
    }
    counter--;
    return root;
  }

  /*
   * Helper method for delete to determine
   * minimum value
   */
  int minValue(Node root) {
    int minValue = root.key;

    while (root.leftChild != null) {
      minValue = root.leftChild.key;
      root = root.leftChild;
    }
    return minValue;
  }


  public void preorder() {
    preorderHelper(root);
  } // preorder

  
  public void postorder() {
    postorderHelper(root);
  } //postorder

  

    /**
     * Prints the elements of the tree inorder, meaning checking
     * the left subtree, the node, and the right subtree
     */
  public void inorder() {
      if (this.root == null) {
        System.out.println("Tree is empty. NOting to traverse.");
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
      System.out.println("Tree is empty. Nothing to traverse");
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
      System.out.println(current.getKey());
      if (current.getRightChild() != null) {
          inorderHelper(current.getRightChild());
      } // if
  } //inorderHelper

   public static void main(String[] args) {
      BST tree = new BST();
      tree.insert(12);
      tree.insert(3);
      tree.insert(13);
      tree.insert(6);
      tree.insert(14);
      tree.postorder();
   } // main

} // BST
