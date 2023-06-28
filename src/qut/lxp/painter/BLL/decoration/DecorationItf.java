package qut.lxp.painter.BLL.decoration;

import qut.lxp.painter.model.shape.MyShapeItf;

/**
 * 装饰器接口，用于定义图形装饰器的基本行为
 * 装饰器可以为图形对象添加额外的功能，如可变性、颜色、线条样式等
 */
public interface DecorationItf {
	/**
	 * 获取被装饰的图形对象的方法
	 * @return 被装饰的图形对象（MyShapeItf类型）
	 */
	public MyShapeItf getMyShape();

	/**
	 * 设置被装饰的图形对象的方法
	 * @param myShape - 需要被装饰的图形对象（MyShapeItf类型）
	 */
	public void setMyShape(MyShapeItf myShape);
}