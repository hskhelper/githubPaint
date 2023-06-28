package qut.lxp.painter.model.shape;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

/**
 * 菱形（继承图形抽象类）
 */
public class Rhombus extends MyShapeAbs {

	// 默认构造函数
	public Rhombus() {
		super();
	}

	// 重写创建形状方法，返回一个菱形对象
	@Override
	public Shape createShape() {
		// 计算菱形的中心点的横坐标和纵坐标
		float wMid = Math.min(start.x, end.x) + Math.abs(end.x - start.x) / 2;
		float hMid = Math.min(start.y, end.y) + Math.abs(end.y - start.y) / 2;

		// 创建一个 GeneralPath 对象，用于绘制菱形
		GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);

		// 绘制菱形的边，从上顶点开始，沿顺时针方向连接其他顶点
		path.moveTo(wMid, start.y);
		path.lineTo(end.x, hMid);
		path.lineTo(wMid, end.y);
		path.lineTo(start.x, hMid);
		path.lineTo(wMid, start.y);
		// 关闭路径以创建封闭的菱形
		path.closePath();

		// 返回创建的菱形对象
		return path;
	}
}