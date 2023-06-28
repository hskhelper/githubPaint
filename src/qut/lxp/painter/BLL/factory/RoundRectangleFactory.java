package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.MyShapeItf;
import qut.lxp.painter.model.shape.RoundRectangle;

/**
 * 圆角矩形工厂类，用于创建RoundRectangle对象
 * 实现工厂接口FactoryItf
 */
public class RoundRectangleFactory implements FactoryItf {

	/**
	 * 根据工厂方法模式创建并返回一个新的RoundRectangle对象
	 * @return 新创建的RoundRectangle对象（实现了MyShapeItf接口）
	 */
	@Override
	public MyShapeItf createProduct() {
		return new RoundRectangle();
	}
}