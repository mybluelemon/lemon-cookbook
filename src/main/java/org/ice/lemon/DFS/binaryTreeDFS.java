package org.ice.lemon.DFS;

import org.ice.lemon.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binaryTreeDFS {


    //preorder

    /**
     *           1
     *      2        3
     *     0   4     5  6
     * 很尴尬
     * 如何其实 就是 先访问当前节点，然后有左节点就访问节点，没有左节点
     * 就去右节点，用栈来保存路径的，但一个节点
     *
     * 其实都是路径，stack一直存的是所有路径，当左节点已经消耗殆尽
     * 吧主动权移动到右边，什么时候开始弹出呢，当当前街店没有孩子了，
     * * 如何dfs 呢，
     * @param node
     * @return
     */
    public static List<Integer> preorder(TreeNode node){

        if(node == null){
            return new ArrayList<>();
        }
        //我很尴尬，下面该如何十号
        List<Integer> res  = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode tmpNode = node;
        while(!stack.isEmpty() || tmpNode != null){
            //every node go here as a new node ,求的是此节点包括自身的
            while(tmpNode != null){
                res.add(tmpNode.value);
                stack.push(tmpNode);
                tmpNode = tmpNode.left;
            }
            //pop出来的都不能要来，其实还有右边没有遍历，但是遍历完右边，该节点也没用了，也该消失了
            tmpNode = stack.pop();
            tmpNode = tmpNode.right;

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,3);
        root.left = new TreeNode(9,9);
        TreeNode node =  new TreeNode(20,20);
        node.left  = new TreeNode(15,15);
        node.right  = new TreeNode(7,7);
        root.right = node;
        List<Integer> preorder = preorder(root);
        for (Integer integer : preorder) {
            System.out.println(integer);
        }
    }
}
