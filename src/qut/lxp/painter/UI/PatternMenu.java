// 导入所需的包，该包位于pers.corvey.painter.ui命名空间
package qut.lxp.painter.UI;

// 导入所需的类
import java.awt.event.ActionEvent; // 导入ActionEvent类，用于处理菜单项点击事件
import java.awt.event.ActionListener; // 导入ActionListener类，用于监听菜单项点击事件
import javax.swing.JMenuItem; // 导入JMenuItem类，用于创建自定义菜单项
import javax.swing.JPanel; // 导入JPanel类，用于在构造函数中传递画板对象

// 创建一个名为PatternMenu的类，继承自MyJMenu，表示自定义的模式菜单
public class PatternMenu extends MyJMenu {

	// 定义两个JMenuItem对象，分别表示画图和选择模式的菜单项
	private JMenuItem mi_paint = new JMenuItem("画图");
	private JMenuItem mi_choose = new JMenuItem("选择");

	// 创建一个带有JPanel参数的构造函数，用于初始化模式菜单
	public PatternMenu(JPanel board) {
		super("模式"); // 调用父类构造函数，传入菜单名称

		// 使画板处于画图模式并设置画图模式菜单项为选中状态
		((Board)board).ActivePainter();
		setActiveItem(mi_paint);

		// 为画图模式菜单项添加点击事件处理
		mi_paint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 使画板处于画图模式
				((Board)board).ActivePainter();
				// 更新外观菜单的选中项以匹配画板的当前外观
				AppearanceMenu.activeItemByAppearance(((Board)board).getPainter().getApperance());
				// 设置画图模式菜单项为选中状态
				setActiveItem(mi_paint);
			}
		});
		// 将画图模式菜单项添加到模式菜单中
		add(mi_paint);

		// 为选择模式菜单项添加点击事件处理
		mi_choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 使画板处于选择模式
				((Board)board).ActiveChooser();
				// 设置选择模式菜单项为选中状态
				setActiveItem(mi_choose);
			}
		});
		// 将选择模式菜单项添加到模式菜单中
		add(mi_choose);
	}
}