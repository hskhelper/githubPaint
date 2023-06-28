package qut.lxp.painter.BLL.bridge;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 外观属性接口
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
	 * 获取粗细度
	 * @return 粗细度
	 */
	public float getWidth();

	/**
	 * 设置粗细度
	 * @param width - 粗细度
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