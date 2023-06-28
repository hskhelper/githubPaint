// 定义包名
package qut.lxp.painter.model.shape;

// 导入相关类
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;

import qut.lxp.painter.BLL.bridge.AppearanceItf;
import qut.lxp.painter.BLL.strategy.JudgerItf;
import qut.lxp.painter.BLL.strategy.JudgerSysImpl;

/**
 * 图形抽象类（实现图形接口）
 */
public abstract class MyShapeAbs implements MyShapeItf, Serializable {

	// 定义起始点和终点
	protected Point start = new Point();
	protected Point end = new Point();
	// 定义图形对象
	protected Shape myShape = null;
	// 定义外观接口
	protected AppearanceItf appearance;
	// 定义判断器接口
	protected JudgerItf judger;

	// 构造函数，接收判断器接口作为参数
	public MyShapeAbs(JudgerItf wayToJudge) {
		this.judger = wayToJudge;
	}

	// 默认构造函数
	public MyShapeAbs() {
		this(new JudgerSysImpl());
	}

	// 获取图形对象
	public Shape getShape() {
		return myShape == null ? createShape() : myShape;
	}

	// 设置图形对象
	public void setShape(Shape shape) {
		this.myShape = shape;
	}

	// 获取起始点
	public Point getStartPoint() {
		return start;
	}

	// 设置起始点
	public void setStartPoint(Point p) {
		start.setLocation(p);
	}

	// 获取终点
	public Point getEndPoint() {
		return end;
	}

	// 设置终点
	public void setEndPoint(Point p) {
		end.setLocation(p);
	}

	// 获取外观接口
	public AppearanceItf getAppearance() {
		return appearance;
	}

	// 设置外观接口
	public void setAppearance(AppearanceItf appearance) {
		this.appearance = appearance;
	}

	// 应用外观到图形
	public void applyAppearance(Graphics2D g2) {
		appearance.applyAppearance(g2);
	}

	// 获取判断器接口
	@Override
	public JudgerItf getJudger() {
		return judger;
	}

	// 设置判断器接口
	@Override
	public void setJudger(JudgerItf wayToJudge) {
		this.judger = wayToJudge;
	}
}