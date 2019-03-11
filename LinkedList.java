package mazeProduce;

public class LinkedList<E> {
	
	//node节点类
	private class Node{
		//存在节点里的值
		public E e;
		//指向下一个节点的地址
		public Node next;
		
		public Node(E e,Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this.e = e;
			this.next = null;
		}
		
		public Node() {
			this.e = null;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	//存储链表头的地址
	private int size;
	//虚拟头节点
	private Node dummyHead;
	
	public LinkedList() {
		dummyHead = new Node(null,null);
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	//
	public void addFirst(E e) {
		add(0,e);
	}
	
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Illegal index");
		}
		Node prev = dummyHead;
		for(int i=0;i<index;i++) {
			prev = prev.next;
		}
		Node node = new Node(e,prev.next);
		prev.next = node;
		size++;
	}
	
	public void addLast(E e) {
		add(size,e);
	}
	
	public E get(int index) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Get failed. Illegal index");
		}
		Node cur = dummyHead.next;
		for(int i=0;i<index;i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	//设置链表指定位置的值
	public void set(int index,E e) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Set failed. Illegal index");
		}
		Node cur = dummyHead.next;
		for(int i=0;i<index;i++) {
			cur = cur.next;
		}
		cur.e = e;
	}
	
	//查找链表中是否有元素e
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		for(int i=0;i<size;i++) {
			if(e.equals(cur.e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	public E remove(int index) {
		Node prev = dummyHead;
		for(int i=0;i<index;i++) {
			prev = prev.next;
		}
		Node resNode = prev.next;
		prev.next = resNode.next;
		size--;
		return resNode.e;
	}
	
	public Node sort(Node head) {
		Node node = null;
        if(head == null){
            return null;
        }
        Node res = sort(head.next);
        if(res != null){
        	dummyHead.next = res;
        	node = res;
        	while(node.next != null) {
        		node = node.next;
        	}
            node.next = head;
            head.next = null;
            return res;
        }else{
            return head;
        }
	}
	
	public String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i=0;i<depth;i++) {
			res.append("--");
		}
		return res.toString();
	}
	
	public Node removeAll(Node head,E e,int depth) {
		String depthString = generateDepthString(depth);
		System.out.print(depthString);
		System.out.println("Call: remove "+e+" in "+toString());
		if(head == null) {
			System.out.print(depthString);
			System.out.println("Return: "+head);
			return null;
		}
		Node res = removeAll(head.next,e,depth + 1);
		System.out.print(depthString);
		Node ret;
		if(head.e.equals(e)) {
			if(dummyHead.next == head) {
				dummyHead.next = head.next;
			}
			size--;
			ret = res;
			System.out.println("After remove "+e+": "+toString());
			return res;
		}else {
			head.next = res;
			ret = head;
			System.out.print(depthString);
			System.out.println("Return: "+toString());
			return head;
		}
	}
	
	public Node getHead() {
		return dummyHead.next;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	public void removeElement(E e) {
		if(contains(e) == false) {
			return;
		}
		Node prev = dummyHead;
		while(!prev.next.e.equals(e)) {
			prev = prev.next;
		}
		prev.next = prev.next.next;
		size--;
	}
	
	@Override
	public String toString() {
		Node cur = dummyHead.next;
		StringBuilder res = new StringBuilder();
	//	res.append(String.format("LinkedList. size = %d\n", size));
		for(int i=0;i<size;i++) {
			res.append(cur.e);
			res.append("->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
}
