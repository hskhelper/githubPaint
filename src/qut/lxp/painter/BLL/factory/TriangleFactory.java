package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.MyShapeItf;
import qut.lxp.painter.model.shape.Triangle;

/**
 * 三角形工厂类，用于创建Triangle对象
 * 实现工厂接口FactoryItf
 */
public class TriangleFactory implements FactoryItf {

	/**
	 * 根据工厂方法模式创建并返回一个新的Triangle对象
	 * @return 新创建的Triangle对象（实现了MyShapeItf接口）
	 */
	@Override
	public MyShapeItf createProduct() {
		return new Triangle();
	}

}