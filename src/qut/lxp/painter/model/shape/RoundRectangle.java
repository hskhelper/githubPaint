package qut.lxp.painter.model.shape;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * 圆角矩形（继承图形抽象类）
 */
public class RoundRectangle extends MyShapeAbs {

	// 默认构造函数
	public RoundRectangle() {
		super();
	}

	// 重写创建形状方法，返回一个圆角矩形对象
	public Shape createShape() {
		// 创建一个 RoundRectangle2D.Float 对象，计算矩形的坐标、宽高以及圆角大小
		return new RoundRectangle2D.Float(Math.min(start.x, end.x), Math.min(start.y, end.y),
				Math.abs(start.x - end.x), Math.abs(start.y - end.y),
				45, 45);
	}
}