package qut.lxp.painter.BLL.factory;

import qut.lxp.painter.model.shape.MyShapeItf;
import qut.lxp.painter.model.shape.Rhombus;

/**
 * 菱形工厂类，用于创建Rhombus对象
 * 实现工厂接口FactoryItf
 */
public class RhombusFactory implements FactoryItf {

	/**
	 * 根据工厂方法模式创建并返回一个新的Rhombus对象
	 * @return 新创建的Rhombus对象（实现了MyShapeItf接口）
	 */
	@Override
	public MyShapeItf createProduct() {
		return new Rhombus();
	}
}