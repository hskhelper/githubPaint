// 引入所需的Java AWT包和Swing包
package qut.lxp.painter.BLL.pattern;

// 引入相关类
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

// 引入工厂接口和具体工厂类
import qut.lxp.painter.BLL.factory.FactoryItf;
import qut.lxp.painter.BLL.factory.LineFactory;
import qut.lxp.painter.UI.Board;

// 定义Painter类，继承自PatternAbs抽象类
public class Painter extends PatternAbs {

	private FactoryItf factory; // 定义一个工厂接口实例

	// 定义构造方法，接收画布并设置相关事件处理器
	public Painter(JPanel board) {
		super(); // 调用父类构造方法
		this.board = board; // 设置画布
		setFactory(new LineFactory()); // 设置工厂实例
		mouseAdapter = new MouseAdapter() { // 定义鼠标适配器实例
			@Override
			public void mousePressed(MouseEvent e) { // 处理鼠标按下事件
				if(state) { // 判断当前模式状态是否可用
					myShape = getFactory().createProduct(); // 创建图形实例
					applyAppearance(); // 应用外观属性
					start = new Point(e.getX(), e.getY()); // 设置起点
					end = new Point(start); // 设置终点
					myShape.setStartPoint(start); // 更新图形起点
					myShape.setEndPoint(end); // 更新图形终点
					tag = true; // 设置标志为true
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) { // 处理鼠标释放事件
				if(state && tag) { // 判断当前模式状态是否可用且标志为true
					((Board)board).getArrayList().add(myShape); // 将图形添加到画布的图形列表中
					tag = false; // 设置标志为false
					board.repaint(); // 重绘画布
					myShape = null; // 重置图形实例
					start = end = null; // 重置起点和终点
				}
			}
		};
		board.addMouseListener(mouseAdapter); // 为画布添加鼠标监听器

		mouseMotionAdapter = new MouseMotionAdapter() { // 定义鼠标移动适配器实例
			@Override
			public void mouseDragged(MouseEvent e) { // 处理鼠标拖拽事件
				if(state && tag) { // 判断当前模式状态是否可用且标志为true
					end.setLocation(e.getX(), e.getY()); // 更新终点位置
					myShape.setEndPoint(end); // 更新图形终点
					board.repaint(); // 重绘画布
				}
			}
		};
		board.addMouseMotionListener(mouseMotionAdapter); // 为画布添加鼠标移动监听器
	}

	// 定义获取工厂实例的方法
	public FactoryItf getFactory() {
		return factory;
	}

	// 定义设置工厂实例的方法
	public void setFactory(FactoryItf factory) {
		this.factory = factory;
	}

	// 定义应用外观属性的方法，将画笔当前的外观属性克隆一份新的并赋给刚刚画的图形
	@Override
	public void applyAppearance() {
		if(myShape != null) // 如果图形实例不为空，则克隆外观属性并设置给图形
			myShape.setAppearance(getApperance().clone());
	}
}