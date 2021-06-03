package org.ice.lemon.tree;

import org.ice.lemon.service.TreeNode;

import java.util.TreeMap;

public class BSTTree {

    public TreeNode root;


    /**
     * 很尴尬，如何搞事呢
     * 首先要考虑到有很多意外情况
     * 例如 root为null
     * 线面的话，先判断root，不为空
     * 用 tmp = root 开始搜索，
     * while玄幻的判断条件是不为空
     * 如果等于就Rotterdam，负责开启下一轮
     * 最后返回null
     *
     * @param key
     * @return
     */
    public int search(int key) {
        if (root == null) {
            return -1;
        }
        TreeNode tmp = root;

        while (tmp != null) {
            if (tmp.key == key) {
                return tmp.value;
            }
            if (key < tmp.key) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return -1;
    }

    public TreeNode getNode(int key){
        if(root  == null){
            return null;
        }
        TreeNode tmp = root;
        while(tmp != null){
            if(key == tmp.key){
                return tmp;
            }else if(key < tmp.key){
                tmp  = tmp.left;
            }else {
                tmp = tmp.right;
            }
        }
        return null;
    }
    /**
     * 很尴尬的事情发生了
     * 要考虑的是边界情况和如何连接起来
     * 毕竟是个上级连接，一个比较好的方式是谁，我们每次都去判断
     * 当前节点的左右孩子，在当地完成急啥
     * xianshuodiyizhon
     * root = null， returnroot
     * tmp root
     * 核实判断key
     * 如果key = ，替换
     * key < and left == null
     * else rmo = mole
     * <p>
     * 还有一种情况
     * 我们可以递归
     * 返回值是当前值
     * 出口是null
     * if null  return new node
     * else 看key
     * 相等置换后，返回自身
     * 小于，tmp = insert(left ,) return tmp
     *
     * @param key
     * @param value
     */
    public void insert2(int key, int value ){
        if(root == null){
            root = new TreeNode(key, value);
            return ;
        }
        insertRecur(root, key, value);
    }

    /**
     * 从哪儿开始呢
     * @param tmp
     * @param key
     * @param value
     * @return
     */
    public TreeNode insertRecur(TreeNode tmp, int key, int value){
        if(tmp == null){
            return new TreeNode(key, value);
        }
        if(tmp.key == key){
            tmp.value = value;
        }else if(key < tmp.key){
            tmp.left = insertRecur(tmp.left, key, value);
        }else {
            tmp.right = insertRecur(tmp.right, key, value);
        }
        return tmp;
    }





    public void insert(int key, int value) {
        if (root == null) {
            root = new TreeNode(key, value);
        }
        TreeNode tmp = root;
        while (true) {
            if (tmp.key == key) {
                tmp.value = value;
                return;
            }
            if (key < tmp.key) {
                if (tmp.left == null) {
                    tmp.left = new TreeNode(key, value, tmp);

                    return;
                } else {
                    tmp = tmp.left;
                }

            } else {
                if (tmp.right == null) {
                    tmp.right = new TreeNode(key, value, tmp);
                    return;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }

    /**
     * 很尴尬，最左边的节点
     * 其实你说很尴尬的事情，是我们需要探测一下左孩子的情况
     * 如果node = null ，return null
     * tmp = node
     * while tmp .left != null
     * tmp = tmp.left
     * return tmp
     * @param node
     * @return
     */
    public TreeNode findMin(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode tmp = node;
        while (tmp.left != null){
            tmp =tmp.left;
        }
        return tmp;

}

    /**
     * 很麻烦
     * 首先我们需要确定一下，到底有没有这个key
     * 没有的话直接返回
     * 有的话，我们会得到这个node
     * 我们需要删除这个node
     * 如果这个node的没有孩子
     * 我们只需要断了parent和他的关系
     * 如果parent null，则node是root， root直接赋值null，返回
     * 如果parent优质，我们需要判断一下，node是左还是右
     * ，让parent的左or右为null即可
     *
     *
     * 如果node 有一个孩子
     * 我们需要将他的parent的左or右赋值成他的孩子
     * 如果parent null， 判断 左 ， 右， 赋值 root return
     * 如果parent not null， 判断node属于 左， or 右 ， 左的话，判断node 有左， or 右，
     * 如果有做，有有
     *
     *
     *
     * 如果有两个孩子
     * 很麻烦， 我们需要找到他的后继， 把 node 的key， value，赋值成 successor的key， value
     * 相当于替换了，后面删除successor的，， successor必定只有一个孩子，或者没有孩子，走上面的流程
     *
     * @param key
     * @return
     */
  public  void delete(int key){
      TreeNode node = getNode(key);
      if(node == null){
          return ;
      }

      //下面真的需要删除了呢
      //先走最复杂的
      if(node.left != null && node.right != null){
          TreeNode successor = findMin(node.right);
          node.key = successor.key;
          node.value = successor.value;
          //还需要处理successor的删除情况
          node = successor;
      }

      //下面删除的都是有一个孩子，或者没有孩子的，或者从上面继承来的
      if(node.left == null && node.right == null){
          //只需要控制其父母行为
          if(node.parent == null){
              //root
              root = null;
              return ;
          }else{
              if(node == node.parent.left){
                  node.parent.left = null;
              }else{
                  node.parent.right = null;
              }
          }

      }else{
          //有一个孩子， 需要探测父母行为， 以及node的孩子左右情况
          if(node.parent == null){
              root = node.left == null ? node.right : node.left;
          }else{
              if(node == node.parent.left){
                  node.parent.left = node.left == null ? node.right : node.left;
              }else{
                  node.parent.right = node.left == null ? node.right : node.left;
              }
          }
      }
  }

  public void printInorder(){

      printInorderInternal(root);
  }

  public void printInorderInternal(TreeNode node){
      if (node == null) {
      return;
      }
      printInorderInternal(node.left);
      System.out.println(node.key);
      printInorderInternal(node.right);
      }


  public void printInorder1(){

  }

    public static void main(String[] args) {
        BSTTree tree = new BSTTree();
        tree.insert(4,4);
        tree.insert(1,1);
        tree.insert(5, 5);
        tree.insert(3, 3);
        tree.insert(9,9);
        tree.delete(4);
        tree.printInorder();
        System.out.println(tree.search(5));

    }
}
