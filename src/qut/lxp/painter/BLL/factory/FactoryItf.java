package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 工厂接口，用于定义图形工厂类的通用行为
 * 工厂类用于创建具体的MyShapeItf实现类的对象，如Circle、Ellipse等
 */
public interface FactoryItf {
	/**
	 * 工厂方法，用于创建具体的MyShapeItf实现类的对象
	 * @return 新创建的MyShapeItf实现类的对象
	 */
	public MyShapeItf createProduct();
}