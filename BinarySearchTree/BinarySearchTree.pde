int globalCount = 0;
Tree tree;

public void setup(){
  tree = new Tree();
  Node n = new Node(5);
  
  for(int i = 0; i < 10; i++)
    tree.addNode(new Node(i));

  tree.traverse();
  print(tree.search(1));

  
}

public void draw(){
  
}
