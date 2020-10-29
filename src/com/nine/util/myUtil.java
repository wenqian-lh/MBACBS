package com.nine.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

//import com.lh.ui.Index;

public class myUtil {
	
	public String myEmail = "lh15873424347@163.com";
	public String myHost = "smtp.163.com";
	public String myEmailPwssword = "YAXRVNWCUVZIBNPD";
	
	private Thread thread = null; //播放线程
	private boolean startStatus = true; //启动状态
	private AudioInputStream ais;
	private AudioFormat format;
	private long timeLength = 0;//时长
	private long time = 0; //当前播放时间
	
	private boolean flag = false;
	private int clickX;
	private int clickY;
	
	public 	void alterMessage(Shell shell , String title , String message ){
		//JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
		MessageBox mb = new MessageBox(shell,SWT.NONE);
		mb.setText(title);
		mb.setMessage(message);
		mb.open();
	}

	//发送邮件准备工作：邮箱，SMTP服务，授权码
	public String senEmail(String email){
		//随机获取六位的验证码
		Random r = new Random();
		String code = "";
		for(int i = 0; i < 6; i++){
			code += r.nextInt(10);
		}
		
		//开始发邮件
		Properties p = new Properties();
		p.setProperty("mail.transport.protocol" , "smtp"); //使用smtp协议发送邮件
		p.setProperty("mail.smtp.host", myHost); //主机地址
		p.setProperty("mail.smtp.auth", "true");//授权通过
		Session session = Session.getInstance(p);
		session.setDebug(true);
		
		//创建邮件
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom( new InternetAddress(myEmail , "一花一世界" , "utf-8")); //设置发件人
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email , "用户" , "utf-8"));//设置收件人
			message.setSubject(" 鸡犬不相闻  " , "utf-8"); //邮件主题
			message.setContent(" 打死不相往来 " + code , "text/html;charset=utf-8");//内容
			message.setSentDate(new Date());
			message.saveChanges(); //保存好
			
			//开始发送
			Transport transport = session.getTransport();
			transport.connect(myEmail , myEmailPwssword);
			transport.sendMessage(message , message.getAllRecipients());
			transport.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}	
		return "123456";	
	}
	
	/*public void startMusic(ProgressBar progressbar,boolean flag,AudioInputStream ais ,  Label label){
		//第一种可能,你正在播放其他音乐，调用这个方法，先要停止当前的播放，开始播放你现在要播放
		if( Index.clip != null){
			Index.clip.close();
			Index.clip = null;
		}
		
		if(thread != null){
			startStatus = false;
			thread.stop();
		}
		//进度条归零
		progressbar.setSelection(0);
		
		//准备工作也就绪,开始播放
		flag = true; //代表开始播放
		try {
			ais = AudioSystem.getAudioInputStream(ais);
			
			format = ais.getFormat();//获得此音频输入流中声音数据的音频格式
			//获取此格式声音的编码类型  如果不是 有符号的线性PCM数据
			if( format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED){
				format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, //音频编码技术
						 format.getSampleRate(),//每秒的样本数
						 16, //样本位数
						 format.getChannels(), //声道数（单身道1个，立体声2个，等等）
						 format.getChannels()*2, //每帧中的字节数
						 format.getSampleRate(),//每帧的秒数
						 false//指示是否以big-endian字节顺序存储单个样本中的数据（false 意味着title-endian）
						 );
				ais = AudioSystem.getAudioInputStream(format , ais);
			}
			
			//通过audio流，来得到播放对象
			Index.clip = AudioSystem.getClip();
			Index.clip.open(ais);
			//开始播放音乐
			Index.clip.start();
			
			//得到总时长
			timeLength =  Index.clip.getMicrosecondLength() / 1000;
			
			//开启一个线程
			thread = new Thread(new Runnable(){

				@Override
				public void run() {
					boolean end = false;
					startStatus = true;
					//异步操作
					while( startStatus ){
						//得到当前的时间
						time = Index.clip.getMicrosecondPosition() / 1000;
						//操作进度条
						Display.getDefault().asyncExec(new Runnable(){

							@Override
							public void run() {
								progressbar.setSelection( (int) (time*1.0 / timeLength * 10000) );
								label.setText(  showTime( time , timeLength ));;
							}
							
						});
					}
				}
				
			});
			thread.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


private String showTime(long time, long timeLength) {
	String str = "";
	long temp = 0;
	
	//当前时间
	if( time < 60000 ){
		str += "00:";
		str += time/1000 >= 10 ? time/1000 : "0"+time/1000;
	}else{
		temp = time / 60000; //分钟
		str = temp >= 10 ? temp+"" : "0"+temp;
		str += ":";
		//计算秒
		temp = time % 60000 / 1000;
		str += temp >= 10 ? temp+"" : "0"+temp;
	}
	//总时间
	str += "/";
	
	temp = timeLength / 60000;
	str += temp >= 10 ? temp+"" : "0"+temp;
	temp = timeLength % 6000 / 1000;
	str += ":";
	str += temp >= 10 ? temp+"" : "0"+temp;

	return str;
}

/**
 * 窗口移动的方法
 * @param composite
 * @param shell
 */
public void windowMove(Composite composite,Shell shell){
	composite.addMouseMoveListener( new MouseMoveListener(){

		@Override
		public void mouseMove(MouseEvent e) {
			//移动
			if( flag ){
				shell.setLocation(shell.getLocation().x + (e.x - clickX) , shell.getLocation().y + (e.y - clickY));
			}
		}	
	});
	
	composite.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseDown(MouseEvent e) {
			flag = true;
			clickX = e.x;
			clickY = e.y;
		}

		@Override
		public void mouseUp(MouseEvent e) {
			flag = false;
			
		}
		
	});
}
}