package com.nine.ui;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.icu.text.SimpleDateFormat;
import com.nine.dao.DBHelper;
import com.nine.util.Data;
import com.nine.util.myUtil;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.custom.CLabel;

public class Index {

	public Label label_6;
	public Label label_7;
	private Label label_9;
	
	private Label gg_1;
	private Label gg_2;
	private Label gg_3;
	
	protected Shell shell;
	//private Thread times;
	private Thread showSum;
	private Thread Shang;
		
	private Label label_28;
	private  Label label_30;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private StackLayout stackLayout = new StackLayout();
	myUtil mu = new myUtil();
	DBHelper db = new DBHelper();
	
	String sql1 = "select * from shang";
	List<Map<String, Object>> count = db.findAll(sql1);
	public	int sid=0;//一日一赏计数器
	public int Maxsid =count.size()-1;
	
	//公告查询
	String sql = " select * from ( select rownum as rowno , gg.* from gg where rownum <= 3) x where x.rowno>=1"; 
	List<Map<String , Object>> list = db.findAll(sql);
	int length = 0;
	
	private int i = 1; //轮播图计数器
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Index window = new Index();
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
		shell.setImage(SWTResourceManager.getImage(about.class, "/images/icon.jpg"));
		shell.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/background_6.jpg"));
		shell.setSize(1000, 730);
		shell.setText("博物院藏品浏览和订票系统");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/background_left.jpg"));
		
		Label label = new Label(composite_1, SWT.SHADOW_NONE | SWT.CENTER);
		
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		
		label.setFont(SWTResourceManager.getFont("华文新魏", 18, SWT.BOLD));
		label.setBounds(4, 157, 102, 44);
		label.setText("首页");
		
		Label label_1 = new Label(composite_1, SWT.CENTER);
		
		label_1.setText("导览");
		label_1.setFont(SWTResourceManager.getFont("华文新魏", 18, SWT.BOLD));
		label_1.setBounds(4, 241, 102, 44);
		
		Label label_2 = new Label(composite_1, SWT.CENTER);
		
		label_2.setText("展览");
		label_2.setFont(SWTResourceManager.getFont("华文新魏", 18, SWT.BOLD));
		label_2.setBounds(4, 320, 102, 44);
		
		Label label_3 = new Label(composite_1, SWT.CENTER);
		label_3.setText("藏品");
		label_3.setFont(SWTResourceManager.getFont("华文新魏", 18, SWT.BOLD));
		label_3.setBounds(4, 400, 102, 44);
		
		Label label_4 = new Label(composite_1, SWT.CENTER);
		label_4.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_ARROW));
		label_4.setText("关于");
		label_4.setFont(SWTResourceManager.getFont("华文新魏", 18, SWT.BOLD));
		label_4.setBounds(4, 555, 102, 44);
		
		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setAlignment(SWT.CENTER);
		label_5.setText("订票");
		label_5.setFont(SWTResourceManager.getFont("华文新魏", 18, SWT.BOLD));
		label_5.setBounds(4, 478, 102, 44);
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/background.jpg"));
		//composite_2.setLayout(stackLayout);
		mu.windowMove(composite_1, shell);
		
		label_6 = new Label(composite_1, SWT.BORDER);
		label_6.setToolTipText("编辑资料");
		label_6.setBounds(0, 0, 100, 100);
		
		label_7 = new Label(composite_1, SWT.WRAP | SWT.SHADOW_NONE);
		label_7.setToolTipText("编辑资料");
		label_7.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_ARROW));
		label_7.setBounds(100, 7, 63, 93);
		label_7.setFont(SWTResourceManager.getFont("华文新魏", 12, SWT.BOLD));
		
		mu.windowMove(composite_2, shell);
		
		label_9 = new Label(composite_2, SWT.NONE);
		label_9.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_9.setBounds(357, 653, 105, 24);
		label_9.setText(sdf.format( new Date() ));
		
		
		Label label_8 = new Label(composite_2, SWT.NONE);
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_8.setFont(SWTResourceManager.getFont("楷体", 30, SWT.BOLD));
		label_8.setBounds(637, 316, 161, 60);
		
		Label label_10 = new Label(composite_2, SWT.NONE);
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_10.setFont(SWTResourceManager.getFont("楷体", 20, SWT.BOLD));
		label_10.setBounds(637, 270, 165, 40);
		label_10.setText("藏品总数");
		
		Label label_11 = new Label(composite_2, SWT.NONE);
		label_11.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/hd_1.jpg"));
		label_11.setBounds(708, 379, 105, 120);
		
		Label label_12 = new Label(composite_2, SWT.NONE);
		
		label_12.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/dp_1.jpg"));
		label_12.setBounds(495, 379, 105, 120);
		
		Label label_13 = new Label(composite_2, SWT.NONE);
		label_13.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/1.jpg"));
		label_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		label_13.setBounds(3, 0, 810, 240);
		
		Label label_14 = new Label(composite_2, SWT.NONE);
		label_14.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/2.jpg"));
		label_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		label_14.setBounds(3, 0, 810, 240);
		
		Label label_17 = new Label(composite_2, SWT.NONE);
		label_17.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/3.jpg"));
		label_17.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		label_17.setBounds(3, 0, 810, 240);
		
		Label label_18 = new Label(composite_2, SWT.NONE);
		label_18.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/4.jpg"));
		label_18.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		label_18.setBounds(3, 0, 810, 240);
		
		Label label_19 = new Label(composite_2, SWT.NONE);
		label_19.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/5.jpg"));
		label_19.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_19.setBounds(3, 0, 810, 240);
		
		Label label_15 = new Label(composite_2, SWT.NONE);
		label_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		
		label_15.setText("①");
		label_15.setFont(SWTResourceManager.getFont("黑体", 12, SWT.BOLD));
		label_15.setBounds(332, 240, 24, 24);
		
		Label label_16 = new Label(composite_2, SWT.NONE);
		label_16.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		label_16.setText("②");
		label_16.setFont(SWTResourceManager.getFont("黑体", 12, SWT.BOLD));
		label_16.setBounds(362, 240, 24, 24);
		
		Label label_20 = new Label(composite_2, SWT.NONE);
		label_20.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		label_20.setText("③");
		label_20.setFont(SWTResourceManager.getFont("黑体", 12, SWT.BOLD));
		label_20.setBounds(392, 240, 24, 24);
		
		Label label_21 = new Label(composite_2, SWT.NONE);
		label_21.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		label_21.setText("④");
		label_21.setFont(SWTResourceManager.getFont("黑体", 12, SWT.BOLD));
		label_21.setBounds(422, 240, 24, 24);
		
		Label label_22 = new Label(composite_2, SWT.NONE);
		label_22.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		label_22.setText("⑤");
		label_22.setFont(SWTResourceManager.getFont("黑体", 12, SWT.BOLD));
		label_22.setBounds(452, 240, 24, 24);
		
		Label label_23 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_23.setBounds(0, 250, 320, 5);
		
		Label label_24 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_24.setBounds(492, 250, 320, 5);
		
		Label label_25 = new Label(composite_2, SWT.CENTER);
		label_25.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		label_25.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_25.setText("一日一赏");
		label_25.setBounds(39, 274, 124, 30);
		
		Label label_26 = new Label(composite_2, SWT.CENTER);
		label_26.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		label_26.setText("时间-票务");
		label_26.setBounds(587, 508, 139, 24);
		
		Label label_27 = new Label(composite_2, SWT.CENTER);
		label_27.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_27.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_27.setText("博物院公告");
		label_27.setBounds(37, 487, 161, 30);
		
		Label label_31 = new Label(composite_2, SWT.NONE);
		
		label_31.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/wwk.jpg"));
		label_31.setBounds(600, 379, 110, 120);
		
		Label label_33 = new Label(composite_2, SWT.WRAP);
		label_33.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_33.setText(" 8:00 | 开始售票，入馆时间");
		label_33.setBounds(530, 539, 272, 24);
		
		Label label_32 = new Label(composite_2, SWT.NONE);
		label_32.setText("16:00 | 停止售票时间");
		label_32.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_32.setBounds(530, 569, 250, 24);
		
		Label label_34 = new Label(composite_2, SWT.NONE);
		label_34.setText("16:30 | 停止入馆时间");
		label_34.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_34.setBounds(530, 600, 250, 24);
		
		Label label_35 = new Label(composite_2, SWT.NONE);
		label_35.setText("17:00 | 闭馆时间");
		label_35.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_35.setBounds(530, 627, 250, 24);
		
		
		sashForm.setWeights(new int[] {172, 855});
		
		label_28 = new Label(composite_2, SWT.WRAP);
		
		label_28.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		label_28.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		
		
		Label label_29 = new Label(composite_2, SWT.BORDER);
		label_29.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/QQ截图20200828185623.jpg"));
		label_29.setBounds(3, 274, 30, 30);
		
		label_30 = new Label(composite_2, SWT.NONE);
		label_30.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_30.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		
		gg_1 = new Label(composite_2, SWT.WRAP | SWT.SHADOW_NONE);
		gg_1.setToolTipText("点击查看详情");
		
		gg_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		gg_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		gg_1.setBounds(3, 535, 400, 30);
		
		gg_2 = new Label(composite_2, SWT.WRAP | SWT.SHADOW_NONE);
		gg_2.setToolTipText("点击查看详情");
		
		gg_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		gg_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		gg_2.setBounds(3, 576, 413, 30);
		
		gg_3 = new Label(composite_2, SWT.WRAP | SWT.SHADOW_NONE);
		gg_3.setToolTipText("点击查看详情");
		gg_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		gg_3.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		gg_3.setBounds(3, 606, 413, 30);
		
		Label label_38 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_38.setBounds(0, 663, 355, 2);
		
		Label label_39 = new Label(composite_2, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_39.setBounds(458, 663, 355, 2);
		
		Link link = new Link(composite_2, SWT.NONE);
		link.setBounds(5, 635, 124, 24);
		link.setText("<a>查看更多公告</a>");
		
		Label label_36 = new Label(composite_2, SWT.BORDER);
		label_36.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/mrys.jpg"));
		label_36.setBounds(3, 487, 30, 30);
		//公告的点击事件
		gg_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				gg_2.setVisible(false);
				gg_3.setVisible(false);
				int length = ("  "+list.get(0).get("text")+"").length();
				int count = length / 20 + 1;
				gg_1.setBounds(3, 529, 400 , 30*count);
				gg_1.setText("  "+(list.get(0).get("text")+""));
				gg_1.setToolTipText("双击还原");
			}
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				gg_2.setVisible(true);
				gg_3.setVisible(true);
				showGG();
			}
		});
		gg_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				gg_1.setVisible(false);
				gg_3.setVisible(false);
				int length = ("  "+list.get(1).get("text")+"").length();
				int count = length / 20 + 1;
				gg_2.setBounds(3, 529, 400 , 30*count);
				gg_2.setText(("  "+list.get(1).get("text")+""));
				gg_2.setToolTipText("双击还原");
			}
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				gg_1.setVisible(true);
				gg_3.setVisible(true);
				showGG();
			}
		});
		gg_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				gg_1.setVisible(false);
				gg_2.setVisible(false);
				int length = ("  "+list.get(2).get("text")+"").length();
				int count = length / 20 + 1;
				gg_3.setBounds(3, 529, 400 , 30*count);
				gg_3.setText(("  "+list.get(2).get("text")+""));
				gg_3.setToolTipText("双击还原");
			}
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				gg_1.setVisible(true);
				gg_2.setVisible(true);
				showGG();
			}
		});
		//点击预约订票图标显示订票窗口
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				dp d = new dp();
				d.open();
			}
		});
		
		//点击数字文物库图标显示数字文物库
		label_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				showCangpin1 scp = new showCangpin1();
				scp.open();
			}
		});
		//点击博物馆活动图标显示展览图标
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Exhibition1  ex = new Exhibition1();
				ex.open();
			}
		});
		
		//点击头像编辑资料
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Useredit1 ue = new Useredit1();
				ue.open();
			}
		});
		//点击头像编辑资料
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Useredit1 ue = new Useredit1();
				ue.open();
			}
		});
		
		//label鼠标经过事件
		gg_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				gg_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				gg_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
			}
		});
		gg_2.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				gg_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				gg_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
			}
		});
		gg_3.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				gg_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				gg_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
			}
		});
		label.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		label_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		label_2.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		label_3.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		label_4.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		label_5.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		label_7.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		
		//利用label鼠标移入时间，实现轮播图的效果
		label_15.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_13.setVisible(true);
				label_14.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				i = 2;
			}
		});
		label_16.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_13.setVisible(false);
				label_14.setVisible(true);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(false);
				i = 3;
			}
		});
		label_20.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_17.setVisible(true);
				label_18.setVisible(false);
				label_19.setVisible(false);
				i = 4;
			}
		});
		label_21.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(true);
				label_19.setVisible(false);
				i = 5;
			}
		});
		label_22.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_13.setVisible(false);
				label_14.setVisible(false);
				label_17.setVisible(false);
				label_18.setVisible(false);
				label_19.setVisible(true);
				i = 1;
			}
		});
		
		//
		label_12.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_12.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/dp_2.jpg"));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_12.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/dp_1.jpg"));
			}
		});
		label_31.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_31.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/wwk_2.jpg"));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_31.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/wwk.jpg"));
			}
		});
		label_11.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_11.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/hd_2.jpg"));
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_11.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/images/hd_1.jpg"));
			}
		});
		//利用线程，让时间刷新
				/*times = new Thread( new Runnable(){

					@Override
					public void run() {
						
						while( true ){
							 try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}					 
							Display.getDefault().asyncExec(new Runnable(){
								@Override
								public void run() {
									label_9.setText(sdf.format( new Date() ));	
								}						
							});
						}				
					}			
				});*/
			//times.start();

				//点击打开导览窗口事件
				label_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						Daolan daolan = new Daolan();
						daolan.open();
					}
				});
				//点击打开展览窗口事件
				label_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						Exhibition1 exhibition = new Exhibition1();
						exhibition.open();
					}
				});
				//点击打开藏品浏览窗口
				label_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						showCangpin1 cp = new showCangpin1();
						cp.open();
					}
				});
				//点击预约订票图标显示订票窗口
				label_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						dp d = new dp();
						d.open();
					}
				});
				
				//点击打开关于窗口
				label_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						about ab = new about();
						ab.open();
					}
				});
				
				//查看更多公告
				link.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						ggxq gg = new ggxq();
						gg.open();
					}
				});
				
				
				//显示总数
				showSum = new Thread(new Runnable(){

					@Override
					public void run() {
						while(true){
							
							try {
								showSum.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						Display.getDefault().asyncExec(new Runnable(){

							@Override
							public void run() {
								for(int i = 17000; i <= 18910; i+=1){
									label_8.setText( i+"");
								}
								showSum.stop();
							}
							
						});
					  }
					}
					
				});
				
				Shang = new Thread( new Runnable(){

					@Override
					public void run() {
						while(true){
						try {								
								showSum.sleep(6000);							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Display.getDefault().asyncExec(new Runnable(){

							@Override
							public void run() {
								++sid;
								showShang(  );	
								
								
								if( i == 1){
									label_13.setVisible(true);
									label_14.setVisible(false);
									label_17.setVisible(false);
									label_18.setVisible(false);
									label_19.setVisible(false);
									i++;
								}else if( i == 2){
									label_13.setVisible(false);
									label_14.setVisible(true);
									label_17.setVisible(false);
									label_18.setVisible(false);
									label_19.setVisible(false);
									i++;
								}else if( i == 3){
									label_13.setVisible(false);
									label_14.setVisible(false);
									label_17.setVisible(true);
									label_18.setVisible(false);
									label_19.setVisible(false);
									i++;
								
							}else if( i == 4){
								label_13.setVisible(false);
								label_14.setVisible(false);
								label_17.setVisible(false);
								label_18.setVisible(true);
								label_19.setVisible(false);
								i++;	
							}else{
									label_13.setVisible(false);
									label_14.setVisible(false);
									label_17.setVisible(false);
									label_18.setVisible(false);
									label_19.setVisible(true);
									i = 1;
							}
							}
						});			
					}	
				}
				});
				Shang.start();
				//开启数字滚动线程
				showSum.start();
				//调用显示头像的方法
				showtx();
				//调用显示一日一赏的方法
				showShang(  );
				//调用显示公告的方法
				showGG();
				
				//关闭窗口就关闭线程
				shell.addDisposeListener(new DisposeListener() {
					public void widgetDisposed(DisposeEvent arg0) {
						//times.stop();
						Shang.stop();
					}
				});
				
			}
		
		//主页显示头像
		public  void showtx(){
			String sql = "select * from memberuser where muid = ?";
			List<Map<String , Object>> list = db.findAll(sql,Data.mid);
			try {
				ByteArrayInputStream bais = new ByteArrayInputStream( (byte[]) list.get(0).get("photouser"));
				ImageData imageData = new ImageData(bais);
				imageData = imageData.scaledTo(100, 100);
				Image image = new Image(null , imageData);
				label_6.setImage(image);
				label_7.setText(list.get(0).get("muname")+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//一日一赏
		protected void showShang(){
			//如果循环超过记录数，就回到第一个
			if( this.sid > this.Maxsid ){
				this.sid = 0;
			}
			//String sql = "select * from shang";
			//List<Map<String , Object>> list = db.findAll(sql);
			int length = (this.count.get(this.sid).get("text")+"").length();
			int column = length/18+1;
			label_28.setBounds(3, 329, 430, column*25);
			label_30.setBounds(3, label_28.getLocation().y+column*25, 430, 40);
			label_28.setText(" "+this.count.get(this.sid).get("text"));
			label_30.setText("《"+this.count.get(this.sid).get("title") + "》·" + this.count.get(this.sid).get("author") + "·" + this.count.get(this.sid).get("years"));
		}
		
		//公告栏
		protected void showGG(){
			
			int length = 0;
			for( int i = 0; i < list.size(); i++){
				//System.out.println((list.get(0).get("title")+""));
				if( i == 0){
					length = (list.get(0).get("title")+""+list.get(0).get("times")).length();
					gg_1.setBounds(3, 529, 20 * length, 30);
					gg_1.setText((list.get(0).get("title")+" "+list.get(0).get("times")));
				}else if( i == 1){
					length = (list.get(1).get("title")+""+list.get(0).get("times")).length();
					gg_2.setBounds(3, 568, 20 * length, 30);
					gg_2.setText((list.get(1).get("title")+" "+list.get(0).get("times")));
				}else{
					length = (list.get(2).get("title")+""+list.get(0).get("times")).length();
					gg_3.setBounds(3, 606, 20 * length, 30);
					gg_3.setText((list.get(2).get("title")+" "+list.get(0).get("times")));
				}
			}
		}
	}

