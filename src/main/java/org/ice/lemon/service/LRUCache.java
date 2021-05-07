package org.ice.lemon.service;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //fake node
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail ;
        tail.prev = head ;

    }

    public Integer get(int key){
        DLinkedNode node = map.get(key);
        if( node == null){
            return -1;
        }
        // move this key to the head
        moveToHead(node);
        return node.value;
    }
    public void put(int key , int value){
        // if size == capacity
        if(size == capacity){
            //first remove the tail

DLinkedNode node = removeTail();
map.remove(node.key);


        }
        //second add to head
DLinkedNode node = new DLinkedNode(key, value);
        map.put(key, node);
        addToHead(node);
        size++;
    }

    private void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next.prev = node.next;
        head.next = node;
        node.prev = head;
    }
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        size--;
        return res;
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class DLinkedNode{
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;

        public DLinkedNode() {
        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
