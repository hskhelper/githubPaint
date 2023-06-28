// 导入所需的包，该包位于pers.corvey.painter.ui命名空间
package qut.lxp.painter.UI;

// 导入所需的类
import java.awt.event.ActionEvent; // 导入ActionEvent类，用于处理菜单项点击事件
import java.awt.event.ActionListener; // 导入ActionListener类，用于监听菜单项点击事件
import javax.swing.JMenuItem; // 导入JMenuItem类，用于创建自定义菜单项
import javax.swing.JPanel; // 导入JPanel类，用于在构造函数中传递画板对象

// 导入所需的图形工厂类
import qut.lxp.painter.BLL.factory.CircleFactory;
import qut.lxp.painter.BLL.factory.EllipseFactory;
import qut.lxp.painter.BLL.factory.FactoryItf;
import qut.lxp.painter.BLL.factory.LineFactory;
import qut.lxp.painter.BLL.factory.RectangleFactory;
import qut.lxp.painter.BLL.factory.RhombusFactory;
import qut.lxp.painter.BLL.factory.RoundRectangleFactory;
import qut.lxp.painter.BLL.factory.TriangleFactory;

// 创建一个名为ShapeMenu的类，继承自MyJMenu，表示自定义的图形菜单
public class ShapeMenu extends MyJMenu {

	// 定义一个静态的默认图形工厂对象，用于初始化画板的图形工厂
	private final static FactoryItf default_factory = new LineFactory();
	// 定义一个JPanel对象，表示画板
	private JPanel board;
	// 定义各种图形菜单项
	private JMenuItem mi_line = new JMenuItem("线段");
	private JMenuItem mi_triangle = new JMenuItem("三角形");
	private JMenuItem mi_rectangle = new JMenuItem("矩形");
	private JMenuItem mi_roundRectangle = new JMenuItem("圆角矩形");
	private JMenuItem mi_rhombus = new JMenuItem("菱形");
	private JMenuItem mi_circle = new JMenuItem("圆形");
	private JMenuItem mi_ellipse = new JMenuItem("椭圆");

	// 创建一个带有JPanel参数的构造函数，用于初始化图形菜单
	public ShapeMenu(JPanel board) {
		super("图形"); // 调用父类构造函数，传入菜单名称
		this.board = board; // 初始化画板对象
		// 为线段菜单项应用默认设置
		applySetting(mi_line, default_factory);

		// 为各种图形菜单项添加监听器并将它们添加到图形菜单中
		mi_line.addActionListener(createActionListener(mi_line, new LineFactory()));
		add(mi_line);

		mi_triangle.addActionListener(createActionListener(mi_triangle, new TriangleFactory()));
		add(mi_triangle);

		mi_rectangle.addActionListener(createActionListener(mi_rectangle, new RectangleFactory()));
		add(mi_rectangle);

		mi_roundRectangle.addActionListener(createActionListener(mi_roundRectangle,
				new RoundRectangleFactory()));
		add(mi_roundRectangle);

		mi_rhombus.addActionListener(createActionListener(mi_rhombus, new RhombusFactory()));
		add(mi_rhombus);

		mi_circle.addActionListener(createActionListener(mi_circle, new CircleFactory()));
		add(mi_circle);

		mi_ellipse.addActionListener(createActionListener(mi_ellipse, new EllipseFactory()));
		add(mi_ellipse);
	}

	// 创建一个方法，用于生成对应的监听器
	public ActionListener createActionListener(JMenuItem item, FactoryItf factory) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 应用菜单项对应的图形设置
				applySetting(item, factory);
			}
		};
	}

	// 创建一个方法，用于应用菜单项对应的图形设置
	public void applySetting(JMenuItem item, FactoryItf factory) {
		// 设置画板的图形工厂为当前选中的图形工厂
		((Board)board).getPainter().setFactory(factory);
		// 将当前选中的图形菜单项设置为传入的菜单项
		setActiveItem(item);
	}
}