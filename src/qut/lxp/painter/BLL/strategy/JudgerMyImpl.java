// 定义位于 pers.corvey.painter.BLL.strategy 包下的 JudgerMyImpl 类
package qut.lxp.painter.BLL.strategy;

// 导入 Shape 类，用于表示要检测的图形
import java.awt.Shape;
// 导入 Line2D 类，用于表示线段
import java.awt.geom.Line2D;
// 导入 Point2D 类，用于表示鼠标点击的位置
import java.awt.geom.Point2D;

/**
 * JudgerMyImpl 是一个具体策略类，实现了 JudgerItf 接口。
 * 它用于判断鼠标点击位置是否在线段附近。
 */
public class JudgerMyImpl implements JudgerItf {

	// 定义一个常量 distance，表示鼠标点击位置与线段的容许误差距离
	private final int distance = 3;

	// 实现 JudgerItf 接口中的 judge 方法
	@Override
	public boolean judge(Shape shape, Point2D point) {
		// 将传入的 Shape 对象强制转换为 Line2D 对象
		Line2D line = (Line2D) shape;

		// 判断线段的边界是否包含鼠标点击位置
		if (line.getBounds().contains(point)) {
			// 如果包含，计算鼠标点击位置到线段的距离
			// 如果距离小于 distance，表示鼠标点击位置在线段附近，返回 true
			return line.ptLineDist(point) < distance;
		} else {
			// 如果线段的边界不包含鼠标点击位置，直接返回 false，表示不在线段附近
			return false;
		}
	}
}