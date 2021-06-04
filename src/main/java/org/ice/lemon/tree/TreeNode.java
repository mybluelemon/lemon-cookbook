package org.ice.lemon.tree;

public class TreeNode {
 public int key;
 public    int value;
public TreeNode left ;
public TreeNode right;
public TreeNode parent;
public int height;

 public TreeNode(){

 }
public TreeNode(int key){
 this.key = key;
}

 public TreeNode(int key, int value){
  this.key = key;
  this.value = value;
 }

 public TreeNode(int key, int value, TreeNode parent, int height) {
  this.key = key;
  this.value = value;
  this.parent = parent;
  this.height = height;
 }
}
