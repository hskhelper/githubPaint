package qut.lxp.painter.UI; // 定义包名

import java.awt.Color; // 导入颜色类
import java.awt.Graphics; // 导入绘图类
import java.awt.Graphics2D; // 导入2D绘图类
import java.awt.RenderingHints; // 导入渲染提示类
import java.awt.image.BufferedImage; // 导入缓冲图像类
import java.io.File; // 导入文件类
import java.io.FileInputStream; // 导入文件输入流类
import java.io.FileOutputStream; // 导入文件输出流类
import java.io.IOException; // 导入输入输出异常类
import java.io.ObjectInputStream; // 导入对象输入流类
import java.io.ObjectOutputStream; // 导入对象输出流类
import java.util.ArrayList; // 导入ArrayList类
import javax.imageio.ImageIO; // 导入图像输入输出类
import javax.swing.JPanel; // 导入面板类

import qut.lxp.painter.BLL.pattern.Chooser; // 导入选择器类
import qut.lxp.painter.BLL.pattern.Painter; // 导入绘图类
import qut.lxp.painter.BLL.pattern.PatternAbs; // 导入模式抽象类
import qut.lxp.painter.model.shape.MyShapeItf; // 导入图形接口类

/**
 * 画板（继承JPanel）
 */
public class Board extends JPanel { // 定义Board类，继承自JPanel

	/**
	 * 记录所有图形
	 */
	private ArrayList<MyShapeItf> myShapeList = new ArrayList<MyShapeItf>(); // 定义存储所有图形的列表
	private Painter painter = new Painter(this); // 创建用于绘制图形的Painter对象
	private Chooser chooser = new Chooser(this); // 创建用于选择图形的Chooser对象
	private MyShapeItf myShape; // 定义当前绘制或选择的图形对象

	/**
	 * 当前模式
	 */
	private PatternAbs nowPattern; // 定义当前的模式，可以是Painter或Chooser

	public Board() { // 构造函数
		super(); // 调用父类JPanel的构造函数
		setFocusable(true); // 设置画板可获得焦点
		setBackground(Color.white); // 设置画板背景颜色为白色
	}

	@Override
	public void paint(Graphics g) { // 重写绘制方法
		super.paint(g); // 调用父类绘制方法
		Graphics2D g2 = (Graphics2D)g; // 将Graphics对象转换为Graphics2D对象
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 设置抗锯齿渲染提示
		for(MyShapeItf item : myShapeList) { // 遍历myShapeList中的所有图形
			item.applyAppearance(g2); // 应用图形的外观（颜色、线宽等）
			g2.draw(item.getShape()); // 绘制图形的轮廓
			g2.fill(item.getShape()); // 填充图形
		}
		myShape = painter.getMyShape(); // 获取当前绘制的图形
		if(myShape != null && myShape.getStartPoint() != null && myShape.getEndPoint() != null) { // 如果当前绘制的图形不为空且起始点和终点均不为空
			myShape.applyAppearance(g2); // 应用图形的外观
			g2.draw(myShape.getShape()); // 绘制图形的轮廓
		}
		g.dispose(); // 释放图形资源
	}

	public Painter getPainter() { // 获取Painter对象的方法
		return painter; // 返回Painter对象
	}

	public Chooser getChooser() { // 获取Chooser对象的方法
		return chooser; // 返回Chooser对象
	}

	public ArrayList<MyShapeItf> getArrayList() { // 获取图形列表的方法
		return myShapeList; // 返回图形列表
	}

	/**
	 * 切换至画笔模式
	 */
	public void ActivePainter() { // 激活画笔模式的方法
		painter.setState(true); // 设置Painter对象的状态为激活
		chooser.setState(false); // 设置Chooser对象的状态为未激活
		nowPattern = painter; // 将当前模式设置为Painter
		myShape = null; // 将当前绘制或选择的图形设置为null
	}

	/**
	 * 切换至选择模式
	 */
	public void ActiveChooser() { // 激活选择模式的方法
		chooser.setState(true); // 设置Chooser对象的状态为激活
		painter.setState(false); // 设置Painter对象的状态为未激活
		nowPattern = chooser; // 将当前模式设置为Chooser
		myShape = null; // 将当前绘制或选择的图形设置为null
	}

	/**
	 * 获取当前模式
	 * @return PatternAbs
	 */
	public PatternAbs getNowPattern() { // 获取当前模式的方法
		return nowPattern; // 返回当前模式
	}

	/**
	 * 清屏
	 */
	public void clean() { // 清除画板上所有图形的方法
		myShapeList.clear(); // 清空图形列表
		repaint(); // 重绘画板
	}

	/**
	 * 保存数据为源文件
	 * @param path - 文件路径
	 */
	public void save(String path) { // 保存图形列表到文件的方法
		try { // 尝试保存文件
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path)); // 创建对象输出流
			os.writeObject(myShapeList); // 将图形列表写入输出流
			os.close(); // 关闭对象输出流
		} catch (Exception e) { // 捕获异常
			e.printStackTrace(); // 打印异常堆栈信息
		}
	}

	/**
	 * 打开源文件
	 * @param path - 文件路径
	 */
	public void open(String path) { // 从文件加载图形列表的方法
		try { // 尝试打开文件
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(path)); // 创建对象输入流
			myShapeList = (ArrayList<MyShapeItf>) is.readObject(); // 从输入流中读取图形列表
			repaint(); // 重绘画板
			is.close(); // 关闭对象输入流
		} catch (Exception e) { // 捕获异常
			e.printStackTrace(); // 打印异常堆栈信息
		}
	}
	/**
	 * 保存当前画板为图片
	 * @param path - 文件路径
	 */
	public void saveAsJPG(String path) { // 保存画板为JPG图片的方法
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB); // 创建缓冲图像
		paint(image.createGraphics()); // 将画板绘制到缓冲图像上
		File file = new File(path); // 创建文件对象
		try { // 尝试保存图片
			ImageIO.write(image, "jpg", file); // 将缓冲图像以JPG格式写入文件
		} catch (IOException e) { // 捕获输入输出异常
			e.printStackTrace(); // 打印异常堆栈信息
		}

	}
}