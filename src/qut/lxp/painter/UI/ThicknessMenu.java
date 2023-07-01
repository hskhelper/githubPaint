// 导入所需的包，该包位于pers.corvey.painter.ui命名空间
package qut.lxp.painter.UI;

// 导入所需的类
import java.awt.event.ActionEvent; // 导入ActionEvent类，用于处理菜单项点击事件
import java.awt.event.ActionListener; // 导入ActionListener类，用于监听菜单项点击事件
import java.util.HashMap; // 导入HashMap类，用于保存线条宽度和对应的菜单项
import javax.swing.JMenuItem; // 导入JMenuItem类，用于创建自定义菜单项
import javax.swing.JPanel; // 导入JPanel类，用于在构造函数中传递画板对象

// 导入所需的外观接口和图案类
import qut.lxp.painter.BLL.bridge.AppearanceItf;
import qut.lxp.painter.BLL.pattern.PatternAbs;

// 创建一个名为ThicknessMenu的类，继承自MyJMenu，表示自定义的线条宽度菜单
public class ThicknessMenu extends MyJMenu {

	// 定义一个静态的默认线条宽度值
	private final static float default_width = 2f;
	// 定义一个JPanel对象，表示画板
	private JPanel board;
	// 定义各种线条宽度菜单项
	private JMenuItem mi_thickness1 = new JMenuItem("极细");
	private JMenuItem mi_thickness2 = new JMenuItem("细");
	private JMenuItem mi_thickness3 = new JMenuItem("适中");
	private JMenuItem mi_thickness4 = new JMenuItem("粗");
	private JMenuItem mi_thickness5 = new JMenuItem("极粗");
	// 定义一个HashMap对象，用于保存线条宽度和对应的菜单项
	private HashMap<Float, JMenuItem> map = new HashMap<Float, JMenuItem>();

	// 创建一个带有JPanel参数的构造函数，用于初始化线条宽度菜单
	public ThicknessMenu(JPanel board) {
		super("线条宽度"); // 调用父类构造函数，传入菜单名称
		this.board = board; // 初始化画板对象
		// 为线条宽度2菜单项应用默认设置
		applySetting(mi_thickness2, default_width);

		// 为各种线条宽度菜单项添加监听器并将它们添加到线条宽度菜单中
		mi_thickness1.addActionListener(createActionListener(mi_thickness1, 2));
		add(mi_thickness1);

		mi_thickness2.addActionListener(createActionListener(mi_thickness2, 4));
		add(mi_thickness2);

		mi_thickness3.addActionListener(createActionListener(mi_thickness3, 6));
		add(mi_thickness3);

		mi_thickness4.addActionListener(createActionListener(mi_thickness4, 8));
		add(mi_thickness4);

		mi_thickness5.addActionListener(createActionListener(mi_thickness5, 12));
		add(mi_thickness5);
	}

	// 创建一个方法，用于生成对应的监听器
	public ActionListener createActionListener(JMenuItem item, float width) {
		map.put(width, item); // 将线条宽度和对应的菜单项添加到map中
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 应用菜单项对应的线条宽度设置
				applySetting(item, width);
			}
		};
	}

	// 创建一个方法，用于获取线条宽度和对应菜单项的映射关系
	public HashMap<Float, JMenuItem> getMap() {
		return map;
	}

	// 创建一个方法，用于应用菜单项对应的线条宽度设置
	public void applySetting(JMenuItem item, float width) {
		// 获取当前正在绘制的图案对象
		PatternAbs pattern = ((Board)board).getNowPattern();
		// 获取图案对象的外观接口
		AppearanceItf appearance = pattern.getApperance();
		if(appearance != null) {
			// 设置外观接口的线条宽度为当前选中的线条宽度
			appearance.setWidth(width);
			// 应用外观设置到图案对象
			pattern.applyAppearance();
			// 将当前选中的菜单项设置为活动状态
			setActiveItem(item);
		}
	}
}