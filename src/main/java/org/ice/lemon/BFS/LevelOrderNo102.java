package org.ice.lemon.BFS;

import com.sun.security.jgss.GSSUtil;
import org.ice.lemon.tree.TreeNode;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderNo102 {
    /**
     * fhbfbvzvbsz
     * 其实怎么说呢，这是一道简单的遍历，
     * 注意边界情况，null-》 没了
     * 首先第一个肯定是root
     * 我们可以初始化最开始的res,
     * 我们需要一个queue，这个queue是可以支持先进先出的，pop/push
     * 当这个queue空了的时候，我们可以确定没了
     * root res
     * while(queue)
     * count queue.size
     * if
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> one = new ArrayList<>(root.value);
//        res.add(one);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0 ; i < count ; i++){
                TreeNode head = queue.pop();
                if(head.left != null) {
                    queue.addLast(head.left);
                }
                if(head.right != null) {
                    queue.addLast(head.right);
                }
                sub.add(head.value);
            }
            res.add(sub);
        }
        for(List<Integer> list: res){
            list.forEach(v -> System.out.print(v + " "));
            System.out.println();
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
        levelOrder(root);
    }
}
