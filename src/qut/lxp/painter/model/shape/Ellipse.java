// 定义包名
package qut.lxp.painter.model.shape;

// 导入用于创建图形的类
import java.awt.Shape;
// 导入用于创建椭圆形的类
import java.awt.geom.Ellipse2D;

// 椭圆类（继承图形抽象类）
public class Ellipse extends MyShapeAbs {

	// 默认构造函数
	public Ellipse() {
		// 调用父类的构造函数
		super();
	}

	// 重写createShape方法，用于创建椭圆形
	@Override
	public Shape createShape() {
		// 创建一个椭圆形并返回
		// 参数分别表示：起始点和终点的横坐标中较小值、起始点和终点的纵坐标中较小值
		// 横向距离的绝对值、纵向距离的绝对值
		return new Ellipse2D.Float(Math.min(start.x, end.x), Math.min(start.y, end.y),
				Math.abs(end.x-start.x), Math.abs(end.y-start.y));
	}
}