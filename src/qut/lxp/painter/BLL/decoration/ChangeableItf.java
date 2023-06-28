package qut.lxp.painter.BLL.decoration;

import java.awt.Point;

/**
 * 可变性的接口，用于定义图形变换的操作，例如放大、缩小和移动图形
 */
public interface ChangeableItf {

	/**
	 * 放大图形的方法，用于增加图形的尺寸
	 */
	void zoomIn();

	/**
	 * 缩小图形的方法，用于减小图形的尺寸
	 */
	void zoomOut();

	/**
	 * 根据鼠标的位移移动图形的方法，用于改变图形在画布上的位置
	 * @param from - 鼠标起始位置，用于指示图形移动的起点
	 * @param to - 鼠标终止位置，用于指示图形移动的终点
	 */
	void move(Point from, Point to);
}