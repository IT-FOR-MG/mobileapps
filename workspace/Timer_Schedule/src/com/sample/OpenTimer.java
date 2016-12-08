package com.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import com.connection.ConnectionModel;

import javax.mail.Transport;

import java.util.Calendar;
import java.util.Date;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
public class OpenTimer extends TimerTask {
	Connection con;
	String mailrecipients=null;
	@Override
	public void run() {
		 try {
			 int trid=0;
			    String srsid=null;
	   			Calendar c = Calendar.getInstance();
	   			/*System.out.println("Calender:"+c);*/
	   			String start=null;
	   			String startyear=null;
	   			String end=null;
	   			String endyear=null;
	   			String date=null;
	   			String time=null;
	   			String machine=null;
	   			String type=null;
	   			String machine_name=null;
	   			String machine_type=null;
	   			String description=null;
	   			int year=0;
	   			int month=0;
	   			int day=0;
	   			int hour=0;
	   			int minute=0;
	   			
	   			 year = c.get(Calendar.YEAR);
	   			 month = c.get(Calendar.MONTH)+1;
	   			 day=c.get(Calendar.DAY_OF_MONTH);
	   			 hour=c.get(Calendar.HOUR_OF_DAY);
	   			 minute=c.get(Calendar.MINUTE);
	   			if(month<=3)
	   			{
	   				start=(String.valueOf(year-1).substring(2));
	   				startyear=String.valueOf(year-1);
	   				end=(String.valueOf(year).substring(2));
	   				endyear=String.valueOf(year);
	   				
	   			}
	   			else
	   			{
	   				start=(String.valueOf(year).substring(2));
	   				startyear=String.valueOf(year);
	   				end=(String.valueOf(year+1).substring(2));
	   				endyear=String.valueOf(year+1);
	   			}
	   			/*System.out.println("Strat:"+start);
	   			System.out.println("End:"+end);
	   			System.out.println("month:"+month);*/
	   		con = ConnectionModel.getConnection1();
	   		Statement dest_userstmt = con.createStatement(); 
	   		ResultSet userrs = dest_userstmt.executeQuery("select * from dest_user_tbl");
	   		if(userrs.next())
	   		{
	   			mailrecipients=userrs.getString("user_mail_id");
	   		}
	   		String SQL = "SELECT * FROM bdmr_core"; 
	   		Statement stmt = con.createStatement(); 
	   		ResultSet rs = stmt.executeQuery(SQL);
	     // Iterate through the data in the result set and display it. 
	   		while (rs.next()) 
	   		{   
	   			description=rs.getString("DESCRIPTION");
	   			type=rs.getString("MACHINE_TYPE");
	   			if(rs.getString("MACHINE_NAME1")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME1");
	   			}
	   			if(rs.getString("MACHINE_NAME2")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME2");
	   			}
	   			if(rs.getString("MACHINE_NAME3")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME3");
	   			}
	   			if(rs.getString("MACHINE_NAME4")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME4");
	   			}
	   			if(rs.getString("MACHINE_NAME5")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME5");
	   			}
	   			if(rs.getString("MACHINE_NAME6")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME6");
	   			}
	   			if(rs.getString("MACHINE_NAME7")!=null)
	   			{
	   				machine=rs.getString("MACHINE_NAME7");
	   			}
	   			/*System.out.println("System URI: "+rs.getString("_URI"));
	   			System.out.println("Machine Type code: "+type);
	   			System.out.println("Machine Name code: "+machine);*/
	   			Statement machstmt = con.createStatement(); 
	   			ResultSet rs_machine = machstmt.executeQuery("SELECT * FROM machines where code='"+machine+"'");
	   			if(rs_machine.next())
	   			{
	   				machine_name=rs_machine.getString("machine_name");
	   			}
	   			Statement mach_type_stmt = con.createStatement();
	   			ResultSet rs_machine_type = mach_type_stmt.executeQuery("SELECT * FROM machines_type where code='"+type+"'");
	   			if(rs_machine_type.next())
	   			{
	   				machine_type=rs_machine_type.getString("type");
	   			}
	   			/*System.out.println("Machine Type : "+machine_type);
	   			System.out.println("Machine Name code: "+machine_name);
	   			System.out.println("System URI: "+rs.getString("_URI"));*/
	        String SQL1 = "SELECT * FROM ins_status where ins_stats_uri='"+rs.getString("_URI")+"'"; 
	      /*  System.out.println("sql1"+SQL1);*/
	        Statement ins_stmt = con.createStatement();
	   		ResultSet rs1 = ins_stmt.executeQuery(SQL1);
	   		if(!(rs1.next()))
	   		{   
	   			
	   			Connection con1 = ConnectionModel.getConnection2();
		         String SQL2 = "SELECT  MAX(CAST(TRAN_NO AS BIGINT))  FROM TRNMAINTENANCEREQH WHERE ISNUMERIC(TRAN_NO)=1 AND TRAN_DATE BETWEEN '"+startyear+"-4"+"-1"+"' AND '"+endyear+"-3"+"-31'"; 

		         /*System.out.println("SQL2: "+SQL2);*/
		         Statement stmt2 = con1.createStatement(); 
		         ResultSet rs3 = stmt2.executeQuery(SQL2);
		         // Iterate through the data in the result set and display it. 
		         if (rs3.next()) 
		         { 
		        	/* System.out.println("strid:"+rs3.getString(1));*/
		        	 if(rs3.getString(1)!=null)
		        	 {
		        	String strid=rs3.getString(1).substring(14); 
		        	/*System.out.println("strid:"+rs3.getString(1));*/
		            trid=Integer.parseInt(strid)+1; 
		           /* System.out.println("trid:"+trid);*/
		        	 }
		        	 else
			         {
			        	 trid=0001;
			         }
		         }
		         
		   			String TRID=null;
		   			Statement srs_userstmt = con.createStatement(); 
			   		ResultSet srsuserrs = srs_userstmt.executeQuery("select * from srs_user_tbl where user_device_id='"+rs.getString("_CREATOR_URI_USER")+"'");
			   		if(srsuserrs.next())
			   		{
			   			srsid=srsuserrs.getString("user_id");
			   		}
			   		/*System.out.println("SRSID:"+srsid);*/
			   		TRID=srsid+start+end+"92011"+month+String.format("%04d", trid);;
			   		/*System.out.println("TRID:"+TRID);
		   		    System.out.println("DATE"+year+month+day);*/
	   		 PreparedStatement prstmt1 = con.prepareStatement("insert into ins_status (ins_stats_uri,ins_status_date,ins_status_user) values (?,?,?)");
	         prstmt1.setString(1,rs.getString("_URI"));
	         prstmt1.setString(2,rs.getString("_LAST_UPDATE_DATE"));
	         prstmt1.setString(3,rs.getString("_LAST_UPDATE_URI_USER"));
	         prstmt1.executeUpdate();
	          con1 = ConnectionModel.getConnection2();
	         /*System.out.println("Connected.");*/
	         //insert into SQL statement that store data. 
	        /* String SQL2 = "SELECT * FROM TRNMAINTENANCEREQH"; 
	         Statement stmt2 = con.createStatement(); 
	         ResultSet rs3 = stmt.executeQuery(SQL2);
	         // Iterate through the data in the result set and display it. 
	         while (rs3.next()) 
	         { 
	            System.out.println(rs.getString(1) + " " + rs.getString(2)); 
	         }*/
	         
	         date=String.valueOf(year)+String.valueOf(month)+String.valueOf(day);
	         time=String.valueOf(hour)+":"+String.valueOf(minute);
	         PreparedStatement prstmt = con1.prepareStatement("insert into TRNMAINTENANCEREQH (TRAN_SUBTYPE,SHORT_NAME,TRAN_DATE,TAG_CODE,DEPT_CODE,TRAN_AMT,EMP_CODE,ESTIMITED_DATE,PRIORITY,IS_SHUTDOWNREQUIRED,IS_SYSSHUTDOWNREQUIRED,IS_SAFETYPERMITREQUIRED,SAFETY_PERMITDATE,BREAKDOWN_DATE,BREAKDOWN_TIME,SHORT_NARRTN,LONG_NARRTN,SYSADD_DATETIME,SYSADD_LOGIN,SYSCHNG_DATETIME,SYSCHNG_LOGIN,SYSAPR_DATETIME,SYSAPR_LOGIN,SYSCHNG_REMARK,STATUS_CODE,SYS_DATE,IS_PREDICTIVE,USER_NAME,TRAN_NO) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	         prstmt.setString(1,"1");
	         //System.out.println("1:TRAN_SUBTYPE: "+"1");
	         prstmt.setString(2,"MNTREQ");
	         //System.out.println("2:SHORT_NAME: "+"MNTREQ");
	         prstmt.setString(3,date);
	         //System.out.println("3:TRAN_DATE: "+date);
	         prstmt.setString(4,"1010000001");
	         //System.out.println("4:TAG_CODE: "+"1010000001");
	         prstmt.setString(5,srsuserrs.getString("user_dept_code"));
	         //System.out.println("5:DEPT_CODE: "+srsuserrs.getString("user_dept_code"));
	         prstmt.setString(6,"0");
	         //System.out.println("6:TRAN_AMT: "+"0");
	         prstmt.setString(7,srsuserrs.getString("srs_user_code"));
	         //System.out.println("7:EMP_CODE: "+srsuserrs.getString("srs_user_code"));
	         prstmt.setString(8,date);
	         //System.out.println("8:ESTIMITED_DATE: "+date);
	         prstmt.setString(9,"0");
	         //System.out.println("9:PRIORITY: "+"0");
	         prstmt.setString(10,"0");
	         //System.out.println("10:IS_SHUTDOWNREQUIRED: "+"0");
	         prstmt.setString(11,"0");
	         //System.out.println("11:IS_SYSSHUTDOWNREQUIRED: "+"0");
	         prstmt.setString(12,"0");
	         //System.out.println("12:IS_SAFETYPERMITREQUIRED: "+"0");
	         prstmt.setString(13,"");
	         //System.out.println("13:SAFETY_PERMITDATE: "+"");
	         prstmt.setString(14,date);
	         //System.out.println("14:BREAKDOWN_DATE: "+date);
	         prstmt.setString(15,"01:00");
	         //System.out.println("15:BREAKDOWN_TIME: "+"01:00");
	         prstmt.setString(16,"Breakdown Main.Req.");
	         //System.out.println("16:SHORT_NARRTN: "+"Breakdown Main.Req.");
	         prstmt.setString(17,"Machine Type: "+machine_type+" Machine Name: "+machine_name+" Details: "+description);	
	         //System.out.println("17:LONG_NARRTN: "+"Machine Type: "+machine_type+"\nMachine Name: "+machine_name+"\nDetails"+description);
	         prstmt.setString(18,date+":"+time); 
	         //System.out.println("18:SYSADD_DATETIME: "+date+":"+time);
	         prstmt.setString(19,"ADMIN");		
	         //System.out.println("19:SYSADD_LOGIN: "+"ADMIN");
	         prstmt.setString(20,date+":"+time);
	         //System.out.println("20:SYSCHNG_DATETIME: "+date+":"+time);
	         prstmt.setString(21,"ADMIN");
	         //System.out.println("21:SYSCHNG_LOGIN: "+"ADMIN");
	         prstmt.setString(22,"");
	         //System.out.println("22: SYSAPR_DATETIME: "+"");
	         prstmt.setString(23,"");
	         //System.out.println("23:SYSAPR_LOGIN: "+"");
	         prstmt.setString(24,"");
	         //System.out.println("24:SYSCHNG_REMARK: "+"");
	         prstmt.setString(25,"0");	
	         //System.out.println("25:STATUS_CODE: "+"0");
	         prstmt.setString(26,date+":"+time);	
	         //System.out.println("26:SYS_DATE: "+date+":"+time);
	         prstmt.setString(27,"0");
	         //System.out.println("27:IS_PREDICTIVE: "+"0");
	         prstmt.setString(28,"BWAYS");
	         //System.out.println("28:USER_NAME: "+"BWAYS");
	         prstmt.setString(29,TRID);
	         //System.out.println("29:TRAN_NO: "+TRID);
	        
	        /* prstmt.setString(29,"");
	         prstmt.setString(30,"0");*/
	         prstmt.executeUpdate();
	         con1.close();
	         //mailing
	         String host = "send.one.com";
	         String user = "itsupports@muthagroup.com";
	         String pass = "itsupports@xyz";
	         String from = "itsupports@muthagroup.com";
	         String subject = "Email Notification";
	         boolean sessionDebug = false; 
	         String[] recipients = {mailrecipients};
	         Properties props = System.getProperties();
	         props.put("mail.host", host);
	         props.put("mail.transport.protocol", "smtp");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.smtp.port", 2525);
	         Session mailSession = Session.getDefaultInstance(props, null);
	         mailSession.setDebug(sessionDebug);
	         Message msg = new MimeMessage(mailSession);
	         msg.setFrom(new InternetAddress(from));
	         InternetAddress[] addressTo = new InternetAddress[recipients.length];

	         for (int p = 0; p < recipients.length; p++) {
	         	addressTo[p] = new InternetAddress(recipients[p]);
	         }

	         msg.setRecipients(Message.RecipientType.TO, addressTo); 

	         msg.setSubject(subject);
	         msg.setSentDate(new Date());
	         StringBuilder sb = new StringBuilder();
	         sb.append("<b style='color: #0D265E;'>*** This is an automatically generated email System for Breakdown Maintenance requition !!! ***</b>");
	         sb.append("<p><b style='color: #330B73;font-family: Arial;'><table border=1><tr><font color=#330B73><th>TR. NO.</th><th>Req. Date</th><th>Company Name</th><th>Machine Type</th><th>Machine Name</th><th>Breakdown Description</th><th>Created By</th></font></tr>"
	         		+"<tr><td>"+TRID+"</td><td>"+date+":"+time+"</td><td>"+srsuserrs.getString("user_company")+"</td><td>"+machine_type+"</td><td>"+machine_name+"</td><td>"+description+"</td><td>"+srsuserrs.getString("user_name")+"</td></tr></table>"
	        		 + "</P><p style='font-family: Arial;'>IT | Software Development | Mutha Group Satara </p><hr><p>"+
	         		"<b style='font-family: Arial;'>Disclaimer :</b></p> <p><font face='Arial' size='1'>"+
	         		"<b style='color: #49454F;'>The information transmitted, including attachments, is intended only for the person(s) or entity to which"+
	         		"it is addressed and may contain confidential and/or privileged material. Any review, retransmission, dissemination or other use of, or taking of any action in reliance upon this information by persons"+
	         		"or entities other than the intended recipient is prohibited. If you received this in error, please contact the sender and destroy any copies of this information.</b>"+
	         		"</font></p>");

	         msg.setContent(sb.toString(), "text/html");

	         Transport transport = mailSession.getTransport("smtp");
	         transport.connect(host, user, pass);
	         transport.sendMessage(msg, msg.getAllRecipients());  
	         transport.close(); 
	   		}
	   		}
	   		} catch (Exception e) {
	   			e.printStackTrace();
	   			System.out.println("Connection Failed");
	   		}
		 finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
