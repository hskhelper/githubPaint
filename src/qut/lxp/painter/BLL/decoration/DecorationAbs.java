package qut.lxp.painter.BLL.decoration;

import java.awt.Shape;

import qut.lxp.painter.model.shape.MyShapeAbs;
import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 抽象装饰器类，用于为MyShapeItf的实现类提供装饰功能
 * 继承自MyShapeAbs类并实现DecorationItf接口
 */
public abstract class DecorationAbs extends MyShapeAbs implements DecorationItf {

	// 定义一个MyShapeItf类型的成员变量，用于保存被装饰的图形对象
	protected MyShapeItf myShape;

	// 获取被装饰的图形对象的方法
	public MyShapeItf getMyShape() {
		return myShape;
	}

	// 设置被装饰的图形对象的方法
	public void setMyShape(MyShapeItf myShape) {
		this.myShape = myShape;
	}

	// 创建并返回与被装饰图形对象相同的Shape对象的方法，用于绘制图形
	public Shape createShape() {
		return myShape.createShape();
	}
}