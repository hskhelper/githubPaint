package qut.lxp.painter.BLL.bridge;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 外观属性接口
 * 这个接口描述了外观属性的基本操作，
 * 包括获取和设置透明度、画笔宽度、颜色等，
 * 以及将外观属性应用到图形绘制中。
 * 它是桥接模式的一部分，
 * 将外观属性的操作与具体的实现分离，
 * 使得可以独立地修改和扩展外观属性的行为。
 * 其他类可以实现该接口来提供不同的外观属性实现，
 * 并通过接口方法来访问和操作这些属性。
 */
public interface AppearanceItf {

	/**
	 * 获取透明度
	 * @return 透明度
	 */
	public float getTransparency();

	/**
	 * 设置透明度
	 * @param transparency - 透明度
	 */
	public void setTransparency(float transparency);

	/**
	 * 获取画笔宽度
	 * @return 画笔宽度
	 */
	public float getWidth();

	/**
	 * 设置画笔宽度
	 * @param width - 画笔宽度
	 */
	public void setWidth(float width);

	// 获取颜色，表示画笔的颜色
	public Color getColor();

	// 设置颜色，设置画笔的颜色
	public void setColor(Color color);

	/**
	 * 将外观属性（颜色、粗细、透明度）附加到Graphics上
	 */
	public void applyAppearance(Graphics2D g2);

	// 克隆方法，用于复制一个外观属性对象
	public AppearanceItf clone();
}