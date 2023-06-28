package qut.lxp.painter.model.shape;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * 矩形（继承图形抽象类）
 */
public class Rectangle extends MyShapeAbs{

	// 默认构造函数
	public Rectangle() {
		super();
	}

	// 重写创建形状方法，返回一个矩形对象
	@Override
	public Shape createShape() {
		// 创建一个 Rectangle2D.Float 对象，计算矩形的坐标和宽高
		return new Rectangle2D.Float(Math.min(start.x, end.x), Math.min(start.y, end.y),
				Math.abs(start.x - end.x), Math.abs(start.y - end.y));
	}
}