// 定义包名
package qut.lxp.painter.model.shape;

// 导入用于创建图形的类
import java.awt.Shape;
// 导入用于创建线段的类
import java.awt.geom.Line2D;

// 导入自定义的判断策略类
import qut.lxp.painter.BLL.strategy.JudgerMyImpl;

// 线段类（继承图形抽象类）
public class Line extends MyShapeAbs {

	// 默认构造函数
	public Line() {
		// 调用父类的构造函数并传入自定义判断策略实例
		super(new JudgerMyImpl());
	}

	// 重写createShape方法，用于创建线段
	@Override
	public Shape createShape() {
		// 创建一个线段并返回
		// 参数分别表示：起始点的横坐标、起始点的纵坐标、终点的横坐标、终点的纵坐标
		return new Line2D.Float(start.x, start.y, end.x, end.y);
	}
}