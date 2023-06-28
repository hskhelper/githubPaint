// 导入所需的包，该包位于pers.corvey.painter.ui命名空间
package qut.lxp.painter.UI;

// 导入所需的类
import java.awt.event.ActionEvent; // 导入ActionEvent类，用于处理菜单项点击事件
import java.awt.event.ActionListener; // 导入ActionListener类，用于监听菜单项点击事件
import java.util.HashMap; // 导入HashMap类，用于保存透明度和对应的菜单项
import javax.swing.JMenuItem; // 导入JMenuItem类，用于创建自定义菜单项
import javax.swing.JPanel; // 导入JPanel类，用于在构造函数中传递画板对象

// 导入所需的外观接口和图案类
import qut.lxp.painter.BLL.bridge.AppearanceItf;
import qut.lxp.painter.BLL.pattern.PatternAbs;

// 创建一个名为TransparencyMenu的类，继承自MyJMenu，表示自定义的透明度菜单
public class TransparencyMenu extends MyJMenu {

	// 定义一个静态的默认透明度值
	private final static float default_transparency = 0.6f;
	// 定义一个JPanel对象，表示画板
	private JPanel board;
	// 定义各种透明度菜单项
	private JMenuItem mi_transparency10 = new JMenuItem("透明度：100%");
	private JMenuItem mi_transparency8 = new JMenuItem("透明度：80%");
	private JMenuItem mi_transparency6 = new JMenuItem("透明度：60%");
	private JMenuItem mi_transparency4 = new JMenuItem("透明度：40%");
	private JMenuItem mi_transparency2 = new JMenuItem("透明度：20%");
	// 定义一个HashMap对象，用于保存透明度和对应的菜单项
	private HashMap<Float, JMenuItem> map = new HashMap<Float, JMenuItem>();

	// 创建一个带有JPanel参数的构造函数，用于初始化透明度菜单
	public TransparencyMenu(JPanel board) {
		super("透明度"); // 调用父类构造函数，传入菜单名称
		this.board = board; // 初始化画板对象
		// 为透明度60%菜单项应用默认设置
		applySetting(mi_transparency6, default_transparency);

		// 为各种透明度菜单项添加监听器并将它们添加到透明度菜单中
		mi_transparency10.addActionListener(createActionListener(mi_transparency10, 1));
		add(mi_transparency10);

		mi_transparency8.addActionListener(createActionListener(mi_transparency8, 0.8f));
		add(mi_transparency8);

		mi_transparency6.addActionListener(createActionListener(mi_transparency6, 0.6f));
		add(mi_transparency6);

		mi_transparency4.addActionListener(createActionListener(mi_transparency4, 0.4f));
		add(mi_transparency4);

		mi_transparency2.addActionListener(createActionListener(mi_transparency2, 0.2f));
		add(mi_transparency2);
	}

	// 创建一个方法，用于生成对应的监听器
	public ActionListener createActionListener(JMenuItem item, float transparency) {
		map.put(transparency, item); // 将透明度和对应的菜单项添加到map中
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 应用菜单项对应的透明度设置
				applySetting(item, transparency);
			}
		};
	}

	// 创建一个方法，用于获取透明度和对应菜单项的映射关系
	public HashMap<Float, JMenuItem> getMap() {
		return map;
	}

	// 创建一个方法，用于应用菜单项对应的透明度设置
	public void applySetting(JMenuItem item, float transparency) {
		// 获取当前正在绘制的图案对象
		PatternAbs pattern = ((Board)board).getNowPattern();
		// 获取图案对象的外观接口
		AppearanceItf appearance = pattern.getApperance();
		if(appearance != null) {
			// 设置外观接口的透明度为当前选中的透明度
			appearance.setTransparency(transparency);
			// 应用显示外观设置到图案对象
			pattern.applyAppearance();
			// 将当前菜单项设置为活动状态
			setActiveItem(item);
		}
	}
}