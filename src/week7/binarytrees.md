# Binary Trees
>
> NOT SEARCH. Basically a randomly sorted binary tree.

How do a I traverse a binary tree?

* Preorder: Root left right
* Inorder: left root right
* Postorder: left right root

This can be easily implemented with a recursive algorithm, building each subtree.
If build a subtree that is null, then we do nothing.

## Preorder (DFS): Root Left Right

```java
BinaryTree b;
String preorder_output = "";

public static void preorder(BinaryTree b) {
    preorder_output += b.root;
    preorder(b.left);
    preorder(b.right);
}
```

## Inorder: Left Root Right

```java
BinaryTree b;
String preorder_output = "";

public static void preorder(BinaryTree b) {
    preorder(b.left);
    preorder_output += l.root;
    preorder(b.right);
}
```


## Inorder: Left Right Root

```java
BinaryTree b;
String preorder_output = "";

public static void preorder(BinaryTree b) {
    preorder(b.left);
    preorder(b.right);
    preorder_output += l.root;
}
```