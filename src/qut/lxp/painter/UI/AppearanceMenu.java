package qut.lxp.painter.UI;

import qut.lxp.painter.BLL.bridge.AppearanceItf;

// 外观菜单类，包含颜色、线宽和透明度菜单
public class AppearanceMenu {

	// 静态属性：颜色菜单实例
	private static ColorMenu colorMenu;
	// 静态属性：线宽菜单实例
	private static ThicknessMenu thicknessMenu;
	// 静态属性：透明度菜单实例
	private static TransparencyMenu transparencyMenu;

	// 静态方法：根据外观接口（AppearanceItf）激活相应的菜单项
	public static void activeItemByAppearance(AppearanceItf appearance) {
		// 激活颜色菜单中与外观颜色对应的项
		colorMenu.setActiveItem(colorMenu.getMap().get(appearance.getColor()));
		// 激活线宽菜单中与外观线宽对应的项
		thicknessMenu.setActiveItem(thicknessMenu.getMap().get(appearance.getWidth()));
		// 激活透明度菜单中与外观透明度对应的项
		transparencyMenu.setActiveItem(transparencyMenu.getMap().get(appearance.getTransparency()));
	}

	// 静态方法：设置颜色菜单实例
	public static void setColorMenu(ColorMenu menu) {
		colorMenu = menu; // 将传入的颜色菜单实例赋值给静态属性colorMenu
	}

	// 静态方法：设置线宽菜单实例
	public static void setThicknessMenu(ThicknessMenu menu) {
		thicknessMenu = menu; // 将传入的线宽菜单实例赋值给静态属性thicknessMenu
	}

	// 静态方法：设置透明度菜单实例
	public static void setTransparencyMenu(TransparencyMenu menu) {
		transparencyMenu = menu; // 将传入的透明度菜单实例赋值给静态属性transparencyMenu
	}
}