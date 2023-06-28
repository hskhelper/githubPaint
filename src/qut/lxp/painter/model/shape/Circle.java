// 定义包名
package qut.lxp.painter.model.shape;

// 导入用于创建图形的类
import java.awt.Shape;
// 导入用于创建椭圆形（圆形）的类
import java.awt.geom.Ellipse2D;
// 导入用于表示二维点的类
import java.awt.geom.Point2D;

// 圆形类（继承图形抽象类）
		public class Circle extends MyShapeAbs {

			// 默认构造函数
			public Circle() {
				// 调用父类的构造函数
				super();
			}

			// 重写createShape方法，用于创建圆形
			@Override
			public Shape createShape() {
				// 创建一个二维点o，表示圆心
				Point2D o = new Point2D.Double(start.x, start.y);
				// 计算圆心与终点之间的距离，即为半径
				double r = o.distance(end);
				// 创建一个椭圆形（圆形），并返回
				// 参数分别表示：圆心横坐标减半径、圆心纵坐标减半径、直径、直径
				return new Ellipse2D.Double(o.getX() - r, o.getY() - r, 2 * r, 2 * r);
			}
		}