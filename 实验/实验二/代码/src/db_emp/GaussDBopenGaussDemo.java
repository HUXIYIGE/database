package db_emp;
import java.sql.*;
import java.util.*;

public class GaussDBopenGaussDemo{
 
    static final String JDBC_DRIVER = "org.postgresql.Driver";  
    static final String DB_URL = "jdbc:postgresql://124.71.229.93:8000/finance?ApplicationName=app1";
      // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "Xiesj20011104?!";
    //select 
    public static void select_employee() {
    	System.out.println("------��ѯְ����Ϣ��------");
		System.out.println("�����Ӧ����ѡ���ѯ���ܣ�");
    	System.out.println("1��ȫ������");
    	System.out.println("2����ȷ����");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from employee;";
			break;
		}
		case "2": {
			System.out.println("����Ա������");
			String name=input.next();
			sql+="* from employee ";
			sql+="where ename='";
			sql+=name;
			sql+="';";
			break;
		}
		
		default:
			
		}
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
		    while(rs.next()){
                // ͨ���ֶμ���
		    	String id  = rs.getString("eid");
                String name = rs.getString("ename");
                String birth = rs.getString("birth");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String mail = rs.getString("mail");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", ����: " + name);
                System.out.print(", ����: " + birth);
                System.out.print(", �Ա�: " + gender);
                System.out.print(", �绰����: " + phone);
                System.out.print(", ��������: " + mail);
                System.out.print("\n");
                
            }
	        rs.close();
	        st.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void select_department() {
    	System.out.println("------��ѯ������Ϣ��------");
		System.out.println("�����Ӧ����ѡ���ѯ���ܣ�");
    	System.out.println("1��ȫ������");
    	System.out.println("2����ȷ����");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from department;";
			break;
		}
		case "2": {
			System.out.println("���벿������");
			String name=input.next();
			sql+="* from department ";
			sql+="where dname='";
			sql+=name;
			sql+="';";
			break;
		}
		default:
			
		}
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
		    while(rs.next()){
                // ͨ���ֶμ���
		    	String id  = rs.getString("did");
                String name = rs.getString("dname");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", ����: " + name);
                System.out.print("\n");
                
            }
	        rs.close();
	        st.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void select_position() {
    	System.out.println("------��ѯ��˾ְλ��------");
		System.out.println("�����Ӧ����ѡ���ѯ���ܣ�");
    	System.out.println("1��ȫ������");
    	System.out.println("2����ȷ����");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from position;";
			break;
		}
		case "2": {
			System.out.println("����ְλ����");
			String name=input.next();
			sql+="* from position ";
			sql+="where pname='";
			sql+=name;
			sql+="' and ";
			System.out.println("���벿��id");
			String id=input.next();
			
			sql+="did='";
			sql+=id;
			sql+="';";
			break;
		}
		default:

		}	
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
		    while(rs.next()){
                // ͨ���ֶμ���
		    	String pid  = rs.getString("pid");
		    	String did  = rs.getString("did");
                String name = rs.getString("pname");
                String salary = rs.getString("salary");
    
                // �������
                System.out.print(" PID: " + pid);
                System.out.print(" , DID: " + did);
                System.out.print(" , ְλ����: " + name);
                System.out.print(" , нˮ: " + salary);
                System.out.print("\n");
                
            }
	        rs.close();
	        st.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void select_employment() {
    	System.out.println("------��ѯְ����ְ��------");
		System.out.println("�����Ӧ����ѡ���ѯ���ܣ�");
    	System.out.println("1��ȫ������");
    	System.out.println("2����ȷ����");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from employment;";
			break;
		}
		case "2": {
			System.out.println("����Ա��id");
			String id=input.next();
			sql+="* from employment ";
			sql+="where eid='";
			sql+=id;
			sql+="';";
			break;
		}
		default:
			
		}
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
		    while(rs.next()){
                // ͨ���ֶμ���
		    	String eid  = rs.getString("eid");
		    	String pid  = rs.getString("pid");
                String experience = rs.getString("experience");
    
                // �������
                System.out.print("EID: " + eid);
                System.out.print(" , PID: " + pid);
                System.out.print(" , ����: " + experience);
                System.out.print("\n");
                
            }
	        rs.close();
	        st.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void select_menu(){
    	System.out.println("------��ѯ��¼------");
		System.out.println("�����Ӧ����ѡ���ѯ���");
    	System.out.println("1��employee");
    	System.out.println("2��department");
    	System.out.println("3��position");
    	System.out.println("4��employment");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String table=input.next();
    	switch (table) {
		case "1": {
			select_employee();
			break;
		}
		case "2": {
			select_department();
			break;
		}
		case "3": {
			select_position();
			break;
		}
		case "4": {
			select_employment();
			break;
		}
		default:
			System.out.println("�������");
			break;
		}
    }
    
    //insert
	public static void insert_employee() {
		System.out.println("------���ְ����Ϣ------");
		System.out.println("������ְ����ţ�");
		Scanner input=new Scanner(System.in);
		String eid=input.next();
		System.out.println("������ְ��������");
		String ename=input.next();
		System.out.println("������ְ�����գ�");
		String birth=input.next();
		System.out.println("������ְ���Ա�");
		String gender=input.next();
		System.out.println("������ְ���绰���룺");
		String phone=input.next();
		System.out.println("������ְ���������䣺");
		String mail=input.next();
		String sql="insert into employee values ('"+eid+"','"
				+ename+"','"+birth+"','"+gender+"','"
				+phone+"','"+mail+"');";
		try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
			st.close();
			con.close();
			if(rows>0) {
				System.out.println("��¼��ӳɹ�");
			}
			else {
				System.out.println("��¼���ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert_department() {
		System.out.println("------��Ӳ�����Ϣ------");
    	System.out.println("�����벿�ű�ţ�");
    	Scanner input=new Scanner(System.in);
    	String did=input.next();
    	System.out.println("�����벿�����ƣ�");
    	String dname=input.next();
    	String sql="insert into department values ('"+did+"','"
    			+dname+"');";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼��ӳɹ�");
            }
            else {
            	System.out.println("��¼���ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert_position() {
		System.out.println("------���ְλ��Ϣ------");
    	System.out.println("������ְλid��");
    	Scanner input=new Scanner(System.in);
    	String pid=input.next();
    	System.out.println("�����벿��id��");
    	String did=input.next();
    	System.out.println("������ְλ���ƣ�");
    	String pname=input.next();
    	System.out.println("������нˮ��");
    	String salary=input.next();
    	String sql="insert into position values ('"+pid+"','"
    			+did+"','"+pname+"','"+salary+"');";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼��ӳɹ�");
            }
            else {
            	System.out.println("��¼���ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert_employment() {
		System.out.println("------��Ӿ�ְ��Ϣ------");
    	System.out.println("������ְ��id��");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	System.out.println("������ְλid��");
    	String pid=input.next();
    	System.out.println("�����뾭����");
    	String experience=input.next();
    	String sql="insert into employment values ('"+eid+"','"
    			+pid+"','"+experience+"');";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼��ӳɹ�");
            }
            else {
            	System.out.println("��¼���ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void insert_menu() {
    	System.out.println("------��Ӽ�¼------");
		System.out.println("�����Ӧ����ѡ����ӱ��");
    	System.out.println("1��employee");
    	System.out.println("2��department");
    	System.out.println("3��position");
    	System.out.println("4��employment");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String table=input.next();
    	switch (table) {
		case "1": {
			insert_employee();
			break;
		}
		case "2": {
			insert_department();
			break;
		}
		case "3": {
			insert_position();
			break;
		}
		case "4": {
			insert_employment();
			break;
		}
		default:
			System.out.println("�������");
			break;
		}
    }
    
    //update
    public static void update_employee() {
    	String sql="update employee set ";
    	System.out.println("------����ְ����Ϣ------");
    	System.out.println("������ְ����ţ�");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	System.out.println("�Ƿ�������֣�");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c1=input.next();
    	System.out.println(c1);
    	switch(c1) {
    		case "1":{
    			System.out.println("������������");
        		String ename=input.next();
        		sql+="ename='"+ename+
        		"',";
        		break;
    		}
        	default:{
        		break;
        	}
    	}		
    	System.out.println("�Ƿ�������գ�");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c2=input.next();
    	switch(c2) {
		case "1":{
			System.out.println("���������գ�");
    		String birth=input.next();
    		sql+="birth='"+birth+
    		"',";
    		break;
		}
    	default:
    		break;
    	}
    	System.out.println("�Ƿ�����Ա�");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c3=input.next();
    	switch (c3) {
		case "1": {
			System.out.println("�������Ա�");
    		String gender=input.next();
    		sql+="gender='"+gender+
    				"',";
    		break;
		}
		default:
			break;
		}
    	System.out.println("�Ƿ���µ绰���룺");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c4=input.next();
    	switch (c4) {
		case "1": {
			
			System.out.println("������绰���룺");
    		String phone=input.next();
    		sql+="phone='"+phone+
    				"',";
    		break;
		}
		default:
			break;
		}
    	System.out.println("�Ƿ���µ������䣺");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c5=input.next();
    	switch (c5) {
		case "1": {
			System.out.println("������������䣺");
    		String mail=input.next();
    		sql+="mail='"+mail+
    				"',";
    		break;
		}
		default:
			break;
		}
    	sql=sql.substring(0,sql.length()-1)+" where eid='"+eid
    			+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼���³ɹ�");
            }
            else {
            	System.out.println("��¼����ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	public static void update_department() {
		
    	System.out.println("------���²�����Ϣ------");
    	System.out.println("�����벿��id��");
    	Scanner input=new Scanner(System.in);
    	String did=input.next();
    	System.out.println("�������µĲ������ƣ�");
    	String dname=input.next();
    	String sql="update department set dname='"+dname+
    			"' where did='"+did+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼���³ɹ�");
            }
            else {
            	System.out.println("��¼����ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update_position() {
		String sql="update position set ";
    	System.out.println("------����ְλ��Ϣ------");
    	System.out.println("������ְλid��");
    	Scanner input=new Scanner(System.in);
    	String pid=input.next();
    	System.out.println("�Ƿ���²���id��");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c1=input.next();
    	System.out.println(c1);
    	switch(c1) {
    		case "1":{
    			System.out.println("�����벿��id��");
        		String did=input.next();
        		sql+="did='"+did+
        		"',";
        		break;
    		}
        	default:{
        		break;
        	}
    	}		
    	System.out.println("�Ƿ�ְλ���ƣ�");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c2=input.next();
    	switch(c2) {
		case "1":{
			System.out.println("������ְλ���ƣ�");
    		String pname=input.next();
    		sql+="pname='"+pname+
    		"',";
    		break;
		}
    	default:
    		break;
    	}
    	System.out.println("�Ƿ����нˮ��");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c3=input.next();
    	switch (c3) {
		case "1": {
			System.out.println("������нˮ��");
    		String salary=input.next();
    		sql+="salary='"+salary+
    				"',";
    		break;
		}
		default:
			break;
		}
    	sql=sql.substring(0,sql.length()-1)+" where pid='"+pid
    			+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼���³ɹ�");
            }
            else {
            	System.out.println("��¼����ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update_employment() {
		String sql="update employment set ";
    	System.out.println("------���¾�ְ��Ϣ------");
    	System.out.println("������ְ��id��");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	System.out.println("�Ƿ����ְλid��");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c1=input.next();
    	System.out.println(c1);
    	switch(c1) {
    		case "1":{
    			System.out.println("������ְλid��");
        		String pid=input.next();
        		sql+="pid='"+pid+
        		"',";
        		break;
    		}
        	default:{
        		break;
        	}
    	}		
    	System.out.println("�Ƿ���¾�����");
    	System.out.println("1����");
    	System.out.println("2����");
    	String c2=input.next();
    	switch(c2) {
		case "1":{
			System.out.println("�����뾭����");
    		String experience=input.next();
    		sql+="experience='"+experience+
    		"',";
    		break;
		}
    	default:
    		break;
    	}
    	sql=sql.substring(0,sql.length()-1)+" where eid='"+eid
    			+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼���³ɹ�");
            }
            else {
            	System.out.println("��¼����ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void update_menu() {
    	System.out.println("------���¼�¼------");
		System.out.println("�����Ӧ����ѡ����±��");
    	System.out.println("1��employee");
    	System.out.println("2��department");
    	System.out.println("3��position");
    	System.out.println("4��employment");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String table=input.next();
    	switch (table) {
		case "1": {
			update_employee();
			break;
		}
		case "2": {
			update_department();
			break;
		}
		case "3": {
			update_position();
			break;
		}
		case "4": {
			update_employment();
			break;
		}
		default:
			System.out.println("�������");
			break;
		}
    }
    
    //delete
    public static void delete_employee() {
    	System.out.println("������ְ��id��");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	String sql="delete from employee where eid='"+eid+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼ɾ���ɹ�");
            }
            else {
            	System.out.println("��¼ɾ��ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_department() {
    	System.out.println("�����벿��id��");
    	Scanner input=new Scanner(System.in);
    	String did=input.next();
    	String sql="delete from department where did='"+did+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼ɾ���ɹ�");
            }
            else {
            	System.out.println("��¼ɾ��ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_position() {
    	System.out.println("������ְλid��");
    	Scanner input=new Scanner(System.in);
    	String pid=input.next();
    	String sql="delete from position where pid='"+pid+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼ɾ���ɹ�");
            }
            else {
            	System.out.println("��¼ɾ��ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_employment() {
    	System.out.println("������ְ��id��");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	String sql="delete from employment where eid='"+eid+"';";
    	try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement st=con.createStatement();
			int rows=st.executeUpdate(sql);
		    st.close();
		    con.close();
            if(rows>0) {
            	System.out.println("��¼ɾ���ɹ�");
            }
            else {
            	System.out.println("��¼ɾ��ʧ��");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_menu() {
    	System.out.println("------ɾ����¼------");
		System.out.println("�����Ӧ����ѡ����");
    	System.out.println("1��employee");
    	System.out.println("2��department");
    	System.out.println("3��position");
    	System.out.println("4��employment");
    	System.out.println("���������֣�");
    	Scanner input=new Scanner(System.in);
    	String table=input.next();
    	switch (table) {
		case "1": {
			delete_employee();
			break;
		}
		case "2": {
			delete_department();
			break;
		}
		case "3": {
			delete_position();
			break;
		}
		case "4": {
			delete_employment();
			break;
		}
		default:
			System.out.println("�������");
			break;
		}
    }
    
	public static void menu() {
		System.out.println("------Ա������ϵͳ------");
		System.out.println("�����Ӧ����ѡ���ܣ�");
		System.out.println("1����Ӽ�¼");
		System.out.println("2��ɾ����¼");
		System.out.println("3���޸ļ�¼");
		System.out.println("4����ѯ��¼");
		System.out.println("���������֣�");
		Scanner input=new Scanner(System.in);
		String menuid=input.next();
		switch (menuid) {
		case "1": {
			insert_menu();
			break;
		}
		case "2": {
			delete_menu();
			break;
		}
		case "3": {
			update_menu();
			break;
		}
		case "4": {
			select_menu();
			break;
		}
		case "5": {
			System.out.println("Goodbye!");
			System.exit(0);
			break;
		}
		default:
			System.out.println("�������");
			break;
		}
	}

	public static void main(String[] args) {
    	try {
    		 Class.forName(JDBC_DRIVER);
    		 while(true) {
    			 menu();
    		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
