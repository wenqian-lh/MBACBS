package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.DateTime;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;
import com.nine.dao.DBHelper;
import com.nine.util.Data;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.SashForm;

public class BookingTickets {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String nowDate = sdf.format( new Date());//当前时间
	
	MyUtil mu = new MyUtil();
	DBHelper db = new DBHelper();
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BookingTickets window = new BookingTickets();
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
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(BookingTickets.class, "/images/background_right.jpg"));
		shell.setSize(918, 730);
		shell.setText("预约订票");
		shell.setLayout(new FormLayout());
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.CALENDAR);
		FormData fd_dateTime = new FormData();
		fd_dateTime.bottom = new FormAttachment(0, 280);
		fd_dateTime.right = new FormAttachment(0, 577);
		fd_dateTime.top = new FormAttachment(0, 10);
		fd_dateTime.left = new FormAttachment(0, 235);
		dateTime.setLayoutData(fd_dateTime);
		
		Button button = new Button(shell, SWT.NONE);
		FormData fd_button = new FormData();
		fd_button.right = new FormAttachment(0, 428);
		fd_button.top = new FormAttachment(0, 631);
		fd_button.left = new FormAttachment(0, 314);
		button.setLayoutData(fd_button);
		
		
		button.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button.setText("预  约");
		
		Label label_1 = new Label(shell, SWT.NONE);
		FormData fd_label_1 = new FormData();
		fd_label_1.bottom = new FormAttachment(0, 438);
		fd_label_1.right = new FormAttachment(0, 351);
		fd_label_1.top = new FormAttachment(0, 413);
		fd_label_1.left = new FormAttachment(0, 230);
		label_1.setLayoutData(fd_label_1);
		label_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		label_1.setText("请输入姓名:");
		
		text = new Text(shell, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.bottom = new FormAttachment(0, 487);
		fd_text.right = new FormAttachment(0, 572);
		fd_text.top = new FormAttachment(0, 452);
		fd_text.left = new FormAttachment(0, 272);
		text.setLayoutData(fd_text);
		text.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		
		Label label_2 = new Label(shell, SWT.NONE);
		FormData fd_label_2 = new FormData();
		fd_label_2.bottom = new FormAttachment(0, 541);
		fd_label_2.right = new FormAttachment(0, 406);
		fd_label_2.top = new FormAttachment(0, 516);
		fd_label_2.left = new FormAttachment(0, 230);
		label_2.setLayoutData(fd_label_2);
		label_2.setText("请输入身份证号码:");
		label_2.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		
		text_1 = new Text(shell, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.bottom = new FormAttachment(0, 593);
		fd_text_1.right = new FormAttachment(0, 572);
		fd_text_1.top = new FormAttachment(0, 558);
		fd_text_1.left = new FormAttachment(0, 272);
		text_1.setLayoutData(fd_text_1);
		
		text_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		
		Label label_3 = new Label(shell, SWT.NONE);
		FormData fd_label_3 = new FormData();
		fd_label_3.bottom = new FormAttachment(0, 336);
		fd_label_3.right = new FormAttachment(0, 401);
		fd_label_3.top = new FormAttachment(0, 311);
		fd_label_3.left = new FormAttachment(0, 225);
		label_3.setLayoutData(fd_label_3);
		label_3.setText("请选择:预约日期：");
		label_3.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		
		text_2 = new Text(shell, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.bottom = new FormAttachment(0, 388);
		fd_text_2.right = new FormAttachment(0, 572);
		fd_text_2.top = new FormAttachment(0, 353);
		fd_text_2.left = new FormAttachment(0, 272);
		text_2.setLayoutData(fd_text_2);
		text_2.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		text_2.setText(nowDate);
		
		Label label = new Label(shell, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.right = new FormAttachment(0, 347);
		fd_label.top = new FormAttachment(0, 389);
		fd_label.left = new FormAttachment(0, 91);
		label.setLayoutData(fd_label);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		Label label_4 = new Label(shell, SWT.NONE);
		FormData fd_label_4 = new FormData();
		fd_label_4.right = new FormAttachment(0, 345);
		fd_label_4.top = new FormAttachment(0, 594);
		fd_label_4.left = new FormAttachment(0, 47);
		label_4.setLayoutData(fd_label_4);
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		Label label_10 = new Label(shell, SWT.NONE);
		FormData fd_label_10 = new FormData();
		fd_label_10.bottom = new FormAttachment(0, 315);
		fd_label_10.right = new FormAttachment(0, 577);
		fd_label_10.top = new FormAttachment(0, 281);
		fd_label_10.left = new FormAttachment(0, 419);
		label_10.setLayoutData(fd_label_10);
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label_10.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		int yeart = Integer.parseInt(nowDate.substring(0, 4));
		int montht = Integer.parseInt(nowDate.substring(5, 7));
		int dayt = Integer.parseInt(nowDate.substring(8, 10));
		
		//当日余票显示功能
		String sql = "select times from dp where times = ?";
		List< Map< String , Object >> list = db.findAll(sql, text_2.getText()+"");
		int sum = 1000 - list.size();
		label_10.setText("余票：" + sum);
		
		Label label_11 = new Label(shell, SWT.WRAP);
		FormData fd_label_11 = new FormData();
		fd_label_11.bottom = new FormAttachment(0, 552);
		fd_label_11.right = new FormAttachment(0, 767);
		fd_label_11.top = new FormAttachment(0, 226);
		fd_label_11.left = new FormAttachment(0, 674);
		label_11.setLayoutData(fd_label_11);
		label_11.setFont(SWTResourceManager.getFont("华文新魏", 40, SWT.BOLD));
		label_11.setText("疫情防控");
		
		Label label_12 = new Label(shell, SWT.WRAP);
		FormData fd_label_12 = new FormData();
		fd_label_12.bottom = new FormAttachment(0, 668);
		fd_label_12.right = new FormAttachment(0, 893);
		fd_label_12.top = new FormAttachment(0, 323);
		fd_label_12.left = new FormAttachment(0, 814);
		label_12.setLayoutData(fd_label_12);
		label_12.setText("人人有责");
		label_12.setFont(SWTResourceManager.getFont("华文新魏", 40, SWT.BOLD));
		
		Group group = new Group(shell, SWT.NONE);
		FormData fd_group = new FormData();
		fd_group.bottom = new FormAttachment(0, 199);
		fd_group.right = new FormAttachment(0, 889);
		fd_group.top = new FormAttachment(0, 10);
		fd_group.left = new FormAttachment(0, 607);
		group.setLayoutData(fd_group);
		group.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		group.setFont(SWTResourceManager.getFont("楷体", 20, SWT.BOLD));
		group.setText("公告栏");
		
		Label label_6 = new Label(group, SWT.WRAP);
		label_6.setLocation(26, 60);
		label_6.setSize(270, 133);
		label_6.setText("    博物院瞬时接待游客数调整为不得超过最大承载量的百分之三十。");
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		label_6.setFont(SWTResourceManager.getFont("楷体", 15, SWT.BOLD));
		
		//选择预约日期
		dateTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				button.setEnabled(true);
				label.setText("");
				label_4.setText("");
				
				//当日余票显示功能
				String sql = "select times from dp where times = ?";
				List< Map< String , Object >> list = db.findAll(sql, text_2.getText()+"");
				int sum = 1000 - list.size();
				label_10.setText("余票：" + sum);
				
				int year = Integer.parseInt(dateTime.getYear()+"");
				int month = Integer.parseInt(dateTime.getMonth()+"")+1;
				int day = Integer.parseInt(dateTime.getDay()+"");
								
				text_2.setText(year + "-" + month + "-" + day);
				int target = totalDay(year , month , day); //选择的时间距离2020年的总天数
				int now = totalDay(yeart , montht , dayt); //今天的时间到2020年的总天数
				//控制预约时间
				if( (target - now) > 15 ){
					button.setEnabled(false);
					label.setText("只可预约十五天内的门票！！！");
					
					//当日余票显示功能
					String sql2 = "select times from dp where times = ?";
					list = db.findAll(sql2, text_2.getText()+"");
					sum = 1000 - list.size();
					label_10.setText("余票：" + sum);
				}
				
				
				
				
				
				
				
			}
		});
		
		//身份证输入框的鼠标移出事件
		text_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseExit(MouseEvent e) {
				button.setEnabled(true);
				label_4.setText("");
				
				String userId = text_1.getText(); //身份证号码
				String time = text_2.getText(); //时间
				
				//一个身份证号码一天只能预约一次
				String sql2 = "select dpid from dp where UserId = ? and times = ?";
				List< Map< String , Object >> list = db.findAll(sql2, userId , time);
				if( list.size() == 1){
					button.setEnabled(false);
					label_4.setText("一个身份证号码一天只能预约一次");
				}
				
				//一个用户最多只能预订5次
				String sql1 = "select dpid from dp where dpid = ?";
				list = db.findAll(sql1, Data.mid);
				if( list.size() > 4){
					button.setEnabled(false);
					label_4.setText("同一个账号最多只能预约五次");
				}
			}
		});
		//预约按钮的鼠标移入事件
		button.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				//一个用户最多只能预订5次
				String sql1 = "select dpid from dp where dpid = ?";
				List< Map< String , Object >> list = db.findAll(sql1, Data.mid);
				if( list.size() > 4){
					button.setEnabled(false);
					label_4.setText("同一个账号最多只能预约五次");
				}
			}
		});
		
		//预约按钮的点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				button.setEnabled(true);
				label_4.setText("");
				
				
				
				
				String name = text.getText(); //姓名
				String userId = text_1.getText(); //身份证号码
				String time = text_2.getText(); //时间
				
				
				String sql = "insert into dp values(? , ? , ? , ?)";
				int result = db.doUpdate(sql, Data.mid , name , userId , time);
				if( result > 0){
					mu.alterMessage(shell, "提示信息", "预约成功");
				}else{
					mu.alterMessage(shell, "提示信息", "预约失败");
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
}
