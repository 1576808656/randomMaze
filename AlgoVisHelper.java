package mazeProduce;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class AlgoVisHelper {
	private AlgoVisHelper() {}
	
	public static void setColor(Graphics2D g2d,Color color) {
		g2d.setColor(color);
	}
	
	//���ñʻ����
	public static void setStrokeWidth(Graphics2D g2d, int w) {
		int strokeWidth = w;
		g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}
	//���ƿ���Բ
	public static void strokeCircle(Graphics2D g2d,int x,int y,int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
		g2d.draw(circle);
	}
	//����ʵ��Բ
	public static void strokeFillCircle(Graphics2D g2d,int x,int y,int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
		g2d.fill(circle);
	}
	//���ƾ���
	public static void strokeRectangle(Graphics2D g2d,int x,int y,int w,int h) {
		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g2d.draw(rectangle);
	}
	
	public static void strokeFillRectangle(Graphics2D g2d,int x,int y,int w,int h) {
		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g2d.fill(rectangle);
	}
	
	//���η���ִ�м�����ٺ���
	public static void pause(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
