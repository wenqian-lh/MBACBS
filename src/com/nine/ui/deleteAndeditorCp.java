package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class deleteAndeditorCp {

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
	private Button button_4;
	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			deleteAndeditorCp window = new deleteAndeditorCp();
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
		shell.setSize(943, 673);
		shell.setText("编辑和删减藏品");
		
	    label = new Label(shell, SWT.BORDER);
		label.setBounds(19, 48, 400, 320);
		
		Button button = new Button(shell, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		
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
		
		label_3 = new Label(shell, SWT.NONE | SWT.WRAP);
		label_3.setText("请输入详细介绍:");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_3.setBounds(448, 223, 186, 34);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		text_1.setBounds(487, 263, 368, 170);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_1.setSelection(true);
		
		button_1.setBounds(173, 512, 97, 34);
		button_1.setText("删 除");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		
		button_2.setText("修 改");
		button_2.setBounds(631, 512, 97, 34);
		
		label_4 = new Label(shell, SWT.NONE);
		label_4.setText("请输入藏品年代:");
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_4.setBounds(448, 158, 186, 34);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		text_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		text_2.setBounds(647, 158, 179, 30);
		
		Button button_3 = new Button(shell, SWT.NONE);
		
		button_3.setBounds(841, 37, 80, 34);
		button_3.setText("查询");
		
		button_4 = new Button(shell, SWT.NONE);
		button_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		
		button_4.setBounds(405, 512, 114, 34);
		button_4.setText("编 辑");
		
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
						int type =  Integer.parseInt(type1.charAt(0)+""); //类型
						String detail = text_1.getText(); //详细信息
						String years = text_2.getText(); //年代
						String sql = "update cangpin set cpname = ? , ctype = ? , years = ? , photo = ? , detail = ? where cpname = ?";
						int result;
						if(name == null || type == 0 || detail == null || years == null){
							return;
						}
						try {
							if( photoFile == null){ //如果图片没有更换
								String sql1 = "update cangpin set cpname = ? , ctype = ? , years = ? , detail = ? where cpname = ?";	
								result = db.doUpdate(sql1, name, type, years, detail, name);
							}else{
								BufferedInputStream bis = new BufferedInputStream( new FileInputStream(photoFile));
								byte[] b = new byte[ bis.available() ];
								bis.read(b);
								result = db.doUpdate(sql, name, type, years, b, detail, name);
							}
						
							if( result > 0){
								mu.alterMessage(shell, "提示信息", "修改成功");
								label.setImage(null);
								text.setText("");
								text_1.setText("");
								text_2.setText("");
							}else{
								mu.alterMessage(shell, "提示信息", "修改失败");
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
		
		//根据藏品名称查询藏品
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name = text.getText();
				if( name == null){
					button_3.setEnabled(false);
				}
				String sql = "select * from cangpin where cpname = ?";
				List<Map<String , Object>> list = db.findAll(sql, name);
				
				ByteArrayInputStream bais = new ByteArrayInputStream( (byte[]) list.get(0).get("photo"));
				ImageData imageData = new ImageData( bais );
				imageData = imageData.scaledTo(400, 320);
				Image image = new Image(null , imageData);
				label.setImage(image);
				
				combo.select( Integer.parseInt( list.get(0).get("ctype")+"")-1);
				text_2.setText(list.get(0).get("years")+"");
				text_1.setText(list.get(0).get("detail")+"");
				
				//禁用选择图片按钮和输入框
				button.setEnabled(false);
				text.setEnabled(false);
				combo.setEnabled(false);
				text_1.setEnabled(false);
				text_2.setEnabled(false);
			}
			
		});
		
		//编辑按钮
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//启用选择图片按钮和输入框
				button.setEnabled(true);
				text.setEnabled(true);
				combo.setEnabled(true);
				text_1.setEnabled(true);
				text_2.setEnabled(true);
			}
		});
		
		//删除藏品
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String sql = "delete from cangpin where cpname = ? ";
				String name = text.getText();
				int result = db.doUpdate(sql, name);
				if( result > 0){
					mu.alterMessage(shell, "提示信息", "删除成功");
					label.setImage(null);
					text.setText("");
					text_1.setText("");
					text_2.setText("");
				}else{
					mu.alterMessage(shell, "提示信息", "删除失败");
				}
			}
		});

	}
}
