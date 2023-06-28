package qut.lxp.painter;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;

import qut.lxp.painter.UI.AppearanceMenu;
import qut.lxp.painter.UI.Board;
import qut.lxp.painter.UI.ColorMenu;
import qut.lxp.painter.UI.FileMenu;
import qut.lxp.painter.UI.PatternMenu;
import qut.lxp.painter.UI.ShapeMenu;
import qut.lxp.painter.UI.ThicknessMenu;
import qut.lxp.painter.UI.TransparencyMenu;

/**
 * 客户端（继承JFrame）
 */
public class App extends JFrame {

	// 序列化版本ID
	private static final long serialVersionUID = 5096147644474297857L;

	// 程序名称
	private final String name = "几何画板";

	/**
	 * 画板（JPanel类型）
	 */
	private JPanel board = new Board();

	// 程序入口
	public static void main(String[] args) {
		// 将GUI事件调度到事件调度线程
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 设置观感（Look and Feel）
					final String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);
					// 创建App实例
					App frame = new App();
					// 显示窗口
					frame.setVisible(true);
				} catch (Exception e) {
					// 异常处理
					e.printStackTrace();
				}
			}
		});
	}

	// 构造方法
	public App() {
		super();
		// 设置窗口名称
		setName(name);
		// 设置窗口标题
		setTitle(name + " - 未命名.graph");
		// 设置窗口大小和位置
		setBounds(100, 100, 1000, 618);
		// 设置窗口相对于屏幕居中
		setLocationRelativeTo(null);

		// 将画板添加到内容面板
		getContentPane().add(board);

		// 创建菜单栏
		JMenuBar menuBar = new JMenuBar();
		// 设置菜单栏
		setJMenuBar(menuBar);

		// 创建并添加各种菜单
		FileMenu fileMenu = new FileMenu(this, board);
		menuBar.add(fileMenu);

		PatternMenu modelMenu = new PatternMenu(board);
		menuBar.add(modelMenu);

		ShapeMenu shapeMenu = new ShapeMenu(board);
		menuBar.add(shapeMenu);

		ColorMenu colorMenu = new ColorMenu(board);
		AppearanceMenu.setColorMenu(colorMenu);
		menuBar.add(colorMenu);

		ThicknessMenu thicknessMenu = new ThicknessMenu(board);
		AppearanceMenu.setThicknessMenu(thicknessMenu);
		menuBar.add(thicknessMenu);

		TransparencyMenu transparencyMenu = new TransparencyMenu(board);
		AppearanceMenu.setTransparencyMenu(transparencyMenu);
		menuBar.add(transparencyMenu);

		// 添加窗口关闭监听器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 在关闭窗口前检查是否需要保存文件
				fileMenu.ifSave();
				// 退出程序
				System.exit(0);
			}
		});
	}
}