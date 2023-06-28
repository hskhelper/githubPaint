package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.Line;
import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 线段工厂类，用于创建Line对象
 * 实现工厂接口FactoryItf
 */
public class LineFactory implements FactoryItf{

	/**
	 * 根据工厂方法模式创建并返回一个新的Line对象
	 * @return 新创建的Line对象（实现了MyShapeItf接口）
	 */
	@Override
	public MyShapeItf createProduct() {
		return new Line();
	}
}