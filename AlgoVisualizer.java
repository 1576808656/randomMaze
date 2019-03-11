package mazeProduce;
import java.awt.EventQueue;

import mazeSolve.Position;
import mazeSolve.Queue;

public class AlgoVisualizer {
	private static int blockSide = 5;
	private static final int d[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	private MazeData data;
	private AlgoFrame frame;
	private static int DELAY = 1;
	Queue<Position>queueR;
	Position cur = null;
	public AlgoVisualizer(int N,int M) {
		data = new MazeData(N,M);
		queueR = new ArrayQueue<>();
		int sceneWidth = data.getM()*blockSide;
		int sceneHeight = data.getN()*blockSide;
		
		//初始化视图
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("random maze",sceneWidth,sceneHeight);
			
			new Thread(() -> {
				run();
			}).start();
		});
	}
	
	public void run() {
	//	Stack<Position>stack = new ArrayStack<>();
		RandomQueue<Position> queue = new RandomQueue<>();
		Position p = new Position(data.getEntranceX(),data.getEntranceY()+1);
		queue.enqueue(p);
		data.visited[p.getX()][p.getY()] = true;
		
		while(queue.getSize() != 0) {
			Position position = queue.dequeue();
			for(int i=0;i<4;i++) {
				int newX = position.getX()+d[i][0]*2;
				int newY = position.getY()+d[i][1]*2;
				if(data.inArea(newX, newY) && !data.visited[newX][newY]) {
					queue.enqueue(new Position(newX,newY,position));
					data.visited[newX][newY] = true;
				//	road[newX][newY] = true;
					setData(position.getX()+d[i][0],position.getY()+d[i][1]);
				}
				
			}
		}
		searchRoad(data.getEntranceX(),data.getEntranceY());
		setData(-1,-1);
	}
	
	public void searchRoad(int x,int y) {
		Position p = new Position(x,y);
		queueR.enqueue(p);
	//	setData(x,y,true);
		int n = 0;
		int newX = 0;
		int newY = 0;
		while(queueR.getSize() != 0) {
			n = 0;
			Position position = queueR.dequeue();
			if(position.getX() == data.getExitX() && position.getY() == data.getExitY()) {
				cur = position;
			}
				
			for(int i=0;i<4;i++) {
				newX = position.getX()+d[i][0];
				newY = position.getY()+d[i][1];
				if(data.inArea(newX, newY) && !data.road[newX][newY] && data.maze[newX][newY] == ' ') {
					queueR.enqueue(new Position(newX,newY,position));
					data.road[newX][newY] = true;
					n++;
				}
			}
//			if(n == 0)
//				queueR.dequeue();
		}
		while(cur.getPrev() != null) {
			setData(cur.getX(),cur.getY(),true);
			cur = cur.getPrev();
		}
	}
	
	
//	private void go(int x,int y) {

		//递归生成迷宫算法
//		if(!data.inArea(x, y))
//			throw new IllegalArgumentException("x and y are out of index in go function");
//
//		data.visited[x][y] = true;
//		for(int i=0;i<4;i++) {
//			int newX = x+d[i][0]*2;
//			int newY = y+d[i][1]*2;
//			if(data.inArea(newX, newY) && !data.visited[newX][newY]) {
//				setData(x+d[i][0],y+d[i][1]);
//				go(newX,newY);
//			}
//				
//		}
//	}
	//有时会在数据变动之后才会渲染，因此把渲染代码放在方法里方便调用
	private void setData(int x,int y) {
		if(data.inArea(x, y))
			data.maze[x][y] = MazeData.ROAD;
		frame.render(data);
		AlgoVisHelper.pause(DELAY);
	}
	
	//路径渲染
	private void setData(int x,int y,boolean isPath) {
		if(data.inArea(x, y))
			data.rightRoad[x][y] = isPath;
		frame.render(data);
		AlgoVisHelper.pause(DELAY);
	}

	public static void main(String[] args) {
		AlgoVisualizer algo = new AlgoVisualizer(101,101);
	}
}
