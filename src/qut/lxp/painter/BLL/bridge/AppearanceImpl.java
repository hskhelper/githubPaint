package qut.lxp.painter.BLL.bridge;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 * 外观属性具体类
 */
public class AppearanceImpl implements AppearanceItf, Serializable, Cloneable {

	// 定义颜色属性，表示画笔的颜色
	private Color color;
	// 定义线宽属性，表示画笔的粗细
	private float width;
	// 定义透明度属性，表示画笔的透明度
	private float transparency;

	// 默认构造函数，为画笔设置默认的颜色、线宽和透明度
	public AppearanceImpl() {
		setColor(Color.black);
		setWidth(2);
		setTransparency(0.6f);
	}

	// 带参数的构造函数，为画笔设置指定的颜色、线宽和透明度
	public AppearanceImpl(Color color, float width, float transparency) {
		setColor(color);
		setWidth(width);
		setTransparency(transparency);
	}

	// 克隆方法，用于复制一个外观属性对象
	public AppearanceItf clone() {
		try {
			return (AppearanceItf) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取画笔的透明度
	@Override
	public float getTransparency() {
		return transparency;
	}

	// 设置画笔的透明度
	@Override
	public void setTransparency(float transparency) {
		this.transparency = transparency;
	}

	// 获取画笔的线宽
	@Override
	public float getWidth() {
		return width;
	}

	// 设置画笔的线宽
	@Override
	public void setWidth(float width) {
		this.width = width;
	}

	// 获取画笔的颜色
	@Override
	public Color getColor() {
		return color;
	}

	// 设置画笔的颜色
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	// 将外观属性应用于 Graphics2D 对象，以便在绘制图形时使用
	public void applyAppearance(Graphics2D g2) {
		// 设置画笔颜色
		g2.setPaint(getColor());
		// 设置画笔线宽
		g2.setStroke(new BasicStroke(getWidth()));
		// 设置透明度
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparency()));
	}
}