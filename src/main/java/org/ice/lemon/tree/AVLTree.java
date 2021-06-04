package org.ice.lemon.tree;

public class AVLTree {
    public TreeNode root;


    //search just like bst


    /**
     * 很尴尬
     * insert的多，只需要正常插入，
     * 但是路径上的every one 都有可能狗带
     * 其实我的想法是，先插入，可以 bst插入可以使用递归，每次自身，连接起来
     * <p>
     * bst的插入其实还有一个方法，每次我们都处理的是当前节点她的两个孩子，在这一层就解决返回
     * 这样就可以用while循环来解决了
     * <p>
     * <p>
     * 第一种insert递归方式的话，因为以后这条路径上要旋转，会设计，最少三个节点，
     * 这样的话我们需要递归，
     * 美的递归返回之前我们先看看当前节点是不是有点不平衡
     * 怎么不平衡呢，算左子树的高度 - 右子树的高度
     * 如果我们看到说有点不行了，差值》=2 或者 《= -2 了
     * 这样就得调整一下了
     * 我们如何说判断呢
     * 首先你说这个差值就能说明一点问题
     * 差值小于0  说明这个左子树小，右子树有点大
     * 我们调解一下大的，right，到底是右右，还是右左呢，其实我们知道key的值的，比较就知道，这个路径是往左往右了
     * 我开始检查这四种情况，你说啥时候算height呢，什么情况下这个height会改变呢，会改变成什么呢
     * 首先只有当前节点的height才会变化，那你说说，会变成杀昂子捏
     * height还是需要利用，我们的两个子孩子来计算
     * 所以说你得先计算，每次我们就直接计算了，插入返回后
     * insert new node 她的height是1
     * 然后他会返回
     * 上一个节点开启计算，计算左右孩子属性
     * 然后我们要考虑的是
     * 我们算出了height，根据的是左右节点 然后发现有旋转，旋转完了，你要记住的是当前节点变成了谁，
     * 其实改变height的有两个节点，最终变成了的当前姐点会变的，平衡过后必减去1，还有原来在高处的她必减1
     * 所以 如果发生了旋转，则当前的高度必发生改变，前面算有必要吗
     * 似乎没有必要啊，但是单一个左旋，就得就得改变两个，其实我们在旋转的时候会把所有涉及到旋转的节点
     * 的height都更新一遍，and 他们更新的准则按照左右节点来算
     */
    //insert
    public void insert(int key, int value) {
if(root == null){
    root = new TreeNode(key, value, null, 1);
    return;
}
root = insertInternel(root, key ,value);
    }

    public TreeNode insertInternel(TreeNode node, int key, int value) {
        //先来一段正常的递归插入，注意对parent的赋值，以及对root的判断
        if (node == null) {
            return new TreeNode(key, value, null, 1);
        }
        if (node.key == key) {
            //不会引起高度变化，直接返回
            node.value = value;
            return node;
        } else if (key < node.key) {
            node.left = insertInternel(node.left, key, value);
            //维持一下parent关系
            node.left.parent = node ;
//暂且不返回，等着下面扭转一下，再返回
        } else {
            node.right = insertInternel(node.right, key, value);
            node.right.parent = node;
        }
        //插入 更新一波height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        //下面需要判断一下，是都需要旋转，balance状态
        int balance = getHeight(node.left) - getHeight(node.right);
        //如果balance 》= -1 and balance 《= 1， 平衡着呢，直接返回
        if(balance >= -1 && balance <= 1){
            return node;
        }
        //下面需要旋转一下
        /**
         * x
         *     y
         *   z
         */
        //右左情形，这种还是要从下往上旋转，y节点右旋，，x节点左旋
        if(balance < -1 && key < node.right.key){

            //转好了，z变 中间了
            TreeNode mid = rightRotate(node.right);
            node.right = mid;
            return leftRotate(node);
        }
        //right right
        if(balance < -1 && key > node.right.key) {
        //left rotate
            return leftRotate(node);
        }

        //zuo you
        if(balance > 1 && key > node.left.key){

            //转好了，z变 中间了
            TreeNode mid = leftRotate(node.left);
            node.left = mid;
            return rightRotate(node);
        }
        //zuozuo
        if(balance > 1 && key < node.left.key){
            return rightRotate(node);
        }
        return node;
    }

    public int getHeight(TreeNode node) {
        return node == null ? 0 : node.height;

    }

    /**
     * right rotate
     * 会从当前传入node 开始涉及3个node
     *          node1                     node2
     *   node2             ->   /   ->               node1
     *                          \               node3
     *      node3
     *
     * @return
     */
    public TreeNode rightRotate(TreeNode node1) {
TreeNode node2 = node1.left;
TreeNode node3 = node2.right;
//旋转
        node2.right = node1;
        node1.left = node3;

        //从node1， node2 开始算height
        node1.height = Math.max(getHeight(node1.left), getHeight(node1.right)) + 1;
        node2.height = Math.max(getHeight(node2.left), getHeight(node2.right)) + 1;

        //parent ?
        return node2;
    }

    /**
     * node1                     node2
     *         node2  -> node1
     *      node3            node3
     *
     *
     * @return
     */

    public TreeNode leftRotate(TreeNode node1){
        TreeNode node2 = node1.right;
        TreeNode node3 = node2.left;

        //
        node2.left = node1;
        node1.right = node3;

        node1.height = Math.max(getHeight(node1.left), getHeight(node1.right)) + 1;
        node2.height = Math.max(getHeight(node2.left), getHeight(node2.right)) + 1;
return node2;
    }

    public void printPreorder(TreeNode node){
        if(node != null){

            printPreorder(node.left);
            System.out.print(node.key + " ");
            printPreorder(node.right);
        }

    }

    public void print(){
        printPreorder(root);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for(int i = 0 ; i < 9; i++){
            tree.insert(i, i);
        }
//        tree.insert(1, 1);
//        tree.insert(2, 2);
//        tree.insert(3, 3);
        tree.print();
    }
}
