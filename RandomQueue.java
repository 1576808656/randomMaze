package mazeProduce;

import mazeSolve.Array;
import mazeSolve.Queue;

public class RandomQueue<E> implements Queue<E> {
	private LinkedList<E> array;
	public RandomQueue() {
		array = new LinkedList<>();
	}
	@Override
	public void enqueue(E e) {
		int random = (int)(Math.random()*2);
		if(random == 0)
			array.addLast(e);
		else
			array.addFirst(e);
		
	}
	@Override
	public E dequeue() {
//		if(array.getSize() == 0)
//			throw new IllegalArgumentException("There's no element to remove in Random");
//		int random = (int)(Math.random()*array.getSize());
//		E e = array.get(random);
//		array.set(random, array.getLast());
//		array.removeLast();
		if(Math.random() < 0.5)
			return array.removeLast();
		else
			return array.removeFirst();
	}
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return null;
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

}
