// 引入所需的Java AWT包和Swing包
package qut.lxp.painter.BLL.pattern;

// 引入相关类
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;

// 引入装饰器接口、可变装饰器类和其他相关类
import qut.lxp.painter.BLL.decoration.ChangeableDecoration;
import qut.lxp.painter.BLL.decoration.ChangeableItf;
import qut.lxp.painter.BLL.decoration.DecorationItf;
import qut.lxp.painter.model.shape.MyShapeItf;
import qut.lxp.painter.UI.AppearanceMenu;
import qut.lxp.painter.UI.Board;

// 定义Chooser类，继承自PatternAbs抽象类
public class Chooser extends PatternAbs {

	private DecorationItf decoration = new ChangeableDecoration(); // 定义装饰器实例
	private MouseWheelListener mouseWheelListener; // 定义鼠标滚轮监听器实例
	private KeyAdapter keyAdapter; // 定义键盘适配器实例

	// 定义构造方法，接收画布并设置相关事件处理器
	public Chooser(JPanel board) {
		super(); // 调用父类构造方法
		this.board = board; // 设置画布
		mouseAdapter = new MouseAdapter() { // 定义鼠标适配器实例
			@Override
			public void mousePressed(MouseEvent e) { // 处理鼠标按下事件
				if(state) {
					Point2D point = new Point2D.Double(e.getX(), e.getY()); // 获取鼠标位置
					start = new Point(e.getX(), e.getY()); // 设置起点
					end = new Point(start); // 设置终点
					choose(point); // 尝试选择图形
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) { // 处理鼠标释放事件
				if(state && tag) {
					tag = false; // 设置标志为false
					board.repaint(); // 重绘画布
					start = end = null; // 重置起点和终点
				}
			}
		};
		board.addMouseListener(mouseAdapter); // 为画布添加鼠标监听器

		mouseMotionAdapter = new MouseMotionAdapter() { // 定义鼠标移动适配器实例
			@Override
			public void mouseDragged(MouseEvent e) { // 处理鼠标拖拽事件
				if(state && tag && myShape != null) {
					end.setLocation(e.getX(), e.getY()); // 更新终点位置
					((ChangeableItf)decoration).move(start, end); // 移动选中的图形
					board.repaint(); // 重绘画布
					start.setLocation(end); // 更新起点位置
				}
			}
		};
		board.addMouseMotionListener(mouseMotionAdapter); // 为画布添加鼠标移动监听器

		mouseWheelListener = new MouseWheelListener() { // 定义鼠标滚轮监听器实例
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) { // 处理鼠标滚轮滚动事件
				if(state && myShape != null) {
					if(e.getWheelRotation() == -1) // 如果滚轮向上滚动
						((ChangeableItf)decoration).zoomIn(); // 放大图形
					else if (e.getWheelRotation() == 1) // 如果滚轮向下滚动
						((ChangeableItf)decoration).zoomOut(); // 缩小图形
					board.repaint(); // 重绘画布
				}
			}
		};
		board.addMouseWheelListener(mouseWheelListener); // 为画布添加鼠标滚轮监听器

		keyAdapter = new KeyAdapter() { // 定义键盘适配器实例
			public void keyPressed(KeyEvent e) { // 处理键盘按键事件
				if(state && e.getKeyCode() == KeyEvent.VK_DELETE) { // 如果状态为true且按下删除键
					((Board)board).getArrayList().remove(myShape); // 从画布中移除选中的图形
					board.repaint(); // 重绘画布
				}
			}
		};
		board.addKeyListener(keyAdapter); // 为画布添加键盘监听器
	}

	/**
	 * 根据鼠标位置尝试去选中图形
	 * @param point - 鼠标位置
	 */
	public void choose(Point2D point) {
		myShape = null; // 初始化选中的图形
		appearance = null; // 初始化外观属性
		decoration.setMyShape(null); // 设置装饰器的图形为空
		ArrayList<MyShapeItf> shapes = ((Board)board).getArrayList(); // 获取画布中的图形列表
		for(int i=shapes.size()-1; i>=0; --i) { // 从后往前遍历图形列表
			MyShapeItf item = shapes.get(i); // 获取当前图形实例
			if(item.getJudger().judge(item.getShape(), point)) { // 判断鼠标位置是否在当前图形内
				myShape = item; // 设置选中的图形为当前图形
				appearance = item.getAppearance(); // 设置外观属性为当前图形的外观属性
				AppearanceMenu.activeItemByAppearance(appearance); // 激活外观菜单项
				decoration.setMyShape(item); // 设置装饰器的图形为当前图形
				tag = true; // 设置标志为true
				break; // 结束循环
			}
		}
	}

	/**
	 * 修改被选中图形的外观属性
	 */
	@Override
	public void applyAppearance() {
		if(myShape != null) { // 如果选中了图形
			myShape.setAppearance(appearance.clone()); // 更新选中图形的外观属性
			board.repaint(); // 重绘画布
		}
	}
}