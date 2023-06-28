// 定义包名
package qut.lxp.painter.UI;

// 导入处理事件的类
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 导入文件操作的类
import java.io.File;
// 导入弹出窗口的类
import javax.swing.JOptionPane;
// 导入文件选择对话框的类
import javax.swing.JFileChooser;
// 导入用于创建窗体的类
import javax.swing.JFrame;
// 导入用于创建菜单项的类
import javax.swing.JMenu;
// 导入用于创建子菜单项的类
import javax.swing.JMenuItem;
// 导入用于创建面板的类
import javax.swing.JPanel;
// 导入文件过滤器的类
import javax.swing.filechooser.FileNameExtensionFilter;

// 文件菜单类（继承自JMenu）
public class FileMenu extends JMenu {

	// 设置文件过滤器以限制文件类型
	private final FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("几何画板文件", "graph");
	// 默认的文件路径
	private String defaultPath = "C:\\Users\\Administrator\\Desktop";
	// 创建文件选择器
	private JFileChooser fileChooser = new JFileChooser(defaultPath);
	// 文件对象，用于操作文件
	private File file;
	// 主窗口的引用
	private JFrame jf;
	// 画板的引用
	private JPanel board;
	// 创建菜单项：新建
	private JMenuItem mi_new = new JMenuItem("新建");
	// 创建菜单项：打开
	private JMenuItem mi_open = new JMenuItem("打开");
	// 创建菜单项：保存
	private JMenuItem mi_save = new JMenuItem("保存");
	// 创建菜单项：另存为
	private JMenuItem mi_saveAs = new JMenuItem("另存为");
	// 创建菜单项：另存为图片
	private JMenuItem mi_saveAsJPG = new JMenuItem("另存为图片");

	// 构造函数，初始化文件菜单
	public FileMenu(JFrame jf, JPanel board) {
		// 调用父类构造函数，设置菜单名称
		super("文件");
		// 保存主窗口的引用
		this.jf = jf;
		// 保存画板的引用
		this.board = board;
		// 为文件选择器设置文件过滤器
		fileChooser.setFileFilter(fileFilter);

		// 为"新建"菜单项添加监听器
		mi_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 判断是否需要保存文件
				ifSave();
			}
		});
		// 将"新建"菜单项添加到菜单中
		add(mi_new);

		// 为"打开"菜单项添加监听器
		mi_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示文件打开对话框
				if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					// 获取选择的文件
					file = fileChooser.getSelectedFile();
					// 调用画板的open方法，打开文件
					((Board)board).open(file.getPath());
					// 更新窗口标题
					jf.setTitle(jf.getName() + " - " + file.getName());
				}
			}
		});
		// 将"打开"菜单项添加到菜单中
		add(mi_open);

		// 为"保存"菜单项添加监听器
		mi_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 如果文件为空，则调用另存为方法
				if(file == null) {
					save();
				} else {
					// 调用画板的save方法，保存文件
					((Board)board).save(file.getPath());
				}
			}
		});
		// 将"保存"菜单项添加到菜单中
		add(mi_save);

		// 为"另存为"菜单项添加监听器
		mi_saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 调用另存为方法
				save();
			}
		});
		// 将"另存为"菜单项添加到菜单中
		add(mi_saveAs);

		// 为"另存为图片"菜单项添加监听器
		mi_saveAsJPG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示文件保存对话框
				if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					// 获取选择的文件
					file = fileChooser.getSelectedFile();
					// 调用画板的saveAsJPG方法，保存为图片
					((Board)board).saveAsJPG(file.getPath());
				}
			}
		});
		// 将"另存为图片"菜单项添加到菜单中
		add(mi_saveAsJPG);
	}

	// 判断是否需要保存文件
	 public void ifSave() {
		// 弹出提示框，询问是否需要保存
		int n = JOptionPane.showConfirmDialog(null, "是否需要保存当前文件？", "提示", JOptionPane.YES_NO_OPTION);
		// 如果用户选择"是"，则调用另存为方法
		if(n == JOptionPane.YES_OPTION) {
			save();
		}
	}

	// 保存文件的方法
	private void save() {
		// 显示文件保存对话框
		if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			// 获取选择的文件
			file = fileChooser.getSelectedFile();
			// 调用画板的save方法，保存文件
			((Board)board).save(file.getPath());
			// 更新窗口标题
			jf.setTitle(jf.getName() + " - " + file.getName());
		}
	}
}