class Node{
  Node left ;
  Node right ;
  int val;
  int count;
  
  Node(int val){
    this.val = val;
    
  }
 
  public void addNode(Node n){
    if(n.val < val){
      if(left == null)
        left = n;
      else
        left.addNode(n);
    }
    else if(n.val > val){
      if(right == null)
        right = n;
      else
        right.addNode(n);
    }
  }
  
  public void visit(){
    if(left != null)
      left.visit();
    print(val+"\n");
    if(right != null)
      right.visit();
  }
  
  public boolean search(int val,boolean returnVal){
    if(this.val == val){
      returnVal = true; //<>//
    }
    else if(val < this.val && this.left != null && !returnVal)
      left.search(val,returnVal);
    else if(val > this.val && this.right != null && !returnVal){
      right.search(val, returnVal); 
    }
    return returnVal;
  }
  
}
