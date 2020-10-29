package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.StyledText;

public class Daolan {

	protected Shell shell;
	private StackLayout stackLayout = new StackLayout();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Daolan window = new Daolan();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1000, 730);
		shell.setImage(SWTResourceManager.getImage(about.class, "/images/icon.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setText("导览");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		composite_1.setBackgroundImage(SWTResourceManager.getImage(Daolan.class, "/images/background.jpg"));
		
		Label label_1 = new Label(composite_1, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		label_1.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_1.setBounds(50, 201, 135, 40);
		label_1.setText("开放时间");
		
		Label label_2 = new Label(composite_1, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		label_2.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_2.setBounds(50, 332, 135, 40);
		label_2.setText("游览须知");
		
		Label label_3 = new Label(composite_1, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		label_3.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_3.setBounds(50, 476, 135, 40);
		label_3.setText("票务服务");
		
		Label label_52 = new Label(composite_1, SWT.NONE);
		
		label_52.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_52.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_52.setBounds(50, 599, 124, 40);
		label_52.setText("返回主页");
		
		
		
		
		//堆栈布局
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setLayout( stackLayout );
		
		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBackgroundImage(SWTResourceManager.getImage(Daolan.class, "/images/background.jpg"));
		
		Label lblNewLabel = new Label(composite_3, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 25, SWT.BOLD));
		lblNewLabel.setBounds(203, 123, 310, 50);
		lblNewLabel.setText("【开放时间】");
		
		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		composite_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_5.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		composite_5.setBackgroundImage(SWTResourceManager.getImage(Daolan.class, "/images/background.jpg"));
		
		Label lblNewLabel_2 = new Label(composite_5, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 25, SWT.BOLD));
		lblNewLabel_2.setBounds(205, 112, 326, 48);
		lblNewLabel_2.setText("【游览须知】");
		
		Label lblNewLabel_14 = new Label(composite_5, SWT.NONE);
		lblNewLabel_14.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		lblNewLabel_14.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel_14.setBounds(10, 187, 162, 36);
		lblNewLabel_14.setText("做文明观众");
		
		Label label_25 = new Label(composite_5, SWT.WRAP);
		label_25.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_25.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		label_25.setText("在您参观时请留意自己携带的物品");
		label_25.setBounds(10, 364, 285, 48);
		
		Label label_26 = new Label(composite_5, SWT.WRAP);
		label_26.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_26.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		label_26.setText("如遇人群密集时，请听从工作人员的指挥");
		label_26.setBounds(362, 187, 402, 54);
		
		Label label_27 = new Label(composite_5, SWT.NONE);
		label_27.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		label_27.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_27.setText("文明环境靠大家共同营造");
		label_27.setBounds(364, 364, 300, 28);
		
		Label lblNewLabel_15 = new Label(composite_5, SWT.NONE);
		lblNewLabel_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_15.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		lblNewLabel_15.setBounds(10, 548, 348, 28);
		lblNewLabel_15.setText("尊重文化遗产，保护文物古迹");
		
		Label label_28 = new Label(composite_5, SWT.WRAP);
		label_28.setFont(SWTResourceManager.getFont("楷体", 13, SWT.BOLD));
		label_28.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_28.setText("如果遇到紧急情况，请就近寻找工作人员帮助");
		label_28.setBounds(364, 548, 410, 48);
		
		Label label_4 = new Label(composite_5, SWT.WRAP);
		label_4.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setText("请不要在古建筑和古树上留下您的大名，刻画涂写不仅不会使您英名永驻，反而遭到大家的鄙视");
		label_4.setBounds(10, 582, 285, 59);
		
		Label label_30 = new Label(composite_5, SWT.WRAP);
		label_30.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_30.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_30.setText("请不要轻信和接受社会散杂人员派发的各种广告和兜售的商品。严防上当受骗，并欢迎举报。");
		label_30.setBounds(364, 241, 335, 64);
		
		Label label_32 = new Label(composite_5, SWT.WRAP);
		label_32.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_32.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_32.setBounds(10, 229, 306, 121);
		label_32.setText("为不妨碍、影响他人参观，按照国际惯例在展厅请勿使用闪光灯和三脚架拍照。在我院与其他博物馆合作举办的展览以及特色商品店，因有版权协议，不允许观众拍照展品，请注意警示标志并服从展厅工作人员的管理。");
		
		Label label_37 = new Label(composite_5, SWT.WRAP);
		label_37.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_37.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_37.setBounds(362, 602, 315, 42);
		label_37.setText("如果您与亲友在参观中走失，可到景运门内西南侧的广播室通知他们。");
		
		Label label_39 = new Label(composite_5, SWT.WRAP);
		label_39.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_39.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_39.setBounds(364, 403, 335, 121);
		label_39.setText("请勿携带宠物进院参观。请尽量不妨碍其他观众请保持衣容整洁。不要做出有碍观瞻、有损形象行为。为了您和他人的健康，请勿随地吐痰。请勿乱丢垃圾废物请您尊重清洁工人的劳动。");
		
		Composite composite_6 = new Composite(composite_2, SWT.NONE);
		composite_6.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		composite_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_6.setBackgroundImage(SWTResourceManager.getImage(Daolan.class, "/images/background.jpg"));
		stackLayout.topControl= composite_3;
		Label lblNewLabel_3 = new Label(composite_6, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 25, SWT.BOLD));
		lblNewLabel_3.setBounds(243, 123, 286, 52);
		lblNewLabel_3.setText("【票务服务】");
		
		Label label_43 = new Label(composite_6, SWT.NONE);
		label_43.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label_43.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_43.setBounds(10, 204, 130, 34);
		label_43.setText("门票须知：");
		
		Label lblNewLabel_16 = new Label(composite_6, SWT.WRAP);
		lblNewLabel_16.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		lblNewLabel_16.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_16.setText("●每年4月1日至10月31日为旺季，普通门票60元/人●每年11月1日至次年3月31日为淡季，普通门票40元/人");
		lblNewLabel_16.setBounds(10, 244, 521, 39);
		
		Label label_45 = new Label(composite_6, SWT.NONE);
		label_45.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label_45.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_45.setBounds(10, 287, 177, 34);
		label_45.setText("门票优惠政策：");
		
		Label label_46 = new Label(composite_6, SWT.NONE);
		label_46.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_46.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_46.setText("1. 大、中、小学生（含港、澳、台学生,不含成人教育、研究生），\r\n凭学生证或学校介绍信，可购学生票，20元/人。\r\n2. 6周岁（不含6周岁）至18周岁（含18周岁）未成年人，可凭身\r\n份证、户口本或护照购买学生票，20元/人。\r\n3. 60岁以上（含60岁）老年人凭身份证原件，门票半价优惠。\r\n4. 持有本市社会保障金领取证的人员，门票半价优惠。\r\n5. 离休干部凭离休证，免票参观。\r\n6. 6周岁（含6周岁）以下或身高1.2米（含1.2米）以下儿童免票\r\n参观\r\n7. 残疾人凭残疾人证件，免票参观。\r\n8. “三八”妇女节，妇女享受门票半价优惠。\r\n9. “六一”儿童节，14周岁以下儿童（含14周岁），免费参观。随\r\n同家长一人享受半价优惠 。\r\n10. “八一”建军节，现役军人凭有效证件，免费参观。\r\n");
		label_46.setBounds(10, 327, 754, 346);
		
		Label label = new Label(composite_3, SWT.WRAP);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		label.setFont(SWTResourceManager.getFont("楷体", 18, SWT.BOLD));
		label.setBounds(10, 214, 92, 33);
		label.setText("旺季");
		
		Label label_5 = new Label(composite_3, SWT.WRAP);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setFont(SWTResourceManager.getFont("黑体", 16, SWT.BOLD));
		label_5.setBounds(110, 217, 193, 32);
		label_5.setText("4.1-10.31");
		
		Label label_6 = new Label(composite_3, SWT.WRAP);
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_6.setFont(SWTResourceManager.getFont("楷体", 18, SWT.BOLD));
		label_6.setBounds(377, 214, 92, 33);
		label_6.setText("淡季");
		
		Label label_7 = new Label(composite_3, SWT.WRAP);
		label_7.setFont(SWTResourceManager.getFont("黑体", 16, SWT.BOLD));
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_7.setText("11.1-3.31");
		label_7.setBounds(482, 217, 175, 33);
		
		Label label_8 = new Label(composite_3, SWT.WRAP);
		label_8.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_8.setBounds(10, 293, 345, 50);
		label_8.setText("每年4月1日至十月11日采用旺季开放时间");
		
		Label label_9 = new Label(composite_3, SWT.WRAP);
		label_9.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_9.setBounds(371, 293, 403, 50);
		label_9.setText("每年11月1日至来年3月31日采用淡季开放时间");
		
		Label label_10 = new Label(composite_3, SWT.NONE);
		label_10.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_10.setBounds(10, 364, 267, 33);
		label_10.setText("开始售票，开始进馆时间：");
		
		Label label_11 = new Label(composite_3, SWT.NONE);
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_11.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_11.setBounds(371, 364, 267, 33);
		label_11.setText("开始售票，开始进馆时间：");
		
		Label lblNewLabel_6 = new Label(composite_3, SWT.WRAP);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_6.setBounds(10, 423, 255, 53);
		lblNewLabel_6.setText("止票时间(含钟表馆，珍宝馆)：");
		
		Label label_12 = new Label(composite_3, SWT.WRAP);
		label_12.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_12.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_12.setBounds(371, 423, 267, 53);
		label_12.setText("止票时间(含钟表馆，珍宝馆)：");
		
		Label label_13 = new Label(composite_3, SWT.NONE);
		label_13.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_13.setBounds(10, 482, 163, 33);
		label_13.setText("停止入馆时间：");
		
		Label label_14 = new Label(composite_3, SWT.NONE);
		label_14.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_14.setBounds(371, 482, 152, 33);
		label_14.setText("停止入馆时间：");
		
		Label label_15 = new Label(composite_3, SWT.NONE);
		label_15.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_15.setBounds(10, 542, 163, 33);
		label_15.setText("闭馆时间：");
		
		Label label_16 = new Label(composite_3, SWT.NONE);
		label_16.setFont(SWTResourceManager.getFont("楷体", 11, SWT.BOLD));
		label_16.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_16.setBounds(371, 542, 138, 33);
		label_16.setText("闭馆时间：");
		
		Label label_17 = new Label(composite_3, SWT.CENTER);
		label_17.setOrientation(SWT.RIGHT_TO_LEFT);
		label_17.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_17.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		label_17.setText("8：00");
		label_17.setBounds(278, 364, 77, 31);
		
		Label lblNewLabel_1 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_1.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(278, 423, 77, 33);
		lblNewLabel_1.setText("16：00");
		
		Label lblNewLabel_5 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_5.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_5.setBounds(268, 482, 84, 33);
		lblNewLabel_5.setText("16：10");
		
		Label lblNewLabel_7 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_7.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_7.setBounds(271, 542, 84, 33);
		lblNewLabel_7.setText("17：00");
		
		Label lblNewLabel_8 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_8.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_8.setBounds(668, 364, 84, 31);
		lblNewLabel_8.setText("8：00");
		
		Label lblNewLabel_9 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_9.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_9.setBounds(668, 423, 88, 33);
		lblNewLabel_9.setText("15：30");
		
		Label lblNewLabel_10 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_10.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_10.setText("15：40");
		lblNewLabel_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_10.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_10.setBounds(668, 482, 92, 33);
		
		Label lblNewLabel_11 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_11.setOrientation(SWT.RIGHT_TO_LEFT);
		lblNewLabel_11.setFont(SWTResourceManager.getFont("黑体", 11, SWT.BOLD));
		lblNewLabel_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_11.setBounds(679, 542, 85, 33);
		lblNewLabel_11.setText("16：30");
		stackLayout.topControl= composite_3;
		sashForm.setWeights(new int[] {205, 770});
		
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_3;
				
				composite_3.setVisible(true);		
				composite_5.setVisible(false);
				composite_6.setVisible(false);

			}
		});
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
                stackLayout.topControl = composite_5;
				
				composite_3.setVisible(false);		
				composite_5.setVisible(true);
				composite_6.setVisible(false);

			}
		});
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
                stackLayout.topControl = composite_6;
				
				composite_3.setVisible(false);
				composite_5.setVisible(false);
				composite_6.setVisible(true);

			}
		});
		label_52.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				
				
			}
		});
	}
}