package qut.lxp.painter.BLL.strategy;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * 判断器接口（抽象策略类）
 */
public interface JudgerItf {
	/**
	 * 判断鼠标点击位置是否位于图形范围内
	 * @param shape - 图形
	 * @param point - 鼠标点击位置
	 * @return 鼠标点击位置是否位于图形范围内
	 * 这个接口定义了一个名为judge的方法，接收两个参数
	 * Shape shape：表示要检测的图形。
	 * Point2D point：表示鼠标点击的位置。
	 * 这个方法返回一个布尔值，如果鼠标点击的位置在图形范围内，则返回true，否则返回false。
	 * 具体的实现类会根据不同的图形类型提供不同的判断方法，以实现策略模式。
	 */
	public boolean judge(Shape shape, Point2D point);
}