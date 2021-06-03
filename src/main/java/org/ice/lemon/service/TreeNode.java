package org.ice.lemon.service;

public class TreeNode {
    public int key;
    public int value;
public TreeNode left ;
public TreeNode right;
public TreeNode parent;

    public TreeNode() {

    }
    public TreeNode(int key) {
        this.key = key;
        this.value = key;
    }

    public TreeNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode(int key, int value, TreeNode parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }
}
