public class BST { 
  
  private class Node { 
  
    int key;
    Node parent;
    Node leftChild;
    Node rightChild;
  
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
    
    public void getKey() { 
      return this.key;
    }
    
    public void setParent(Node parent) { 
      this.parent = parent;
    } 
    
    public void getParent() { 
      return this.Parent;
    }
    
    public void setleftChild(Node leftChild) { 
      this.leftChild = leftChild;
    } 
    
    public void getleftChild() { 
      return this.leftChild;
    }
    
    public void setrightChild(Node rightChild) { 
      this.rightChild = rightChild;
    } 
    
    public void getrightChild() { 
      return this.rightChild;
    }
  
  } // Node 
  
  Node root; 
  int counter;
  
  public BST() { 
    this.root = null;
    this.counter = 0;
  } //BST()
  
  public int size() { 
  } //size 
  
  public void insert(int element) { 
  } // insert 
  
  public void delete(int element) { 
  } // delete
  
  public void preorder() { 
  } // preorder
  
  public void postorder() { 
  } //postorder 
  
  public void inorder() { 
  } //inorder
  
  private preorderHelper(Node current) {
  } //preorderHelper
  
  private postorderHelper(Node current) { 
  } //postorderHelper
  
  private inorderHelper (Node current) { 
  } //inorderHelper


} // BST 
