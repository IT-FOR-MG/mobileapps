package com.muthagroup.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.muthagroup.connection.ConnectionModel;
import com.muthagroup.vo.MuthaGroupVO;

public class MuthaGroupDAO {
	public ArrayList<ArrayList<Integer>>getReport(MuthaGroupVO vo) {
		String ROF_125_CC_disp="",
		ROF_100_CC_disp="",
		B104_D_disp="",
		TVS_74_CC_disp="",
		Kubota_Head_BS3_disp="",
		Kubota_Head_BS4_disp="",
		TVS_4S_disp="",
		TVS_CITY_disp="",
		TVS_SPORT_disp="";
		
		String ROF_125_CC_stock="",
		ROF_100_CC_stock="",
		B104_D_stock="",
		TVS_74_CC_stock="",
		Kubota_Head_BS3_stock="",
		Kubota_Head_BS4_stock="",
		TVS_4S_stock="",
		TVS_CITY_stock="",
		TVS_SPORT_stock="";
       
		ArrayList<String> displist= new ArrayList<String>();
		ArrayList<String> stocklist= new ArrayList<String>();
		// TODO Auto-generated method stub
		//ArrayList<MuthaGroupVO> list=new ArrayList<MuthaGroupVO>();
		ArrayList<ArrayList<Integer>>allList=new ArrayList<ArrayList<Integer>>(); 	
		//ArrayList adds 10 new ArrayLists 
		 ArrayList<Integer>list=new ArrayList<Integer>();
		try {
			Connection con=ConnectionModel.getConnection();
			String sql[]=new String[10];
			PreparedStatement ps=null;
			ResultSet rs=null;
			//Query for get month schedule of particular month of particular year
			
		 
		 sql[0]="select * from build_month_schedule_1476683237_core where year(date)=year('"+vo.getDate()+"') and month(date)=month('"+vo.getDate()+"')ORDER BY _SUBMISSION_DATE DESC";
		 //System.out.println("sql:-"+sql[0]);
		 //Query for get daily report of each item from each item's table
		 sql[1]="select * from build_rof125_cc_1477374651_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[2]="select * from build_rof100_cc_1477374748_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[3]="select * from build_b104_d_1477374784_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[4]="select * from build_tvs74_cc_1477374814_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[5]="select * from build_kubotaheadbs3_1477374858_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[6]="select * from build_kubotaheadbs4_1477374886_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[7]="select * from build_tvs4_s_1477374931_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[8]="select * from build_tvscity_1477374965_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 sql[9]="select * from build_tvssports_1477375007_core where date='"+vo.getDate()+"' ORDER BY _SUBMISSION_DATE DESC";
		 
		 //Execution of month schedule query  
	     //System.out.println("SQL:"+sql[0]);	
		 ps=con.prepareStatement(sql[0]);
	     rs=ps.executeQuery();
		 if(rs.next())
		 {
			 //columns from no 14 to 22 
			for(int i=14;i<=22;i++)
			{
			list.add(rs.getInt(i));
			}
		 }
		 else
		 {
			for(int i=14;i<=22;i++)
			{
			list.add(0);
			}
		 }
		//add ArrayList of month schedule to ArrayList allList
		allList.add(list);
		
		//add 9 ArrayList of Type Integer to ArrayList created for 9 items 
		for(int i=1;i<=9;i++)
		{
		allList.add(new ArrayList<Integer>());
		}
		
		 //System.out.println("9 Array list are created");	
		 
		//Execute query 9 times to add items details into ArrayList
		for(int i=1;i<=9;i++)
		{
			// System.out.println("SQL:"+sql[i]);	
			 ps=con.prepareStatement(sql[i]);
		     rs=ps.executeQuery();
			if(rs.next())
			{
				for(int j=13;j<=22;j++)
				{
				allList.get(i).add(rs.getInt(j));
				}
			}
			else
			{
				for(int j=13;j<=22;j++)
				{
			    allList.get(i).add(0);
				}
			}
		}
		//System.out.println("List return1");
		Connection ERPcon= ConnectionModel.getERPConnection();
		CallableStatement cs = ERPcon.prepareCall("exec FOUNDRYERP.dbo.Sel_DayWiseSubContractStockLedgerFinal;1 '103', '0' , '"+vo.getDate()+"' , '"+vo.getDate()+"'");
        ResultSet rs4 = cs.executeQuery();
        while(rs4.next())
		{
        	 if("101122002".equals(rs4.getString(2)) && "1010101084".equals(rs4.getString(3)))
			 {
				
				 ROF_125_CC_disp=rs4.getString(4);
				 ROF_125_CC_stock=rs4.getString(11);
			 }
			
			  
			  if(rs4.getString(2).equals("101122002")&&rs4.getString(3).equals("1010101075"))
			 {
				 ROF_100_CC_disp=rs4.getString(4);
				 ROF_100_CC_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101122002")&&rs4.getString(3).equals("1010101230"))
			 {
				 B104_D_disp=rs4.getString(4);
				 B104_D_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101122002")&&rs4.getString(3).equals("1010100646"))
			 {
				 TVS_74_CC_disp=rs4.getString(4);
				 TVS_74_CC_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101120645")&&rs4.getString(3).equals("1010101173"))
			 {
				 Kubota_Head_BS3_disp=rs4.getString(4);
				 Kubota_Head_BS3_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101120645")&&rs4.getString(3).equals("1010101365"))
			 {
				 Kubota_Head_BS4_disp=rs4.getString(4);
				 Kubota_Head_BS4_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101120645")&&rs4.getString(3).equals("1010100764"))
			 {
				 TVS_4S_disp=rs4.getString(4);
				 TVS_4S_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101120645")&&rs4.getString(3).equals("1010101209"))
			 {
				 TVS_CITY_disp=rs4.getString(4);
				 TVS_CITY_stock=rs4.getString(11);
			 }
			 if(rs4.getString(2).equals("101120645")&&rs4.getString(3).equals("1010101210"))
			 {
				 TVS_SPORT_disp=rs4.getString(4);
				 TVS_SPORT_stock=rs4.getString(11);
			 }
		}
        displist.add(ROF_125_CC_disp);
        displist.add(ROF_100_CC_disp);
        displist.add(B104_D_disp);
        displist.add(TVS_74_CC_disp);
        displist.add(Kubota_Head_BS3_disp);
        displist.add(Kubota_Head_BS4_disp);
        displist.add(TVS_4S_disp);
        displist.add(TVS_CITY_disp);
        displist.add(TVS_SPORT_disp);
        vo.setDis_list(displist);
        stocklist.add(ROF_125_CC_stock);
        stocklist.add(ROF_100_CC_stock);
        stocklist.add(B104_D_stock);
        stocklist.add(TVS_74_CC_stock);
        stocklist.add(Kubota_Head_BS3_stock);
        stocklist.add(Kubota_Head_BS4_stock);
        stocklist.add(TVS_4S_stock);
        stocklist.add(TVS_CITY_stock);
        stocklist.add(TVS_SPORT_stock);
        vo.setStock_list(stocklist);
		} catch (Exception e) {
			// TODO: handle exception
            e.printStackTrace();		
		}
		 //System.out.println("List return2");	
		return allList;
	}

}

