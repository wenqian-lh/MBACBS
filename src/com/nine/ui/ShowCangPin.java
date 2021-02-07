package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;
import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;

public class ShowCangPin {

	protected Shell shell;
	private Table table;
	
	MyUtil mu = new MyUtil();
	DBHelper db = new DBHelper();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ShowCangPin window = new ShowCangPin();
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
		shell.setText("数字藏品浏览");
		shell.setLayout(new FormLayout());
		
		Composite composite = new Composite(shell, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 674);
		fd_composite.right = new FormAttachment(0, 978);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(ShowCangPin.class, "/images/background_left.jpg"));
		composite_1.setToolTipText("1");
		
		Group group = new Group(composite_1, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("楷体", 14, SWT.BOLD));
		group.setText("藏品分类");
		group.setBounds(10, 0, 141, 674);
		
		Button button = new Button(group, SWT.RADIO);
		
		button.setToolTipText("1");
		button.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button.setBounds(22, 62, 110, 24);
		button.setText("绘画");
		
		Button button_1 = new Button(group, SWT.RADIO);
		button_1.setToolTipText("2");
		button_1.setText("法书");
		button_1.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_1.setBounds(22, 104, 110, 24);
		
		Button button_2 = new Button(group, SWT.RADIO);
		button_2.setText("碑帖");
		button_2.setToolTipText("3");
		button_2.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_2.setBounds(22, 152, 110, 24);
		
		Button button_3 = new Button(group, SWT.RADIO);
		button_3.setToolTipText("4");
		button_3.setText("铜器");
		button_3.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_3.setBounds(22, 204, 110, 24);
		
		Button button_4 = new Button(group, SWT.RADIO);
		button_4.setToolTipText("5");
		button_4.setText("金银器");
		button_4.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_4.setBounds(22, 258, 110, 24);
		
		Button button_5 = new Button(group, SWT.RADIO);
		button_5.setToolTipText("6");
		button_5.setText("漆器");
		button_5.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_5.setBounds(22, 310, 110, 24);
		
		Button button_6 = new Button(group, SWT.RADIO);
		button_6.setToolTipText("7");
		button_6.setText("珐琅器");
		button_6.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_6.setBounds(22, 363, 110, 24);
		
		Button button_7 = new Button(group, SWT.RADIO);
		button_7.setToolTipText("8");
		button_7.setText("玉石器");
		button_7.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_7.setBounds(22, 416, 110, 24);
		
		Button button_8 = new Button(group, SWT.RADIO);
		button_8.setToolTipText("9");
		button_8.setText("雕塑");
		button_8.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_8.setBounds(22, 469, 110, 24);
		
		Button button_9 = new Button(group, SWT.RADIO);
		button_9.setToolTipText("10");
		button_9.setText("陶瓷");
		button_9.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_9.setBounds(22, 523, 110, 24);
		
		Button button_10 = new Button(group, SWT.RADIO);
		button_10.setToolTipText("11");
		button_10.setText("织绣");
		button_10.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_10.setBounds(22, 576, 110, 24);
		
		Button button_11 = new Button(group, SWT.RADIO);
		button_11.setToolTipText("12");
		button_11.setText("雕刻工艺");
		button_11.setFont(SWTResourceManager.getFont("黑体", 11, SWT.NORMAL));
		button_11.setBounds(22, 629, 110, 24);
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(ShowCangPin.class, "/images/background_right.jpg"));
		
		table = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundMode(SWT.INHERIT_DEFAULT);
		table.setBounds(1, 0, 823, 674);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(399);
		tblclmnNewColumn.setText("图");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(196);
		tableColumn.setText("名称");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("年代");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("文物号");
		sashForm.setWeights(new int[] {151, 824});
		
		//分类显示藏品
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
		button_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				String type = b.getToolTipText(); //获取选中按钮的提示文字
				show(type);
				System.out.println(type);
				
			}
		});
	}
	//显示藏品到表格的方法
	protected void show(String type){
		table.removeAll();
		String sql = "select p.cpid, p.cpname, p.years, p.photo from cangpin p , cptype t where t.cid = ? and p.ctype = t.cid";
		List<Map<String , Object>> list = db.findAll(sql, type);
		
		TableItem ti;
		for(int i = 0; i < list.size(); i++){
			ti = new TableItem(table,SWT.NONE);
			ByteArrayInputStream bais = new ByteArrayInputStream( (byte[]) list.get(i).get("photo")); 
			ImageData imageData = new ImageData(bais);
			imageData = imageData.scaledTo(400, 400);
			Image image = new Image(null,imageData);
			ti.setImage(0 , image);
			ti.setText(1 , list.get(i).get("cpname")+"" );
			ti.setText(2 , list.get(i).get("years")+"" );
			ti.setText(3 , list.get(i).get("cpid")+"" );
		}
	}
}
