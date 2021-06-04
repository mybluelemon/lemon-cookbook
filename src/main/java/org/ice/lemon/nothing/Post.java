package org.ice.lemon.nothing;

import org.ice.lemon.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Post {
    public List<Integer> postorderTraversal(TreeNode root) {

        TreeNode p = root,r = null;
        List<Integer>ans = new ArrayList();
        Deque<TreeNode> s = new ArrayDeque();
        while(!s.isEmpty() || p != null)
        {
            if(p != null)
            {
                s.push(p);
                p = p.left;
            }
            else
            {
                p = s.peek();
                if(p.right == null || p.right == r)
                {
                    ans.add(p.value);
                    r = p;
                    s.pop();
                    p = null;
                }
                else
                    p = p.right;

            }

        }

        return ans;
    }
}