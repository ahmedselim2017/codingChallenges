class Tree{
  Node root;
  
  public void addNode(Node n){
    if(root == null)
      root = n;  
    else{
      root.addNode(n);
    }
  }
  
  
  public void traverse(){
    root.visit();
  }
  
  public boolean search(int val){
    return root.search(val, false);
  }
  


}
