package com.nine.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import com.nine.util.MyUtil;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class About {

	protected Shell shell;
	MyUtil mu = new MyUtil();
	private StackLayout stackLayout = new StackLayout();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			About window = new About();
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
		shell.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setSize(878, 752);
		shell.setText("关于");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(composite, SWT.NONE);

		Composite composite_2 = new Composite(sashForm, SWT.NONE);

		composite_2.setBackgroundImage(SWTResourceManager.getImage(About.class, "/images/background.jpg"));
		mu.windowMove(composite_2, shell);

		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setBounds(0, 105, 568, 600);

		Label lblNewLabel_8 = new Label(composite_3, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_8.setBounds(10, 132, 102, 27);
		lblNewLabel_8.setText("小明");

		Label lblNewLabel_9 = new Label(composite_3, SWT.NONE);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_9.setBounds(10, 180, 76, 20);
		lblNewLabel_9.setText("院长");

		Label lblNewLabel_10 = new Label(composite_3, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_10.setBounds(10, 225, 550, 437);
		lblNewLabel_10.setText(
				"　小明，男，汉族，1967年出生，甘肃人.\r\n\r\n    2003年加入中国共产党，1990年参加工\r\n作。2002年毕业于A大学资源与A学院地质\r\n工程专业，研究生学历，工学博士，研究馆员。\r\n\r\n   1991年到A研究院工作，历任A研究院保护\r\n研究所副所长，A研究院院长助理，保护研究\r\n所所长。2005年1月任A研究院副院长。2011\r\n年5月任A研究院常务副院长、党委副书记。20\r\n13年11月任A研究院党委书记、常务副院长。20\r\n14年12月任A研究院院长、党委书记。2019年4\r\n月至今任文化和旅游部党组成员、博物院院长.\r\n　主要从事石窟、古代壁画和土遗址保护，文化遗\r\n产监测预警与预防性保护等方面的研究。");

		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		composite_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		composite_4.setBounds(0, 0, 64, 64);

		Label lblNewLabel = new Label(composite_4, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 128, 88, 20);
		lblNewLabel.setText("小江");

		Label lblNewLabel_11 = new Label(composite_4, SWT.NONE);
		lblNewLabel_11.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_11.setBounds(10, 189, 76, 20);
		lblNewLabel_11.setText("副院长");

		Label lblNewLabel_12 = new Label(composite_4, SWT.NONE);
		lblNewLabel_12.setText(
				"   小江，男，汉族，1966年，籍贯安徽，1993年12月\r\n加入中国共产党，1989年7月毕业于A学院隧道与地下\r\n工程专业，大学本科学历，工学学士，1989年7月参加\r\n工作，高级工程师。\r\n    1989年7月至2003年7月先后任铁道部第十六局技术\r\n员、助理工程师、工程师、高级工程师、副科长，A集团\r\n第六工程有限公司总经理、副董事长、副书记等职；200\r\n3年7月至2008年12月任文化部计划财务司副司长；2008\r\n年12月至2009年2月任文化部财务司副司长；2009年2月\r\n至2012年10月任A博物馆副馆长；2012年10月至2018年\r\n3月任文化部办公厅副主任、机关服务中心主任；A国际传\r\n媒有限公司董事长、A会展有限公司董事长；2019年4月至\r\n今任博物院副院长。\r\n\r\n　　曾发表论文数十篇、参加项目获得国家科技进步二等奖，多次获得省部级科研奖励。\r\n\r\n");
		lblNewLabel_12.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_12.setBounds(10, 254, 550, 414);

		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		composite_5.setBounds(0, 0, 64, 64);

		Label lblNewLabel_13 = new Label(composite_5, SWT.NONE);
		lblNewLabel_13.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_13.setBounds(10, 124, 76, 20);
		lblNewLabel_13.setText("小伟");

		Label lblNewLabel_14 = new Label(composite_5, SWT.NONE);
		lblNewLabel_14.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_14.setBounds(10, 174, 76, 20);
		lblNewLabel_14.setText("副院长");

		Label lblNewLabel_16 = new Label(composite_5, SWT.NONE);
		lblNewLabel_16.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_16.setBounds(10, 226, 528, 441);
		lblNewLabel_16.setText(
				"  小伟，男，1971年出生，北京市人，中共党员，\r\n\r\n  大学本科学历，历史学学士学位，2000至2002\r\n年在A艺术学系进修研究生课程，研究馆员。19\r\n94年参加工作，1993年8月至2001年4月在博物\r\n院保管部、古书画部工作，2001年4月任院办公\r\n室业务协调科科长，2004年2月至2008年2月任\r\n文物管理处副处长，2008年任文物管理处处长，\r\n2012年10月任博物院院长助理，2014年被文化\r\n部任命为博物院副院长。\r\n\r\n  曾先后被评为“文化部青年岗位能手”、“文化部\r\n优秀青年”，文化部青年联合会第二届委员。\r\n");

		Composite composite_6 = new Composite(composite_2, SWT.NONE);
		composite_6.setBounds(0, 0, 64, 64);

		Label lblNewLabel_15 = new Label(composite_6, SWT.NONE);
		lblNewLabel_15.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_15.setBounds(10, 127, 76, 20);
		lblNewLabel_15.setText("小平");

		Label lblNewLabel_17 = new Label(composite_6, SWT.NONE);
		lblNewLabel_17.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_17.setBounds(10, 177, 76, 20);
		lblNewLabel_17.setText("副院长");

		Label lblNewLabel_18 = new Label(composite_6, SWT.NONE);
		lblNewLabel_18.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_18.setBounds(10, 236, 560, 357);
		lblNewLabel_18.setText(
				"  小平，女，汉族，1965年出生，黑龙江省，中共党员，\r\n研究馆员。\r\n\r\n  1990年毕业于A大学历史专业，获硕士学位，1990年来\r\n博物院参加工作。2002年8月任宫廷部原状陈列组组长，2\r\n007年任宫廷部副主任，2010年7月任古器物部副主任，20\r\n12年3月任器物部主任；兼任博物院学术委员会委员，宫廷\r\n历史研究所副所长，2015年任博物院副院长。\r\n\r\n  主要从事清代政治制度与礼俗研究，尤其对具有集大成特\r\n点的清代宫廷礼制与习俗有比较深入的思考，采用文献、档\r\n案、文物三重证据法，不断探讨其渊源与流变。");

		Composite composite_7 = new Composite(composite_2, SWT.NONE);
		composite_7.setBounds(0, 0, 64, 64);

		Label lblNewLabel_19 = new Label(composite_7, SWT.NONE);
		lblNewLabel_19.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_19.setBounds(10, 117, 76, 20);
		lblNewLabel_19.setText("小文");

		Label lblNewLabel_20 = new Label(composite_7, SWT.NONE);
		lblNewLabel_20.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_20.setBounds(10, 171, 76, 20);
		lblNewLabel_20.setText("副院长");

		Label lblNewLabel_21 = new Label(composite_7, SWT.NONE);
		lblNewLabel_21.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_21.setBounds(10, 222, 550, 403);
		lblNewLabel_21.setText(
				"  小文，女，汉族，1971年10月出生，陕西省，中\r\n共党员，研究馆员。\r\n\r\n 1998年毕业于A大学历史学系，研究生学历，硕士\r\n学位。1997年起参加工作，1998年7月到博物院办\r\n公室参加工作，2004年3月至2006年1月任秘书科\r\n科长，2006年任院办公室副主任兼秘书科科长，2\r\n012年任院办公室主任，2017年由文化部党组任命\r\n为博物院纪委书记，2020年起任博物院副院长。");

		Composite composite_8 = new Composite(composite_2, SWT.NONE);
		composite_8.setBounds(0, 0, 64, 64);

		Label lblNewLabel_22 = new Label(composite_8, SWT.NONE);
		lblNewLabel_22.setText("小英");
		lblNewLabel_22.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_22.setBounds(10, 120, 76, 20);

		Label lblNewLabel_23 = new Label(composite_8, SWT.NONE);
		lblNewLabel_23.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_23.setBounds(10, 171, 76, 20);
		lblNewLabel_23.setText("副院长");

		Label lblNewLabel_24 = new Label(composite_8, SWT.NONE);
		lblNewLabel_24.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_24.setBounds(10, 207, 550, 441);
		lblNewLabel_24.setText(
				"  小英，女，1963年生，汉族，祖籍山西，群众，编审。\r\n1980年，A大学历史系文物博物馆学专业学习，获历史\r\n学学士、硕士学位。2000年，B学院美术史专业学习，\r\n获文学博士学位。\r\n 1987年参加工作，1987年7月在A出版社古典美术编辑\r\n室工作，2004年在B出版社、出版部工作，2006年1月任\r\n出版社副总编辑，期间兼任该社书画编辑室主任，2010年\r\n任出版社总编辑，2013年任出版部主任兼出版社总编辑，\r\n2017年2月任研究室主任，博物院学术委员会委员、学会副\r\n会长。2018年至今任博物院副院长。");

		Composite composite_9 = new Composite(composite_2, SWT.NONE);
		composite_9.setBounds(0, 0, 64, 64);

		Label lblNewLabel_25 = new Label(composite_9, SWT.NONE);
		lblNewLabel_25.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_25.setBounds(20, 128, 76, 20);
		lblNewLabel_25.setText("小斌");

		Label lblNewLabel_26 = new Label(composite_9, SWT.NONE);
		lblNewLabel_26.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_26.setBounds(20, 184, 76, 20);
		lblNewLabel_26.setText("副院长");

		Label lblNewLabel_27 = new Label(composite_9, SWT.NONE);
		lblNewLabel_27.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_27.setBounds(20, 236, 540, 416);
		lblNewLabel_27.setText(
				"  小斌，男， 1962年出生，汉族，籍贯山西，中共党员，\r\n研究生毕业，副研究馆员。\r\n  1980年参加工作，1980年至1983年在部队某部服役，\r\n1983年至1992年先后在博物院人事处和团委工作，1987\r\n年任团委干事，1988年任团委书记，1992年起任博物\r\n院群众工作部副主任，1998年至2005年任博物院展览\r\n宣教部主任，2005年2月至2018年11月任博物院宣传\r\n教育部主任，2018年11月至今任博物院副院长。\r\n\r\n  多年以来一直从事博物馆宣传教育工作，主要研究方向为\r\n博物馆宣传教育，发表学术论文数篇。");

		Composite composite_10 = new Composite(composite_2, SWT.NONE);
		composite_10.setBounds(0, 0, 64, 64);

		Label lblNewLabel_28 = new Label(composite_10, SWT.NONE);
		lblNewLabel_28.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_28.setBounds(10, 114, 76, 20);
		lblNewLabel_28.setText("小王");

		Label lblNewLabel_29 = new Label(composite_10, SWT.NONE);
		lblNewLabel_29.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_29.setBounds(10, 158, 76, 20);
		lblNewLabel_29.setText("副院长");

		Label lblNewLabel_30 = new Label(composite_10, SWT.NONE);
		lblNewLabel_30.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_30.setBounds(10, 214, 521, 422);
		lblNewLabel_30.setText(
				" 小王，男，汉族，1969年出生，籍贯北京，群众，研究馆员。\r\n\r\n  1991年毕业于A学院美术史论系，获文学学士学位，同年至\r\n博物院参加工作。1991年8月至1998年4月在博物院原陈列\r\n部任职，1998年至2020年在宫廷部任职，先后担任宗教文\r\n物组副组长、宫廷部副主任、宫廷部主任等职。2020年4月\r\n任博物院副院长。\r\n\r\n   参加工作以来，主要从事宫廷文物的保管、整理、研究，以\r\n及各类展览的组织策划工作。");
		composite_2.setLayout(stackLayout);

		Composite composite_11 = new Composite(composite_2, SWT.NONE);

		Label lblNewLabel_33 = new Label(composite_11, SWT.NONE);
		lblNewLabel_33.setBackgroundImage(SWTResourceManager.getImage(About.class, "/images/IMG_20200822_131723.jpg"));
		lblNewLabel_33.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_33.setBounds(24, 113, 456, 262);

		Label lblNewLabel_34 = new Label(composite_11, SWT.NONE);
		lblNewLabel_34.setText(
				"是一座特殊的博物馆\r\n成立于1925年的博物院，建立在明清两朝皇宫\r\n\r\n历经六百年兴衰荣辱，帝王宫殿的大门终于向公众敞开。\r\n不仅一如既往精心保管着明清时代遗留下来的皇家宫殿\r\n和旧藏珍宝，而且通过国家调拨、向社会征集和接受私\r\n人捐赠等方式，极大地丰富了文物藏品，形成古书画、\r\n古器物、宫廷文物、书籍档案等领域蔚成系列、总数\r\n186万余件的珍贵馆藏。");
		lblNewLabel_34.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_34.setBounds(10, 402, 550, 274);

		Composite composite_12 = new Composite(composite_2, SWT.NONE);
		composite_12.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));

		Label lblNewLabel_37 = new Label(composite_12, SWT.NONE);
		lblNewLabel_37.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_37.setBounds(38, 127, 76, 20);
		lblNewLabel_37.setText("07/25   ");

		Label lblNewLabel_38 = new Label(composite_12, SWT.NONE);
		lblNewLabel_38.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_38.setBounds(173, 127, 140, 20);
		lblNewLabel_38.setText("养心殿改革");

		Label lblNewLabel_39 = new Label(composite_12, SWT.NONE);
		lblNewLabel_39.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_39.setBounds(38, 180, 76, 20);
		lblNewLabel_39.setText("03/10");

		Label lblNewLabel_40 = new Label(composite_12, SWT.NONE);
		lblNewLabel_40.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_40.setBounds(173, 180, 168, 20);
		lblNewLabel_40.setText("谈历史与文化语境");

		Label lblNewLabel_41 = new Label(composite_12, SWT.NONE);
		lblNewLabel_41.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_41.setBounds(38, 238, 76, 20);
		lblNewLabel_41.setText("01/25");

		Label lblNewLabel_42 = new Label(composite_12, SWT.NONE);
		lblNewLabel_42.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_42.setBounds(173, 238, 196, 20);
		lblNewLabel_42.setText("《华山图》与现象学");

		Label lblNewLabel_43 = new Label(composite_12, SWT.NONE);
		lblNewLabel_43.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_43.setBounds(38, 299, 76, 20);
		lblNewLabel_43.setText("01/17");

		Label lblNewLabel_44 = new Label(composite_12, SWT.NONE);
		lblNewLabel_44.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_44.setBounds(173, 299, 228, 20);
		lblNewLabel_44.setText("再读《重屏会棋图》");

		Label lblNewLabel_45 = new Label(composite_12, SWT.NONE);
		lblNewLabel_45.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_45.setBounds(38, 355, 76, 20);
		lblNewLabel_45.setText("01/06");

		Label lblNewLabel_46 = new Label(composite_12, SWT.NONE);
		lblNewLabel_46.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_46.setBounds(173, 355, 228, 20);
		lblNewLabel_46.setText("玉器的五千年历史");

		Label lblNewLabel_47 = new Label(composite_12, SWT.NONE);
		lblNewLabel_47.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		lblNewLabel_47.setBounds(38, 405, 373, 273);
		lblNewLabel_47.setText(
				"当前，博物院的研究人员正在对古建筑、院藏文物、\r\n\r\n宫廷历史文化遗存、明清档案、清宫典籍和近百年\r\n\r\n的博物院历程进行着更为深入细致的研究。意在向\r\n\r\n您揭示其中蕴涵的博大精深的中华民族智慧和文化\r\n\r\n精神。");
		
				Composite composite_1 = new Composite(sashForm, SWT.NONE);
				composite_1.setBackgroundImage(SWTResourceManager.getImage(About.class, "/images/background.jpg"));
				composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
				
						SashForm sashForm_1 = new SashForm(composite_1, SWT.NONE);
						sashForm_1.setOrientation(SWT.VERTICAL);
						
								Composite composite_13 = new Composite(sashForm_1, SWT.NONE);
								composite_13.setLayout(new FillLayout(SWT.HORIZONTAL));
								
										Tree tree = new Tree(composite_13, SWT.BORDER);
										
												TreeItem trtmNewTreeitem = new TreeItem(tree, SWT.NONE);
												trtmNewTreeitem.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
												trtmNewTreeitem.setText("馆内人员简介");
												
														TreeItem trtmNewTreeitem_1 = new TreeItem(trtmNewTreeitem, SWT.NONE);
														trtmNewTreeitem_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
														trtmNewTreeitem_1.setText("小明.馆长");
														
																TreeItem trtmNewTreeitem_2 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																trtmNewTreeitem_2.setText("小伟.副馆长");
																trtmNewTreeitem_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																
																		TreeItem trtmNewTreeitem_3 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																		trtmNewTreeitem_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																		trtmNewTreeitem_3.setText("小江.副馆长");
																		
																				TreeItem trtmNewTreeitem_4 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																				trtmNewTreeitem_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																				trtmNewTreeitem_4.setText("小平.副馆长");
																				
																						TreeItem trtmNewTreeitem_5 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																						trtmNewTreeitem_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																						trtmNewTreeitem_5.setText("小文.副馆长");
																						
																								TreeItem trtmNewTreeitem_6 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																								trtmNewTreeitem_6.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																								trtmNewTreeitem_6.setText("小英.副馆长");
																								
																										TreeItem trtmNewTreeitem_7 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																										trtmNewTreeitem_7.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																										trtmNewTreeitem_7.setText("小斌.副馆长");
																										
																												TreeItem trtmNewTreeitem_8 = new TreeItem(trtmNewTreeitem, SWT.NONE);
																												trtmNewTreeitem_8.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																												trtmNewTreeitem_8.setText("小王.副馆长");
																												trtmNewTreeitem.setExpanded(true);
																												
																														Composite composite_14 = new Composite(sashForm_1, SWT.NONE);
																														
																																Label lblNewLabel_1 = new Label(composite_14, SWT.NONE);
																																lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																																lblNewLabel_1.setBounds(36, 10, 124, 27);
																																lblNewLabel_1.setText("博物总说");
																																
																																		Label lblNewLabel_2 = new Label(composite_14, SWT.NONE);
																																		lblNewLabel_2.setAlignment(SWT.CENTER);
																																		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																																		lblNewLabel_2.setBounds(23, 59, 131, 27);
																																		lblNewLabel_2.setText("学术研究");
																																		
																																				Label lblNewLabel_3 = new Label(composite_14, SWT.NONE);
																																				lblNewLabel_3.setAlignment(SWT.CENTER);
																																				lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
																																				lblNewLabel_3.setBounds(34, 109, 116, 27);
																																				lblNewLabel_3.setText("返回主页");
																																				sashForm_1.setWeights(new int[] {444, 249});
																																				lblNewLabel_1.addMouseListener(new MouseAdapter() {
																																					@Override
																																					public void mouseDown(MouseEvent e) {
																																						stackLayout.topControl = composite_11;

																																						composite_3.setVisible(false);
																																						composite_4.setVisible(false);
																																						composite_6.setVisible(false);
																																						composite_7.setVisible(false);
																																						composite_8.setVisible(false);
																																						composite_9.setVisible(false);
																																						composite_10.setVisible(false);
																																						composite_11.setVisible(true);
																																						composite_12.setVisible(false);

																																					}
																																				});
																																				lblNewLabel_2.addMouseListener(new MouseAdapter() {
																																					@Override
																																					public void mouseDown(MouseEvent e) {
																																						stackLayout.topControl = composite_12;

																																						composite_3.setVisible(false);
																																						composite_4.setVisible(false);
																																						composite_6.setVisible(false);
																																						composite_7.setVisible(false);
																																						composite_8.setVisible(false);
																																						composite_9.setVisible(false);
																																						composite_10.setVisible(false);
																																						composite_11.setVisible(false);
																																						composite_12.setVisible(true);

																																					}
																																				});
																																				lblNewLabel_3.addMouseListener(new MouseAdapter() {
																																					@Override
																																					public void mouseDown(MouseEvent e) {
																																						shell.dispose();

																																					}
																																				});
																																				// 树的点击事件
																																				tree.addSelectionListener(new SelectionAdapter() {
																																					@Override
																																					public void widgetSelected(SelectionEvent e) {
																																						TreeItem ti = (TreeItem) e.item;
																																						if (ti.getText().equals("小明.馆长")) {
																																							stackLayout.topControl = composite_3;

																																							composite_4.setVisible(false);
																																							composite_5.setVisible(false);
																																							composite_6.setVisible(false);
																																							composite_7.setVisible(false);
																																							composite_8.setVisible(false);
																																							composite_9.setVisible(false);
																																							composite_10.setVisible(false);
																																							composite_3.setVisible(true);

																																						} else if (ti.getText().equals("小江.副馆长")) {
																																							stackLayout.topControl = composite_4;

																																							composite_4.setVisible(true);

																																						} else if (ti.getText().equals("小伟.副馆长")) {
																																							stackLayout.topControl = composite_5;
																																							composite_3.setVisible(false);
																																							composite_4.setVisible(false);

																																							composite_6.setVisible(false);
																																							composite_7.setVisible(false);
																																							composite_8.setVisible(false);
																																							composite_9.setVisible(false);
																																							composite_10.setVisible(false);

																																							composite_5.setVisible(true);

																																						} else if (ti.getText().equals("小平.副馆长")) {
																																							stackLayout.topControl = composite_6;
																																							composite_3.setVisible(false);
																																							composite_4.setVisible(false);
																																							composite_5.setVisible(false);
																																							composite_7.setVisible(false);
																																							composite_8.setVisible(false);
																																							composite_9.setVisible(false);
																																							composite_10.setVisible(false);
																																							composite_6.setVisible(true);

																																						} else if (ti.getText().equals("小文.副馆长")) {
																																							stackLayout.topControl = composite_7;
																																							composite_3.setVisible(false);
																																							composite_4.setVisible(false);
																																							composite_5.setVisible(false);
																																							composite_6.setVisible(false);

																																							composite_8.setVisible(false);
																																							composite_9.setVisible(false);
																																							composite_10.setVisible(false);

																																							composite_7.setVisible(true);

																																						} else if (ti.getText().equals("小英.副馆长")) {
																																							stackLayout.topControl = composite_8;
																																							composite_3.setVisible(false);
																																							composite_4.setVisible(false);
																																							composite_5.setVisible(false);
																																							composite_6.setVisible(false);
																																							composite_7.setVisible(false);

																																							composite_9.setVisible(false);
																																							composite_10.setVisible(false);

																																							composite_8.setVisible(true);

																																						} else if (ti.getText().equals("小斌.副馆长")) {
																																							stackLayout.topControl = composite_9;
																																							composite_3.setVisible(false);
																																							composite_4.setVisible(false);
																																							composite_5.setVisible(false);
																																							composite_6.setVisible(false);
																																							composite_7.setVisible(false);
																																							composite_8.setVisible(false);
																																							composite_10.setVisible(false);

																																							composite_9.setVisible(true);

																																						} else if (ti.getText().equals("小王.副馆长")) {
																																							stackLayout.topControl = composite_10;
																																							composite_3.setVisible(false);
																																							composite_4.setVisible(false);
																																							composite_5.setVisible(false);
																																							composite_6.setVisible(false);
																																							composite_7.setVisible(false);
																																							composite_8.setVisible(false);
																																							composite_9.setVisible(false);
																																							composite_10.setVisible(true);

																																						}
																																					}
																																				});
		sashForm.setWeights(new int[] { 600, 257 });
	}
}
