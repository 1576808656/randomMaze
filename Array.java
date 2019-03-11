package mazeProduce;

public class Array<E> {
	private E[] data;
	private int size;
	
	/**
	 * 
	 * @param capacity   this is array length
	 */
	public Array(int capacity) {
		data = (E[])new Object[capacity];
		size = 0;
	}
	//无参数构造函数，默认容量为10
	public Array() {
		data = (E[])new Object[10];
		size = 0;
	}

	//返回数组是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	//向数组末尾添加新元素
	public void addLast(E e) {
		add(size,e);
	}

	public void addFirst(E e) {
		add(0,e);
	}
	
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Require index>=0 and index<=size");
		}
		if(getCapacity() == index)
			resize(getCapacity()*2);
		
		data[index] = e;
		size++;
	}
	/**
	 * 
	 * 
	 * @param e  this is element
	 */
	public void add(E e) {
		if(size == data.length-1) {
			resize(data.length*2);
			data[size] = e;
		}
		data[size] = e;
		size++;
		
	}
	
	public E get(int index) {
		if(index<0||index>size) {
			throw new IllegalArgumentException("Get failed. Require index>=0 and index<=size");
		}
		return data[index];
	}
	
	/**
	 * 
	 * @param index  this is set index
	 * @param e      this is set element
	 */
	public void set(int index,E e) {
		if(index<0||index>size) {
			throw new IllegalArgumentException("Set failed. Require index>=0 and index<=size");
		}
		data[index] = e;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size-1);
	}
	
	//删除所有指定元素
	public boolean removeAllElement(E e) {
		int number = 0;
		for(int i=0;i<size;i++) {
			if(data[i].equals(e)) {
				number++;
				remove(i);
			}
		}
		if(findAllElement(e) == number) {
			return true;
		}
		return false;
	}
	
	//查找指定元素的数量
	public int findAllElement(E e) {
		int number = 0;
		for(int i=0;i<size;i++) {
			if(contains(e)) {
				number++;
			}
		}
		return number;
	}
	
	public boolean removeElement(E e) {
		int index = find(e);
		if(index != -1) {
			remove(index);
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param e   query this element and return boolean
	 * @return
	 */
	public boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if(data[i] == e) {
				return true;
			}
		}
		return false;
	}
	
	public int find(E e) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public int getSize() {
		return size;
	}
	
	public int size() {
		return size;
	}
	
	private void resize(int newCapacity) {
		E[] datas = (E[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			datas[i] = data[i];
		}
		data = datas;
	}
	
	public E remove(int index) {
		E e = data[index];
		for(int i=index;i<size-1;i++) {
			data[i] = data[i+1];
		}
		size--;
		data[size] = null;
		if(size == data.length/4) {
			resize(data.length/2);
		}
		return e;
	}
	
	E getFirst() {
		return get(0);
	}
	
	E getLast() {
		return get(size-1);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String .format("Array:size = %d,capacity = %d\n", size,data.length));
		res.append("[");
		for(int i=0;i<size;i++) {
			res.append(data[i]);
			if(i!=size-1) {
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
	}
}
