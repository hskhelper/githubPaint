package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.Ellipse;
import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 椭圆工厂类，用于创建Ellipse对象
 * 实现工厂接口FactoryItf
 */
public class EllipseFactory implements FactoryItf {

	/**
	 * 根据工厂方法模式创建并返回一个新的Ellipse对象
	 * @return 新创建的Ellipse对象（实现了MyShapeItf接口）
	 */
	@Override
	public MyShapeItf createProduct() {
		return new Ellipse();
	}

}