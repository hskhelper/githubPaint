// 导入所需的包，该包位于pers.corvey.painter.ui命名空间
package qut.lxp.painter.UI;

// 导入所需的类，用于创建一个带图标的菜单和菜单项
import javax.swing.ImageIcon; // 导入ImageIcon类，用于显示选中状态的图标
import javax.swing.JMenu; // 导入JMenu类，用于创建自定义菜单
import javax.swing.JMenuItem; // 导入JMenuItem类，用于创建自定义菜单项

// 创建一个名为MyJMenu的类，继承自JMenu，用于表示自定义菜单
public class MyJMenu extends JMenu {
	// 定义一个静态的ImageIcon对象，用于表示菜单项选中时的状态图标
	protected final static ImageIcon icon = new ImageIcon("./image/yes.png");

	// 定义一个JMenuItem对象，表示当前选中的菜单项
	protected JMenuItem activeItem;

	// 创建一个带有名称参数的构造函数，用于初始化自定义菜单
	public MyJMenu(String name) {
		super(name); // 调用父类构造函数，传入菜单名称
	}

	// 定义一个getActiveItem方法，用于获取当前选中的菜单项
	public JMenuItem getActiveItem() {
		return activeItem; // 返回当前选中的菜单项
	}

	// 定义一个setActiveItem方法，用于设置当前选中的菜单项
	public void setActiveItem(JMenuItem activeItem) {
		if (activeItem == null) {
			throw new IllegalArgumentException("activeItem cannot be null");
		}

		if(getActiveItem() != null) // 如果当前已有选中的菜单项
			getActiveItem().setIcon(null); // 将原选中菜单项的图标设置为空
		activeItem.setIcon(icon); // 为新选中的菜单项设置选中图标
		this.activeItem = activeItem; // 更新当前选中的菜单项
	}
}