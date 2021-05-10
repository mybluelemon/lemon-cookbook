//package org.ice.lemon.array;
//
//import java.util.Date;
//import java.util.Queue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class test {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        BlockingQueue<Long> queue = new LinkedBlockingQueue<Long>(1000) ;
//long cur = new Date().getTime() ;
//if(queue.size() > 1000 ){
//    if( (queue.peek() -cur) < 1000 * 60){
//        //remove
//        queue.take();
//        //add
//        return queue.add(cur);
//    }
//}else{
//    return queue.add(cur);
//}
//       queue.add(cur)
//
//    }
//}
