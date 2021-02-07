package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.dao.DBHelper;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Exhibition1 {

	protected Shell shell;
	private Table table;
	private DBHelper db = new DBHelper();
	private Thread myThread;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Exhibition1 window = new Exhibition1();
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
		shell.setImage(SWTResourceManager.getImage(About.class, "/images/icon.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Exhibition1.class, "/images/background.jpg"));
		shell.setSize(1000, 730);
		shell.setText("展览");

		table = new Table(shell, SWT.FULL_SELECTION);
		table.setSelection(new int[] {0});
		table.setSelection(0);
		

		table.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		table.setBounds(5, 37, 970, 309);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setResizable(false);
		tblclmnNewColumn_1.setWidth(138);
		tblclmnNewColumn_1.setText("展览图片");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(262);
		tblclmnNewColumn_2.setResizable(false);
		tblclmnNewColumn_2.setText("展览名称");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setResizable(false);
		tblclmnNewColumn_3.setWidth(284);
		tblclmnNewColumn_3.setText("展览时间");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setResizable(false);
		tblclmnNewColumn.setWidth(291);
		tblclmnNewColumn.setText("展览地点");
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(0, 374, 300, 300);
		lblNewLabel.setText("");
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(355, 412, 400, 35);
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(355, 560, 400, 35);
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(355, 481, 400, 35);

		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		lblNewLabel_4.setBounds(783, 652, 195, 22);
		showAll();
/*		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				TableItem ti = table.getSelection()[0];
				String sql = "select * from addactivity where name = ?";
				String name = ti.getText(1);
				System.out.println(name);
				lblNewLabel.setImage(ti.getImage());
				lblNewLabel_1.setText(ti.getText(1));
				lblNewLabel_2.setText(ti.getText(2));
				lblNewLabel_3.setText(ti.getText(3));

			}
		});
		*/
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem ti = table.getSelection()[0];
				String sql = "select * from addactivity where name = ?";
				String name = ti.getText(1);
				List<Map<String , Object>> list = db.findAll(sql, name);
				ByteArrayInputStream bais = new ByteArrayInputStream( (byte[]) list.get(0).get("photo"));
				ImageData imageData = new ImageData(bais);
				imageData = imageData.scaledTo(300, 300);
				Image image = new Image(null , imageData);
				lblNewLabel.setImage( image );
				lblNewLabel_1.setText("主题  | "+ti.getText(1));
				lblNewLabel_2.setText("时间  | "+ti.getText(2));
				lblNewLabel_3.setText("地点  | "+ti.getText(3));
			}
		});
		myThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							lblNewLabel_4.setText(sdf.format(new Date()));
						}
					});
					// 睡眠
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		myThread.start();
		// 当窗口关闭的时候，触发事件
		shell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				myThread.stop();
			}
		});

	}

	private void showAll() {
		// TODO Auto-generated method stub
		table.removeAll();
		String sql = "select * from addactivity";
		List<Map<String, Object>> list = db.findAll(sql);
		TableItem ti = null;
		for (int i = 0; i < list.size(); i++) {
			ti = new TableItem(table, SWT.NONE);
			ti.setText(1, list.get(i).get("name").toString());
			ti.setText(2, list.get(i).get("time").toString());
			ti.setText(3, list.get(i).get("site").toString());
			ByteArrayInputStream bais = new ByteArrayInputStream((byte[]) list.get(i).get("photo"));
			ImageData id = new ImageData(bais);
		    id = id.scaledTo(100, 100);
			ti.setImage(0, new Image(null, id));

		}

	}
}
