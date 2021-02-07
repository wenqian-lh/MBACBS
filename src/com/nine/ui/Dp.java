package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;
import com.nine.dao.DBHelper;
import com.nine.util.Data;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Dp {

	protected Shell shell;
	StackLayout stackLayout = new StackLayout();
	private Text text;
	private Text text_1;
	private Text text_2;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String nowDate = sdf.format( new Date());//当前时间
	private int year;
	private int month;
	private int day;
	private int target;
	private int now;
	private boolean flag = true;
		
	private String name; //姓名
	private String userId; //身份证号码
	private String time; //时间
	
	MyUtil mu = new MyUtil();
	DBHelper db = new DBHelper();
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Dp window = new Dp();
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
		shell.setSize(863, 730);
		shell.setImage(SWTResourceManager.getImage(About.class, "/images/icon.jpg"));
		shell.setText("预约订票");
		shell.setLayout(new FormLayout());
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		
		SashForm sashForm = new SashForm(composite, SWT.VERTICAL);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(Dp.class, "/images/background.jpg"));
		composite_1.setBackgroundMode(SWT.INHERIT_FORCE);
		
		Label label_9 = new Label(composite_1, SWT.NONE);
		
		label_9.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_9.setBounds(10, 10, 68, 31);
		label_9.setText("订票");
		
		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_10.setBounds(111, 10, 124, 31);
		label_10.setText("预约管理");
		int yeart = Integer.parseInt(nowDate.substring(0, 4));
		int montht = Integer.parseInt(nowDate.substring(5, 7));
		int dayt = Integer.parseInt(nowDate.substring(8, 10));
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setLayout(stackLayout);
		
		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_3.setBackgroundImage(SWTResourceManager.getImage(Dp.class, "/images/background_right.jpg"));
		
		DateTime dateTime = new DateTime(composite_3, SWT.BORDER | SWT.CALENDAR);
		dateTime.setBounds(14, -1, 310, 217);
		
		Label label_2 = new Label(composite_3, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(255, 215, 0));
		label_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		label_2.setBounds(53, 315, 289, 25);
		
		Label label_1 = new Label(composite_3, SWT.NONE);
		label_1.setText("请选择:预约日期：");
		label_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_1.setBounds(4, 244, 176, 25);
		
		text = new Text(composite_3, SWT.BORDER);
		text.setText("");
		text.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		text.setBounds(53, 480, 300, 35);
		
		Label lblSgffghf = new Label(composite_3, SWT.NONE);
		lblSgffghf.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		lblSgffghf.setForeground(SWTResourceManager.getColor(255, 215, 0));
		lblSgffghf.setBounds(174, 222, 183, 35);
		
		Label label_3 = new Label(composite_3, SWT.NONE);
		label_3.setText("请输入姓名:");
		label_3.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_3.setBounds(9, 346, 121, 25);
		
		text_1 = new Text(composite_3, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		text_1.setBounds(53, 377, 300, 35);
		
		Label label_4 = new Label(composite_3, SWT.NONE);
		label_4.setText("请输入身份证号码:");
		label_4.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_4.setBounds(9, 449, 176, 25);
		
		Label label_5 = new Label(composite_3, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(255, 215, 0));
		label_5.setBounds(53, 521, 298, 24);
		
		Button button = new Button(composite_3, SWT.NONE);
		button.setText("预  约");
		button.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button.setBounds(125, 551, 114, 34);
		
		text_2 = new Text(composite_3, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		text_2.setEnabled(false);
		text_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		text_2.setBounds(53, 275, 300, 35);
		
		
		Group group = new Group(composite_3, SWT.NONE);

		group.setText("公告栏");
		group.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		group.setFont(SWTResourceManager.getFont("楷体", 20, SWT.BOLD));
		group.setBounds(540, 10, 301, 189);
		
		Label label_6 = new Label(group, SWT.WRAP);
		label_6.setText("    博物院瞬时接待游客数调整为不得超过最大承载量的百分之三十。");
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_6.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label_6.setBounds(26, 60, 270, 133);
		
		Label label_7 = new Label(composite_3, SWT.WRAP);
		label_7.setForeground(SWTResourceManager.getColor(255, 255, 0));
		label_7.setText("疫情防控");
		label_7.setFont(SWTResourceManager.getFont("华文新魏", 35, SWT.BOLD));
		label_7.setBounds(433, 10, 71, 293);
		
		Label label_8 = new Label(composite_3, SWT.WRAP);
		label_8.setForeground(SWTResourceManager.getColor(255, 255, 0));
		label_8.setText("人人有责");
		label_8.setFont(SWTResourceManager.getFont("华文新魏", 35, SWT.BOLD));
		label_8.setBounds(433, 319, 79, 293);
		
		Group group_1 = new Group(composite_3, SWT.NONE);
		group_1.setFont(SWTResourceManager.getFont("黑体", 15, SWT.NORMAL));
		group_1.setText("游览须知");
		group_1.setBounds(540, 225, 301, 395);
		
		Label label_12 = new Label(group_1, SWT.WRAP);
		label_12.setText("  每年4月1日至10月31日为旺季，普通门票60元/人");
		label_12.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_12.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_12.setBounds(10, 86, 281, 44);
		
		Label label_13 = new Label(group_1, SWT.NONE);
		label_13.setText("门票须知");
		label_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_13.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_13.setBounds(91, 43, 94, 32);
		
		Label label_15 = new Label(group_1, SWT.WRAP);
		label_15.setText("  每年11月1日至次年3月31日为淡季，普通门票40元/人");
		label_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_15.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_15.setBounds(10, 137, 281, 44);
		
		Label label_14 = new Label(group_1, SWT.CENTER);
		label_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_14.setText("时间-票务");
		label_14.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		label_14.setBounds(70, 214, 139, 24);
		
		Label label_16 = new Label(group_1, SWT.WRAP);
		label_16.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_16.setText(" 8:00 | 开始售票，入馆时间");
		label_16.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_16.setBounds(19, 258, 272, 24);
		
		Label label_17 = new Label(group_1, SWT.NONE);
		label_17.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_17.setText("16:00 | 停止售票时间");
		label_17.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_17.setBounds(19, 288, 250, 24);
		
		Label label_18 = new Label(group_1, SWT.NONE);
		label_18.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_18.setText("16:30 | 停止入馆时间");
		label_18.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_18.setBounds(19, 319, 250, 24);
		
		Label label_19 = new Label(group_1, SWT.NONE);
		label_19.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_19.setText("17:00 | 闭馆时间");
		label_19.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		label_19.setBounds(19, 346, 250, 24);
		
		Label label_11 = new Label(composite_3, SWT.SEPARATOR | SWT.VERTICAL);
		label_11.setForeground(SWTResourceManager.getColor(0, 0, 0));
		label_11.setBounds(412, 0, 2, 620);
		
		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		composite_4.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_4.setBackgroundImage(SWTResourceManager.getImage(Dp.class, "/images/background_right.jpg"));
		
		table = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundMode(SWT.INHERIT_DEFAULT);
		table.setBounds(0, 80, 841, 315);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(169);
		tableColumn.setText("订单编号");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(176);
		tableColumn_1.setText("姓名");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(289);
		tableColumn_2.setText("身份证号码");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(295);
		tableColumn_3.setText("预约时间");
		
		Label label = new Label(composite_4, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		label.setBounds(0, 30, 141, 42);
		label.setText("我的预约");
		stackLayout.topControl = composite_3;
		sashForm.setWeights(new int[] {51, 620});
		
		year = Integer.parseInt(dateTime.getYear()+"");
		month = Integer.parseInt(dateTime.getMonth()+"")+1;
		day = Integer.parseInt(dateTime.getDay()+"");
						
		text_2.setText(year + "-" + month + "-" + day);
		
		//当日余票显示功能
		String sql = "select times from dp where times = ?";
		List< Map< String , Object >> list = db.findAll(sql, text_2.getText()+"");
		int sum = 1000 - list.size();
		lblSgffghf.setText("余票：" + sum);
		
		//切换至订票面板
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_3;
				composite_3.setVisible(true);
				composite_4.setVisible(false);
			}
		});
		
		//切换至预约管理面板
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_4;
				composite_3.setVisible(false);
				composite_4.setVisible(true);
				showdp();
			}
		});
		
		//选择预约日期
				dateTime.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					
						button.setEnabled(true);
						label_2.setText("");
						label_5.setText("");
					
						year = Integer.parseInt(dateTime.getYear()+"");
						month = Integer.parseInt(dateTime.getMonth()+"")+1;
						day = Integer.parseInt(dateTime.getDay()+"");
										
						text_2.setText(year + "-" + month + "-" + day);
						target = totalDay(year , month , day); //选择的时间距离2020年的总天数
						now = totalDay(yeart , montht , dayt); //今天的时间到2020年的总天数
					
						//控制预约时间
						if( (target - now) > 15 ){
							button.setEnabled(false);
							label_2.setText("只可预约十五天内的门票！！！");
							lblSgffghf.setText("");
							flag = false;
						}else if( (target - now) < 0 ){
							button.setEnabled(false);
							label_2.setText("不支持时光倒流！！！");
							lblSgffghf.setText("");
							flag = false;
						}else{
							//当日余票显示功能
							String sql = "select times from dp where times = ?";
							List< Map< String , Object >> list = db.findAll(sql, text_2.getText()+"");
							int sum = 1000 - list.size();
							lblSgffghf.setText("余票：" + sum);
							flag = true;
						}					
					}
				});
				
				//身份证输入框的鼠标移出事件
				text.addMouseTrackListener(new MouseTrackAdapter() {
					@Override
					public void mouseExit(MouseEvent e) {
						button.setEnabled(flag);
						label_5.setText("");
						
						userId = text.getText(); //身份证号码
						time = text_2.getText(); //时间
						
						//一个身份证号码一天只能预约一次
						String sql = "select dpid from dp where UserId = ? and times = ?";
						List< Map< String , Object >> list = db.findAll(sql, userId , time);
						if( list.size() == 1){
							button.setEnabled(false);
							label_5.setText("一个身份证号码一天只能预约一次");
						}
						
						//一个用户最多只能预订5次
						sql = "select dpid from dp where dpid = ?";
						list = db.findAll(sql, Data.mid);
						if( list.size() > 4){
							button.setEnabled(false);
							label_5.setText("同一个账号最多只能预约五次");
						}
					}
				});
				//预约按钮的鼠标移入事件
				button.addMouseTrackListener(new MouseTrackAdapter() {
					@Override
					public void mouseEnter(MouseEvent e) {
						button.setEnabled(flag);
						label_5.setText("");
						
						userId = text.getText(); //身份证号码
						time = text_2.getText(); //时间
						
						//一个身份证号码一天只能预约一次
						String sql = "select dpid from dp where UserId = ? and times = ?";
						List< Map< String , Object >> list = db.findAll(sql, userId , time);
						if( list.size() == 1){
							button.setEnabled(false);
							label_5.setText("一个身份证号码一天只能预约一次");
						}
						
						//一个用户最多只能预订5次
						sql = "select dpid from dp where dpid = ?";
						list = db.findAll(sql, Data.mid);
						if( list.size() > 4){
							button.setEnabled(false);
							label_5.setText("同一个账号最多只能预约五次");
						}
					}
				});
				
				//预约按钮的点击事件
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						button.setEnabled(flag);
						label_5.setText("");
						
						
						
						
						name = text_1.getText(); //姓名
						userId = text.getText(); //身份证号码
						time = text_2.getText(); //时间
						
						
						String sql = "insert into dp values(dp_dpbh.nextval , ? , ? , ? , ?)";
						int result = db.doUpdate(sql, Data.mid , name , userId , time);
						if( result > 0){
							mu.alterMessage(shell, "提示信息", "预约成功");
							//清空输入框
							text_1.setText("");
							text.setText("");
							//当日余票显示功能
							sql = "select times from dp where times = ?";
							List< Map< String , Object >> list = db.findAll(sql, text_2.getText()+"");
							int sum = 1000 - list.size();
							lblSgffghf.setText("余票：" + sum);
							flag = true;
						}else{
							mu.alterMessage(shell, "提示信息", "预约失败");
						}
					}
				});
				
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						//右键
						if( e.button == 3){
							Menu menu = new Menu(table);
							table.setMenu(menu);
							MenuItem mi = new MenuItem(menu , SWT.NONE);
							mi.setText("取消预约");
							
							mi.addListener(SWT.Selection, new Listener(){
							
								@Override
								public void handleEvent(Event arg0) {
									//得到选中的行
									TableItem ti = table.getSelection()[0];
									int  id = Integer.parseInt(ti.getText()+"");
									String sql = "delete from dp where dpbh = ?";
									int result = db.doUpdate(sql, id);
									if( result > 0){
										mu.alterMessage(shell, "提示信息" , "取消成功");
										showdp();
									}else{
										mu.alterMessage(shell, "提示信息" , "取消失败");
									}
								}
								
							});
						}
					}
				});

			}

			
			//返回距离指定日期的总天数
			protected int totalDay(int year , int month , int day){
				
				int sum = 0;
				//total days
				for(int i = 2020; i < year ; i ++){
				   
				   if(i % 400 == 0 || i % 4 == 0 && i % 100 != 0 ){
				    
					     sum = sum + 366;
					
				   }else{
				      
					     sum = sum + 365;
				   
				   }
				
				}
				
				boolean flag = false;
				
				if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ){
				     
					flag = true;
					 
				}
				
				int days = 0;
				for(int i = 1; i <= month; i++){
				
				  
				  if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){

		            days = 31;			
				    
				  }
				  
				  if(i == 4 || i == 6 || i == 9 || i == 11){
					
		            days = 30;			
				    
				  }
				  if(i == 2 && flag){
			       	
					days = 29;
		        
		   		 }if(i == 2 && flag == false){
				    
					days = 28;
					
				  }
			      
				 if(i != month){
				 
				    sum += days;
				 
				 }
			      
				}
				
				return sum+day;
				
			}
			//将用户所有的预约信息显示到表格
			protected void showdp(){
				table.removeAll();
				TableItem ti;
				String sql = "select * from dp where dpid = ?";
				List<Map<String , Object>> list = db.findAll(sql, Data.mid);
				
				for( int i = 0; i < list.size(); i++){
					ti = new TableItem(table , SWT.NONE);
					ti.setText(new String[] { list.get(i).get("dpbh")+"" ,
											  list.get(i).get("username")+"",
											  list.get(i).get("userid")+"",
											  list.get(i).get("times")+""});
				}
			}
		}
