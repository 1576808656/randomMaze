package mazeProduce;

import mazeSolve.LinkedListQueue;
import mazeSolve.Position;
import mazeSolve.Queue;

public class SearchRoad {
	public MazeData road;
	public MazeData data;
	public Queue<Position>queue;
	public SearchRoad(int N,int M) {
		road = new MazeData(N,M);
		data = new MazeData(N,M);
		queue = new LinkedListQueue<>();
	}
	public void run(int x,int y) {
		queue.enqueue(new Position(x,y));
		
	}
}
