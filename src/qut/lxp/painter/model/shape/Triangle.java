package qut.lxp.painter.model.shape;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

/**
 * 三角形（继承图形抽象类）
 */
public class Triangle extends MyShapeAbs {

	// 默认构造函数
	public Triangle() {
		super();
	}

	// 重写创建形状方法，返回一个三角形对象
	@Override
	public Shape createShape() {
		// 创建一个 GeneralPath 对象，用于绘制三角形
		GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);

		// 绘制三角形的边，从起始点开始，沿顺时针方向连接其他顶点
		path.moveTo(start.x, start.y);
		path.lineTo(end.x, end.y);
		path.lineTo(start.x, end.y);
		path.lineTo(start.x, start.y);

		// 关闭路径以创建封闭的三角形
		path.closePath();

		// 返回创建的三角形对象
		return path;
	}
}