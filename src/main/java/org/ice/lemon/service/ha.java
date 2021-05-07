package org.ice.lemon.service;

import java.util.*;

public class ha {
    public static void main(String[] args) {
//        int len = longestofSubStr("pwwwkew");
//        System.out.println(len);

//        int[] arr1 = new int[]{1, 2, 3, 4,5 ,6, 7, 8 ,9, 10};
//        int[] arr2 = new int[]{ 1, 3, 4 ,9};
//        int i = zhongTwoArr(arr1, arr2);
//        System.out.println(i);

//        String str = longestDuiChengStr("ababad");
//        System.out.println(str);

//        int num = -12345;
//        int ans = reverse(num);
//        System.out.println(ans );
//        int[] arr = new int[]{2,15,11,7};
//        int[] ints = twoSum(arr, 9);
//        System.out.println(ints);

//        String s = "[{}]())";
//        boolean b = duichengKuoHao(s);
//        System.out.println(b);

//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        Integer integer = lruCache.get(2);
//        System.out.println(integer);

//        int sumways = sumways(3);
//        System.out.println(sumways);
//int a = '9';
//        System.out.println(a);

//String s = "-9699999999999999999";
//        int i = haAtoi(s);
//        System.out.println(i);

//        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
//        int i = biggestMianJi(arr);
//        System.out.println(i);

//        String i_love_u = new ha().replaceSpace("I love u");
//        System.out.println(i_love_u);
//        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
//        int[] inOrder = new int[]{4,7,2,1,5,3,8,6};
//        TreeNode treeNode = reBuildTree(preOrder, inOrder);
//        printPreOrder(treeNode);
//        System.out.println("");
//        printInOrder(treeNode);


int[] arr = {2,8,7,1,3,5,6,4};
qs(arr);
printArr(arr);
    }
    public static int longestofSubStr(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        Set<Character> set = new HashSet<>(s.charAt(0));
        //right point
        int rk = 0;
        int ans = 1;
        for(int i = 0 ; i < s.length(); i++){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            //
            while(rk+1 < s.length() && !set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(rk-i+1, ans);
        }
        return ans;
    }


// merge two sorted arr

public  static int[] mergeTwoSortedArr(int[] arr1 , int[] arr2){
return null;
}

//the kth number of two sorted arr
    public static int kthValue(int[] arr1 , int[] arr2, int k){
if(arr1 == null || arr1.length == 0){
    return arr2[k-1];
}
        if(arr2 == null || arr2.length == 0){
            return arr1[k-1];
        }
        //the rest is the
        int index1 = 0;
        int index2 = 0;

     return 0 ;
    }
    public static int zhongTwoArr(int[] arr1 , int[] arr2){

        if(arr1 == null || arr1.length == 0){
            if(arr2.length %2 == 0) {
                return arr2[arr2.length/2 ] + arr2[arr2.length/2 - 1];
            }else{
                return arr2[arr2.length/2 ];
            }
        }
        if(arr2 == null || arr2.length == 0){
            if(arr1.length %2 == 0) {
                return arr1[arr1.length/2 ] + arr1[arr1.length/2 - 1];
            }else{
                return arr1[arr1.length/2 ];
            }
        }
        int count = arr1.length + arr2.length;
        if (count % 2 == 0) {
            int num1 = kthRecur(arr1, 0,  arr2, 0,  count/2);
            int num2 = kthRecur(arr1, 0, arr2, 0, count/2+1);
            return (num1 + num2)/2;
        }else {
            return kthRecur(arr1, 0,  arr2, 0, count/2+1);
        }

    }
    public static  int kthRecur(int[] arr1, int startIndex1,  int[] arr2, int startIndex2, int k){
        //终止条件
        if(startIndex1 >= arr1.length){
            return arr2[startIndex2 +k -1];
        }
        if(startIndex2 >= arr2.length){
            return arr1[startIndex1 + k -1];
        }
        if(k == 1){
            return Math.min(arr1[startIndex1], arr2[startIndex2]);
        }
        //看 k/2
        int pivot1 = Math.min(startIndex1 + k/2, arr1.length -1);
        int pivot2 = Math.min(startIndex2 + k/2, arr2.length -1);
        if(arr1[pivot1] <= arr2[pivot2]){

            k = k -pivot1 + startIndex1 - 1;
            startIndex1 = pivot1 +1;
           return  kthRecur(arr1, startIndex1, arr2, startIndex2,k);
        }else {

            k = k -pivot2 + startIndex2 - 1;
            startIndex2 = pivot2 +1;
            return kthRecur(arr1, startIndex1,  arr2, startIndex2, k);
        }
    }

    public static String longestDuiChengStr(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        String ans = "";
        // from every point , to each side
       for(int i = 1; i< str.length() -1 ; i++){
           int left = i;
           int right = i ;
           while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
               if(ans.length() < right-left+1){
                   ans = str.substring(left, right+1);
               }
               left--;
               right++;
           }
       }
       //from every between plot , how
        for(int i = 0 ; i < str.length() ; i++){
            //
            int left = i ;
            int right = i + 1;
            while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
                if(ans.length() < right-left+1){
                    ans = str.substring(left, right+1);
                }
                left--;
                right++;
            }
        }
        return ans;
    }

    //number 7
    public static int reverse(int num) {
        if (num == 0) {
            return 0;
        }
        int ans = 0 ;
        while (num != 0) {
//decide ans is more or less
            if((ans > Integer.MAX_VALUE / 10) || (ans ==  Integer.MAX_VALUE / 10 && num %10 > 7) ){
                return 0;
            }
            if((ans < Integer.MIN_VALUE / 10) || (ans ==  Integer.MIN_VALUE / 10 && num %10 < -8) ){
                return 0;
            }
            //rational
            int cur = num % 10;
            ans = ans * 10 + cur;
            num = num /10 ;
        }
return ans;
    }

    //number 1
    public static int[] twoSum(int arr[] , int target){
        if(arr == null || arr.length < 2 || (arr.length == 2 && arr[0] + arr[1] != target)){
            return null;
        }
        //hash table
        //key the num, value  the index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            //
            if(map.containsKey(target - arr[i])){
                return new int[]{i,map.get(target-arr[i])};
            }
            map.put(arr[i],i);
        }
        return null;
    }
    //number 15
    //all
    public static int[] threeSum(int arr[] ,int target){
        if(arr == null || arr.length < 3 || (arr.length == 3 && arr[0] + arr[1] + arr[2] != target)){
            return null;
        }
        //
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length - 2 ; i++){

            //have to find the rest two
            int left = i+1;
            int right = arr.length - 1;
            while(left < right){
                if(arr[i] + arr[left] + arr[right] == target){
                    return new int[]{arr[i] , arr[left] , arr[right]};
                }
                if(arr[i] + arr[left] + arr[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return null;
    }
//number 53
    public static int biggestLianXvSum(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        int sum = arr[0];
        int curSum = Math.max(arr[0], 0);
        for(int i = 1 ; i < arr.length ; i++){
            curSum = curSum + arr[i];
            if(curSum < 0){
                curSum = 0 ;
            }
            sum = Math.max(sum,curSum );
        }
        return sum;
    }

    //number 21
    public static ListNode mergeTwoList(ListNode list1 , ListNode list2){
if(list1 == null){
    return list2;
}
        if(list2 == null){
            return list1;
        }
        ListNode first = list1;
        ListNode second = list2;
        ListNode res ;

        if(first.value < second.value){
            res = first;
            first = first.next;
        }else {
            res = second;
            second = second.next;
        }
        ListNode cur= res;
        while(true){
            if(first == null){
                cur.next = second;
                return res;
            }
            if(second == null){
               cur.next = first;
               return res ;
            }
            if(first.value < second.value){
                cur.next = first;
                first = first.next;
            }else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }

    }

    //number 20
    public static boolean duichengKuoHao(String s){
        if(s == null || s.length() % 2 == 1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque();
Map<Character, Character> map = new HashMap();
map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        for(int i = 0 ; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(stack.isEmpty() || stack.peek() != map.get(s.charAt(i))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
return stack.isEmpty();

    }


    //number 146 not right

    //number
    public static int sumways(int n ){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int var1 = 1 ;
        int var2 = 2;
        int res = 0;
        for(int i = 3; i<= n ;i++){
res = var1 + var2;
var1 = var2;
var2 = res;
        }
        return res;
    }

    //number 8
    public static int haAtoi(String s ){
       if(s == null || s.length() <=0){
           return 0;
       }
       s = s.trim();
       int res = 0 ;
       int fu = 1;
       if(s.charAt(0) == '-'){
           fu = -1;
       }else if(s.charAt(0) >= 48 && s.charAt(0) <= 57){
           res = s.charAt(0)-48;
       }else {
           return 0;
       }
       for(int i = 1 ; i < s.length() ; i++){
           //首先判断是否很大了

           if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
               if(fu == 1){
                   if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && (s.charAt(i)-48) >7)){
                       return Integer.MAX_VALUE;
                   }
               }else {
                   if(res < Integer.MIN_VALUE/10 ||( res == Integer.MIN_VALUE/10 && (s.charAt(i)-48) < -8)){
                       return Integer.MIN_VALUE;
                   }
               }
               res = res * 10 + s.charAt(i) -48;
           }else {
               return fu * res;
           }
       }
       return fu * res;
    }

    //number 141

    //how  to the model the different
    // ai ab
    //every point  from this one
    //ap a;
    public static int biggestMianJi(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        if (arr.length == 2) {
            return Math.abs(arr[0] - arr[1]);
        }
//
        int from = 0;
        int end = arr.length - 1;
        int res = 0;
        while (from != end) {
            int cur = (end - from) * Math.min(arr[from], arr[end]);
            res = Math.max(cur, res);
//decide the next
            if (arr[from] <= arr[end]) {
                from++;
            } else {
                end--;
            }
        }
        return res;
    }

    //number 285
    public static int kthNumber(int[] arr, int k){
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(k == 1 ){
            return arr[0];
        }
        //
        return 0;
    }

//number 104










    public int maxShen(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftShen = maxShen(root.left);
        int rightShen = maxShen(root.right);
        return Math.max(leftShen, rightShen) + 1;
    }

    public int maxShen2(TreeNode root){
        //wide

        return 0;
    }

    //star05
    public String replaceSpace(String s){
        if(s == null || s.length() <= 0){
            return "";
        }
        char[] res = new char[s.length() *3];
        int index = 0 ;
        for(char c : s.toCharArray()){
            if(c == ' '){
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';

            }else{
                res[index++] = c;
            }
        }
        return new String(res);
    }

// add to tail list
    public ListNode addToTail(ListNode head , int val){
        ListNode node = new ListNode();
        node.value  = val;
        node.next = null;
        if(head == null){
            return node;
        }else{
            ListNode cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        return  head;
    }

    public static void printPreOrder(TreeNode root){
        if(root == null){
            return ;
        }

        System.out.println(root.value);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root){
        if(root == null){
            return ;
        }
        printInOrder(root.left);
        System.out.println(root.value);
        printInOrder(root.right);
    }

    public static TreeNode reBuildTree(int[] preorder, int[] inorder){
// rebuild risk
        // from pre
        /**
         the first one of preorder  is root ,  gonna find the one fit into inorder
         and the rest  is left tree size ,  the right tree size

         */
Map<Integer, Integer> numInIndexMap = new HashMap<>();
for(int i = 0 ; i < inorder.length; i++){
    numInIndexMap.put(inorder[i],i);
}
return doRebuild(preorder, 0,preorder.length-1, 0, inorder.length -1, numInIndexMap);
    }



    public static TreeNode doRebuild(int[] preOrder, int preLeft, int preRight, int inLeft , int inRight, Map<Integer, Integer> numInIndexMap){
        if(preLeft > preRight){
            return null;
        }
        TreeNode curRoot = new TreeNode();
        curRoot.value = preOrder[preLeft];
        //root 在 in 里的位置
        int curRootInIndex = numInIndexMap.get(preOrder[preLeft]);
        int leftTreeSize = curRootInIndex - inLeft;
        // 递归 lef
        // 左边的 ，pre 从 root + 1, 到，left size
        curRoot.left = doRebuild(preOrder,  preLeft+1, preLeft+leftTreeSize, inLeft, inLeft+leftTreeSize -1, numInIndexMap );

        curRoot.right =doRebuild(preOrder,  preLeft+leftTreeSize+1 , preRight ,curRootInIndex+1, curRootInIndex + leftTreeSize, numInIndexMap  );
        return curRoot;
    }


    public static void qs(int[] arr){
        if(arr == null){
            return ;
        }
        // sort
        doqs(arr, 0, arr.length-1);
    }

    public static void doqs(int[] arr, int left , int right){
        //fit rules , do
        if(left < right){
           int index = doPart2(arr, left, right);
           doqs(arr, left, index-1);
           doqs(arr, index+1, right);
        }
    }

    public static int doPart(int[] arr, int left , int right){
//the first one is the piviot
        //i the one and before ,all is smaller or equal
//j the iterator , all the num loop , the end is swap the first one and i
        if(left >= right){
            return left;
        }
        int p = arr[left];
        int i = left ;

        for(int j = left+1 ; j <= right ; j++){
            // cur num is smaller  than pivot , i++ , if cur num is more than the pivot, dont do
            //then cur num is smaller , swap the i+1 and j , j++ . i++,
            if(arr[j] <= p){
                swap(arr, i+1, j);
                i++;
            }
        }
        //last gonna swap i and the first one
        swap(arr, left, i);
        return i;
    }


    public static int doPart2(int[] arr, int left , int right){
        //
        // i , j
        int i  = left ;
        int j = right;
        int p = arr[left];
        while(i < j ){
            //try best move i
            while(arr[i] <= p && i < j){
                i++;
            }
            while(arr[j] >= p && i < j){
                j--;
            }
            //find who break rules
            if(i < j){
                swap(arr, i, j);
            }
        }
        //who break rules, maybe i is the bigger or smaller
        if(arr[i] <= p) {
            swap(arr, left, i);
            return i;
        }else {
            //swap the i+1
            swap(arr, left, i-1);
            return i-1;
        }


    }
    public static void swap(int[] arr , int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
    System.out.println();
}





















}
