package qut.lxp.painter.UI; // 定义包名
// 导入java.awt.Color类，用于表示颜色
import java.awt.Color;

// 导入java.awt.event.ActionEvent类，用于处理动作事件
import java.awt.event.ActionEvent;

// 导入java.awt.event.ActionListener接口，用于响应动作事件
import java.awt.event.ActionListener;

// 导入java.util.HashMap类，用于存储颜色与菜单项的映射关系
import java.util.HashMap;

// 导入javax.swing.JMenuItem类，用于表示菜单项
import javax.swing.JMenuItem;

// 导入javax.swing.JPanel类，用于表示画板
import javax.swing.JPanel;

// 导入自定义的AppearanceItf接口，用于处理颜色等外观设置
import qut.lxp.painter.BLL.bridge.AppearanceItf;

// 导入自定义的PatternAbs抽象类，用于处理绘制模式
import qut.lxp.painter.BLL.pattern.PatternAbs;

// 定义一个继承自MyJMenu的颜色菜单类
public class ColorMenu extends MyJMenu {

	// 声明一个画板对象
	private JPanel board;

	// 声明一个默认颜色常量，设置为黑色
	private final Color default_color = Color.black;

	// 声明并初始化各种颜色的菜单项
	private JMenuItem mi_red = new JMenuItem(" 红 ");
	private JMenuItem mi_yellow = new JMenuItem(" 黄 ");
	private JMenuItem mi_blue = new JMenuItem(" 蓝 ");
	private JMenuItem mi_green = new JMenuItem(" 绿 ");
	private JMenuItem mi_cyan = new JMenuItem(" 青 ");
	private JMenuItem mi_orange = new JMenuItem(" 橙 ");
	private JMenuItem mi_black = new JMenuItem(" 黑 ");

	// 声明一个存储颜色与菜单项映射关系的HashMap对象
	private HashMap<Color, JMenuItem> map = new HashMap<Color, JMenuItem>();

	// 定义ColorMenu构造器，接收一个画板对象作为参数
	public ColorMenu(JPanel board) {
		// 调用父类构造器，设置菜单名称为"颜色"
		super("颜色");
		// 将传入的画板对象赋值给当前类的board变量
		this.board = board;
		// 调用applySetting方法，设置默认颜色
		applySetting(mi_black, default_color);

		// 设置红色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_red.setBackground(Color.red);
		mi_red.addActionListener(createActionListener(mi_red, Color.red));
		add(mi_red);

		// 设置黄色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_yellow.setBackground(Color.yellow);
		mi_yellow.addActionListener(createActionListener(mi_yellow, Color.yellow));
		add(mi_yellow);

		// 设置蓝色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_blue.setBackground(Color.blue);
		mi_blue.addActionListener(createActionListener(mi_blue, Color.blue));
		add(mi_blue);

		// 设置绿色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_green.setBackground(Color.green);
		mi_green.addActionListener(createActionListener(mi_green, Color.green));
		add(mi_green);

		// 设置青色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_cyan.setBackground(Color.cyan);
		mi_cyan.addActionListener(createActionListener(mi_cyan, Color.cyan));
		add(mi_cyan);

		// 设置橙色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_orange.setBackground(Color.orange);
		mi_orange.addActionListener(createActionListener(mi_orange, Color.orange));
		add(mi_orange);

		// 设置黑色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		mi_black.setBackground(Color.black);
		mi_black.addActionListener(createActionListener(mi_black, Color.black));
		add(mi_black);
	}

	// 定义一个方法，用于生成指定颜色的动作监听器
	public ActionListener createActionListener(JMenuItem item, Color color) {
		// 将颜色与菜单项的映射关系存储到map中
		map.put(color, item);
		// 返回一个新的动作监听器实例
		return new ActionListener() {
			// 重写actionPerformed方法，用于处理菜单项的点击事件
			public void actionPerformed(ActionEvent e) {
				// 调用applySetting方法，设置选中的颜色
				applySetting(item, color);
			}
		};
	}

	// 定义一个方法，用于应用指定的颜色设置
	public void applySetting(JMenuItem item, Color color) {
		// 获取当前绘制模式
		PatternAbs pattern = ((Board)board).getNowPattern();
		// 获取当前外观设置
		AppearanceItf appearance = pattern.getApperance();
		// 如果外观设置不为空
		if(appearance != null) {
			// 设置颜色
			appearance.setColor(color);
			// 应用外观设置
			pattern.applyAppearance();
			// 设置活动菜单项
			setActiveItem(item);
		}
	}

	// 定义一个方法，用于获取颜色与菜单项的映射关系
	public HashMap<Color, JMenuItem> getMap() {
		return map;
	}
}