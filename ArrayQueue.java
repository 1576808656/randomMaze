package mazeProduce;

import mazeSolve.Queue;

public class ArrayQueue<E> implements Queue<E> {

	private Array<E> array;
	
	public ArrayQueue() {
		array = new Array<>();
	}
	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}
	@Override
	public void enqueue(E e) {
		array.add(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	//查看队列的队首是什么
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return array.getFirst();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}
	
	public int getCapacity() {
		return array.getCapacity();
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue: ");
		res.append("front [");
		for(int i=0;i<array.getSize();i++) {
			res.append(array.get(i));
			if(i < array.getSize()-1) {
				res.append(", ");
			}
		}
		res.append("] tail");
		return res.toString();
	}
	
}
