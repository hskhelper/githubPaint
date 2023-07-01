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
	private final Color default_color = Color.PINK;

	// 声明并初始化各种颜色的菜单项
	private JMenuItem lxp_red = new JMenuItem(" 红 ");
	private JMenuItem lxp_orange = new JMenuItem(" 橙 ");
	private JMenuItem lxp_yellow = new JMenuItem(" 黄 ");
	private JMenuItem lxp_green = new JMenuItem(" 绿 ");
	private JMenuItem lxp_qing = new JMenuItem(" 青 ");
	private JMenuItem lxp_blue = new JMenuItem(" 蓝 ");
	private JMenuItem lxp_pink = new JMenuItem(" 粉 ");

	// 声明一个存储颜色与菜单项映射关系的HashMap对象
	private HashMap<Color, JMenuItem> map = new HashMap<Color, JMenuItem>();

	// 定义ColorMenu构造器，接收一个画板对象作为参数
	public ColorMenu(JPanel board) {
		// 调用父类构造器，设置菜单名称为"颜色"
		super("颜色");
		// 将传入的画板对象赋值给当前类的board变量
		this.board = board;
		// 调用applySetting方法，设置默认颜色
		applySetting(lxp_pink, default_color);

		// 设置红色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_red.setBackground(Color.red);
		lxp_red.addActionListener(createActionListener(lxp_red, Color.red));
		add(lxp_red);

		// 设置橙色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_orange.setBackground(Color.orange);
		lxp_orange.addActionListener(createActionListener(lxp_orange, Color.orange));
		add(lxp_orange);

		// 设置黄色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_yellow.setBackground(Color.yellow);
		lxp_yellow.addActionListener(createActionListener(lxp_yellow, Color.yellow));
		add(lxp_yellow);

		// 设置绿色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_green.setBackground(Color.green);
		lxp_green.addActionListener(createActionListener(lxp_green, Color.green));
		add(lxp_green);

		// 设置青色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_qing.setBackground(Color.cyan);
		lxp_qing.addActionListener(createActionListener(lxp_qing, Color.cyan));
		add(lxp_qing);

		// 设置蓝色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_blue.setBackground(Color.blue);
		lxp_blue.addActionListener(createActionListener(lxp_blue, Color.blue));
		add(lxp_blue);

		// 设置粉色菜单项的背景色，并添加动作监听器，然后将其添加到菜单中
		lxp_pink.setBackground(Color.pink);
		lxp_pink.addActionListener(createActionListener(lxp_pink, Color.pink));
		add(lxp_pink);
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