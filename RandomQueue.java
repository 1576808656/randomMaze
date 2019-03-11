package mazeProduce;

import mazeSolve.Array;
import mazeSolve.Queue;

public class RandomQueue<E> implements Queue<E> {
	private Array<E> array;
	public RandomQueue() {
		array = new Array<>();
	}
	@Override
	public void enqueue(E e) {
		array.add(e);
		
	}
	@Override
	public E dequeue() {
		if(array.getSize() == 0)
			throw new IllegalArgumentException("There's no element to remove in Random");
		int random = (int)(Math.random()*array.getSize());
		E e = array.get(random);
		array.set(random, array.getLast());
		array.removeLast();
		return e;
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
