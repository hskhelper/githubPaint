// 定义包名，将类归属于项目的逻辑层装饰器包```java
package qut.lxp.painter.BLL.decoration;

// 导入java.awt.Point类，用于表示图形的坐标点
import java.awt.Point;
// 导入java.awt.geom.Point2D类，用于计算两点之间的距离
import java.awt.geom.Point2D;

// 导入pers.corvey.painter.model.shape.MyShapeItf接口，用于定义图形对象的行为
import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 赋予图形可变性的装饰器，使得图形可以放大缩小和移动
 */
public class ChangeableDecoration extends DecorationAbs implements ChangeableItf {

	// 定义每次放大或缩小时的变化程度，用于控制图形变化的速度
	private final double changeDegree = 10;

	// 定义每次放大或缩小时横坐标的变化值，用于计算放大或缩小后的坐标
	private int deltaX;

	// 定义每次放大或缩小时纵坐标的变化值，用于计算放大或缩小后的坐标
	private int deltaY;

	// 默认构造函数，初始化ChangeableDecoration对象
	public ChangeableDecoration() {}

	// 带参数构造函数，接收一个MyShapeItf对象并设置为被装饰的图形
	public ChangeableDecoration(MyShapeItf myShape) {
		setMyShape(myShape);
	}

	// 重写setMyShape方法，为被装饰的图形赋值并计算delta值
	@Override
	public void setMyShape(MyShapeItf myShape) {
		super.setMyShape(myShape);
		if (myShape != null)
			computeDelta();
	}

	// 放大图形，根据delta值调整图形的大小
	@Override
	public void zoomIn() {
		Point start = myShape.getStartPoint();
		Point end = myShape.getEndPoint();
		start.move(start.x + deltaX, start.y + deltaY);
		end.move(end.x - deltaX, end.y - deltaY);
		myShape.setShape(myShape.createShape());
	}

	// 缩小图形，根据delta值调整图形的大小
	@Override
	public void zoomOut() {
		Point start = myShape.getStartPoint();
		Point end = myShape.getEndPoint();
		double d = new Point2D.Double(end.x, end.y).distance(start.x, start.y);
		if (d < 50)
			return;
		start.move(start.x - deltaX, start.y - deltaY);
		end.move(end.x + deltaX, end.y + deltaY);
		myShape.setShape(myShape.createShape());
	}

	// 移动图形，根据鼠标的移动调整图形的位置
	@Override
	public void move(Point from, Point to) {
		int dx = to.x - from.x;
		int dy = to.y - from.y;
		Point start = myShape.getStartPoint();
		Point end = myShape.getEndPoint();
		start.move(start.x + dx, start.y + dy);
		end.move(end.x + dx, end.y + dy);
		myShape.setShape(myShape.createShape());
	}

	// 计算图形放大缩小时横纵坐标的变化值，用于在放大缩小操作中调整坐标
	public void computeDelta() {
		double x1 = myShape.getStartPoint().x, y1 = myShape.getStartPoint().y;
		double x2 = myShape.getEndPoint().x, y2 = myShape.getEndPoint().y;
		double d = new Point2D.Double(x2, y2).distance(x1, y1);
		double cos = (x2 - x1) / d;
		double tan = (y2 - y1) / (x2 - x1);
		deltaX = (int) (Math.abs(changeDegree * cos) + 0.5);
		deltaY = (int) (Math.abs(deltaX * tan) + 0.5);
		if (x1 < x2 && y1 > y2) {    // 右上方
			deltaX = 0 - deltaX;

		} else if (x1 > x2 && y1 < y2) {    // 左下方
			deltaY = 0 - deltaY;

		} else if (x1 < x2 && y1 < y2) {    // 右下方
			deltaX = 0 - deltaX;
			deltaY = 0 - deltaY;
		}
	}
}