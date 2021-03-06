/*
 Design and implement a data structure for Least Frequently Used (LFU) cache. It should support
  the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists
 in the cache, otherwise return -1.
 
put(key, value) - Set or insert the value if the key is not already present. When the
cache reaches its capacity, it should invalidate the least frequently used item before 
inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or 
more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?
 */
package Cache;

import java.util.HashMap;

public class LinkedHashCache implements ICache {
	private HashMap<String, DListNode> index;
	private DoublyLinkedList list;
	private int capacity;

	public LinkedHashCache(int capacity) {
		this.index = new HashMap<String, DListNode>();
		this.list = new DoublyLinkedList();
		this.capacity = capacity;
	}

	
	public Integer get(String key) {
		DListNode node = index.get(key);
		if(node == null)return null;
		list.removeAddLast(node);
		return node.value;
	}

	
	public void add(String key, Integer value) {
		//check if key already exists
		DListNode node = index.get(key);
		if(node!=null){
			node.value = value;
			list.removeAddLast(node);
		}
		else if(capacity==list.size()){
			DListNode temp = list.removeFirst();
			index.remove(temp.key);
		}
		node = list.addLast(key,value);
		index.put(key, node);
	}

	@Override
	public void display() {
		list.display();
	}

}
