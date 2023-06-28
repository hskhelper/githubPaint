package qut.lxp.painter.BLL.bridge;
// 导入需要的类
import java.awt.AlphaComposite; // 提供创建透明度复合对象的类
import java.awt.BasicStroke; // 提供设置画笔线宽的类
import java.awt.Color; // 提供表示颜色的类
import java.awt.Graphics2D; // 提供2D绘图功能的类
import java.io.Serializable; // 提供序列化支持的接口

/**
 * 外观属性具体类
 * 在桥接模式中充当具体实现类的角色，实现外观属性接口并提供具体实现
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
		Color color = Color.decode("#8ECFC9"); // 将颜色字符串解码为 Color 对象
		setColor(color); // 设置颜色为 #8ECFC9
		setWidth(4); // 设置线宽为4
		setTransparency(0.6f); // 设置透明度为0.6
	}

	// 带参构造函数，为画笔设置指定的颜色、线宽和透明度
	public AppearanceImpl(Color color, float width, float transparency) {
		setColor(color); // 设置颜色
		setWidth(width); // 设置线宽
		setTransparency(transparency); // 设置透明度
	}

	// 克隆方法，用于复制一个外观属性对象
	public AppearanceItf clone() {
		try {
			return (AppearanceItf) super.clone(); // 调用父类的克隆方法创建一个外观属性对象的副本
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取画笔的透明度
	@Override
	public float getTransparency() {
		return transparency; // 返回透明度值
	}

	// 设置画笔的透明度
	@Override
	public void setTransparency(float transparency) {
		this.transparency = transparency; // 将传入的透明度值设置给属性
	}

	// 获取画笔的线宽
	@Override
	public float getWidth() {
		return width; // 返回线宽值
	}

	// 设置画笔的线宽
	@Override
	public void setWidth(float width) {
		this.width = width; // 将传入的线宽值设置给属性
	}

	// 获取画笔的颜色
	@Override
	public Color getColor() {
		return color; // 返回颜色值
	}

	// 设置画笔的颜色
	@Override
	public void setColor(Color color) {
		this.color = color; // 将传入的颜色值设置给属性
	}

	// 将外观属性应用于 Graphics2D 对象，以便在绘制图形时使用
	public void applyAppearance(Graphics2D g2) {
		g2.setPaint(getColor()); // 设置画笔颜色
		g2.setStroke(new BasicStroke(getWidth())); // 设置画笔线宽
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparency())); // 设置透明度
	}
}
