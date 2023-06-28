package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.Circle;
import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 圆形工厂类，用于创建Circle对象
 * 实现工厂接口FactoryItf
 */
public class CircleFactory implements FactoryItf {

	/**
	 * 根据工厂方法模式创建并返回一个新的Circle对象
	 * @return 新创建的Circle对象（实现了MyShapeItf接口）
	 */
	@Override
	public MyShapeItf createProduct() {
		return new Circle();
	}

}