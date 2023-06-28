// 引入所需的Java AWT包和Swing包
package qut.lxp.painter.BLL.pattern;

// 引入相关类
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import qut.lxp.painter.BLL.bridge.AppearanceImpl;
import qut.lxp.painter.BLL.bridge.AppearanceItf;
import qut.lxp.painter.model.shape.MyShapeItf;

// 定义PatternAbs抽象类
public abstract class PatternAbs {
	// 定义外观属性（桥接模式）
	protected AppearanceItf appearance = new AppearanceImpl();

	// 定义模式当前状态（true为可用，false为不可用）
	protected boolean state = false;

	// 定义鼠标点击事件标识符
	protected boolean tag = false;
	protected MouseAdapter mouseAdapter;
	protected MouseMotionAdapter mouseMotionAdapter;
	protected Point start, end; // 定义起点和终点
	protected MyShapeItf myShape; // 定义MyShapeItf接口实例

	// 定义画板
	protected JPanel board;

	// 定义设置模式状态的方法（true为可用，false为不可用）
	public void setState(boolean state) {
		this.state = state;
	}

	// 定义获取外观属性的方法
	public AppearanceItf getApperance() {
		return appearance;
	}

	// 定义设置外观属性的方法
	public void setAppearance(AppearanceItf appearance) {
		this.appearance = appearance;
	}

	// 定义获取MyShape实例的方法
	public MyShapeItf getMyShape() {
		return myShape;
	}

	// 定义一个抽象方法，用于应用外观属性
	public abstract void applyAppearance();
}