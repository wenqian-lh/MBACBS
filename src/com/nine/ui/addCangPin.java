package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.myUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class addCangPin {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Label label;
	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Combo combo;
	
	private String photoFile;
	DBHelper db = new DBHelper();
	myUtil mu = new myUtil();
	private Label label_4;
	private Text text_2;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addCangPin window = new addCangPin();
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
		shell.setBackgroundImage(SWTResourceManager.getImage(addCangPin.class, "/images/background_6.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setSize(897, 656);
		shell.setText("添加藏品");
		
	    label = new Label(shell, SWT.BORDER);
		label.setBounds(19, 48, 400, 320);
		
		Button button = new Button(shell, SWT.NONE);
		
		button.setBounds(173, 399, 114, 34);
		button.setText("选择图片");
		
		label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(448, 39, 186, 34);
		label_1.setText("请输入藏品名称:");
		
		text = new Text(shell, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		text.setBounds(647, 39, 179, 30);
		
		label_2 = new Label(shell, SWT.NONE);
		label_2.setText("请选择藏品类型:");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(448, 103, 186, 34);
		
		combo = new Combo(shell, SWT.NONE);
		combo.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		combo.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		combo.setBounds(647, 100, 179, 32);
		combo.setItems(new String[] {"1-绘画" , "2-法书" , "3-碑帖" , "4-铜器" , 
									"5-金银器" , "6-漆器" , "7-珐琅器" , "8-玉石器" ,
									"9-雕塑" , "10-陶瓷" , "11-织绣" , "12-雕刻工艺"});
		combo.select(0);
		
		label_3 = new Label(shell, SWT.NONE);
		label_3.setText("请输入详细介绍:");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_3.setBounds(448, 223, 186, 34);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		text_1.setBounds(487, 263, 368, 170);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(250, 512, 97, 34);
		button_1.setText("重  置");
		
		Button button_2 = new Button(shell, SWT.NONE);
		
		button_2.setText("添   加");
		button_2.setBounds(524, 512, 97, 34);
		
		label_4 = new Label(shell, SWT.NONE);
		label_4.setText("请输入藏品年代:");
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_4.setBounds(448, 158, 186, 34);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		text_2.setBounds(647, 158, 179, 30);
		
		//添加图片
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fdl = new FileDialog(shell);
				fdl.setFilterExtensions( new String[] {"*.jpg" , "*.png"});
				fdl.open();
				
				if( fdl != null && !"".equals( fdl.getFileName())){
					photoFile = fdl.getFilterPath() + "\\" + fdl.getFileName();
					
					//显示图片
					ImageData imageData = new ImageData(photoFile);
					imageData = imageData.scaledTo(400, 320);
					Image image = new Image(null , imageData);
					label.setImage(image);
				}
			}
		});
		
		//添加到数据库
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name = text.getText(); //名字
				String type1 = combo.getText(); 
				int type =  Integer.parseInt(type1.split("-")[0]+""); //类型
				String detail = text_1.getText(); //详细信息
				String years = text_2.getText(); //年代
				
				String sql = "insert into cangpin values(cangpin_cpid.nextval,?,?,?,?,?)";
				//System.out.println(name + "-" + type + "-" +detail);
				if(name == null || type == 0 || detail == null || years == null){
					return;
				}
				try {
					BufferedInputStream bis = new BufferedInputStream( new FileInputStream(photoFile));
					byte[] b = new byte[ bis.available() ];
					bis.read(b);
					int result = db.doUpdate(sql, name, type, years, b, detail);
					if( result > 0){
						mu.alterMessage(shell, "提示信息", "添加成功");
						label.setImage(null);
						text.setText("");
						text_1.setText("");
						text_2.setText("");
					}else{
						mu.alterMessage(shell, "提示信息", "添加失败");
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
