package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class guanliyuan {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			guanliyuan window = new guanliyuan();
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
		shell.setSize(761, 649);
		shell.setImage(SWTResourceManager.getImage(about.class, "/images/icon.jpg"));
		shell.setText("超级管理员");
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(guanliyuan.class, "/images/background.jpg"));
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(composite, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(guanliyuan.class, "/images/background_left.jpg"));
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		
		
		
		
		Tree tree = new Tree(composite_1, SWT.NONE);
		tree.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		tree.setBackgroundImage(SWTResourceManager.getImage(guanliyuan.class, "/images/background_6.jpg"));
		
		TreeItem treeItem = new TreeItem(tree, 0);
		treeItem.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		treeItem.setText("首页管理");
		treeItem.setFont(SWTResourceManager.getFont("黑体", 14, SWT.BOLD));
		
		TreeItem treeItem_1 = new TreeItem(treeItem, 0);
		treeItem_1.setText("添加公告");
		treeItem_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		treeItem_1.setExpanded(true);
		
		TreeItem treeItem_2 = new TreeItem(treeItem, 0);
		treeItem_2.setText("添加诗词");
		treeItem_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		treeItem_2.setExpanded(true);
		
		TreeItem treeItem_6 = new TreeItem(treeItem, 0);
		treeItem_6.setText("删除公告");
		treeItem_6.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		treeItem_6.setExpanded(true);
		
		TreeItem treeItem_7 = new TreeItem(treeItem, 0);
		treeItem_7.setText("删除诗词");
		treeItem_7.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		treeItem_7.setExpanded(true);
		treeItem.setExpanded(true);
		
		TreeItem trtmNewTreeitem = new TreeItem(tree, SWT.NONE);
		trtmNewTreeitem.setFont(SWTResourceManager.getFont("黑体", 14, SWT.BOLD));
		trtmNewTreeitem.setText("藏品管理");
		
		TreeItem trtmNewTreeitem_1 = new TreeItem(trtmNewTreeitem, SWT.NONE);
		trtmNewTreeitem_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		trtmNewTreeitem_1.setText("添加藏品");
		trtmNewTreeitem_1.setExpanded(true);
		
		TreeItem trtmNewTreeitem_2 = new TreeItem(trtmNewTreeitem, SWT.NONE);
		trtmNewTreeitem_2.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		trtmNewTreeitem_2.setText("修改和删减藏品");
		trtmNewTreeitem.setExpanded(true);
		
		TreeItem trtmNewTreeitem_4 = new TreeItem(tree, SWT.NONE);
		trtmNewTreeitem_4.setFont(SWTResourceManager.getFont("黑体", 13, SWT.BOLD));
		trtmNewTreeitem_4.setText("展览管理");
		
		TreeItem trtmNewTreeitem_5 = new TreeItem(trtmNewTreeitem_4, SWT.NONE);
		trtmNewTreeitem_5.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		trtmNewTreeitem_5.setText("添加展览");
		
		TreeItem trtmNewTreeitem_6 = new TreeItem(trtmNewTreeitem_4, SWT.NONE);
		trtmNewTreeitem_6.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		trtmNewTreeitem_6.setText("修改和删减展览");
		trtmNewTreeitem_4.setExpanded(true);
		
		TreeItem treeItem_3 = new TreeItem(tree, SWT.NONE);
		treeItem_3.setFont(SWTResourceManager.getFont("黑体", 13, SWT.BOLD));
		treeItem_3.setText("管理员账号管理");
		
		TreeItem treeItem_4 = new TreeItem(treeItem_3, SWT.NONE);
		treeItem_4.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		treeItem_4.setText("添加管理员");
		
		TreeItem treeItem_5 = new TreeItem(treeItem_3, SWT.NONE);
		treeItem_5.setFont(SWTResourceManager.getFont("黑体", 10, SWT.BOLD));
		treeItem_5.setText("删除管理员");
		treeItem_3.setExpanded(true);
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(guanliyuan.class, "/images/background_6.jpg"));
		
		Label label = new Label(composite_2, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label.setFont(SWTResourceManager.getFont("楷体", 25, SWT.BOLD));
		label.setBounds(10, 115, 241, 55);
		label.setText("欢迎进入：");
		
		Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		label_1.setText("管理员系统");
		label_1.setFont(SWTResourceManager.getFont("楷体", 25, SWT.BOLD));
		label_1.setBounds(78, 191, 270, 55);
		
		Label lblFsdf = new Label(composite_2, SWT.NONE);
		lblFsdf.setText("");
		lblFsdf.setFont(SWTResourceManager.getFont("微软雅黑", 11, SWT.BOLD));
		lblFsdf.setBounds(261, 409, 241, 35);
		
		Label label_2 = new Label(composite_2, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		label_2.setText("请在左侧自选操作");
		label_2.setFont(SWTResourceManager.getFont("楷体", 25, SWT.BOLD));
		label_2.setBounds(78, 252, 408, 55);
		sashForm.setWeights(new int[] {230, 506});
		
		//树的点击事件
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem ti  = (TreeItem) e.item;
				if( ti.getText().equals("添加公告") ){
					addGG gg = new addGG();
					gg.open();
				}else if( ti.getText().equals("添加诗词") ){
					addShang shang = new addShang();
					shang.open();
				}else if( ti.getText().equals("删除公告") ){
					Dropgg dp = new Dropgg();
					dp.open();
				}else if( ti.getText().equals("删除诗词") ){
					deletepoem dep = new deletepoem();
					dep.open();
				}else if( ti.getText().equals("添加藏品") ){
					addCangPin acp = new addCangPin();
					acp.open();
				}else if( ti.getText().equals("修改和删减藏品") ){
					deleteAndeditorCp dae = new deleteAndeditorCp();
					dae.open();
				}else if( ti.getText().equals("添加展览") ){
					addactivity aa = new addactivity();
					aa.open();
				}else if( ti.getText().equals("修改和删减展览") ){
					deleteAndeditorExhibition de = new deleteAndeditorExhibition();
					de.open();
				}else if( ti.getText().equals("添加管理员") ){
					addguanliyuan agly = new addguanliyuan();
					agly.open();
				}else if( ti.getText().equals("删除管理员") ){
					deleteguanliyuan dgly = new deleteguanliyuan();
					dgly.open();
				}
				
			}
		});
		}
}
