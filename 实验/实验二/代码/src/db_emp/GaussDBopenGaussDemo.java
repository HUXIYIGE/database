package db_emp;
import java.sql.*;
import java.util.*;

public class GaussDBopenGaussDemo{
 
    static final String JDBC_DRIVER = "org.postgresql.Driver";  
    static final String DB_URL = "jdbc:postgresql://124.71.229.93:8000/finance?ApplicationName=app1";
      // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "Xiesj20011104?!";
    //select 
    public static void select_employee() {
    	System.out.println("------查询职工信息表------");
		System.out.println("输入对应数字选择查询功能：");
    	System.out.println("1：全部查找");
    	System.out.println("2：精确查找");
    	System.out.println("请输入数字：");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from employee;";
			break;
		}
		case "2": {
			System.out.println("输入员工姓名");
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
                // 通过字段检索
		    	String id  = rs.getString("eid");
                String name = rs.getString("ename");
                String birth = rs.getString("birth");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String mail = rs.getString("mail");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 名称: " + name);
                System.out.print(", 生日: " + birth);
                System.out.print(", 性别: " + gender);
                System.out.print(", 电话号码: " + phone);
                System.out.print(", 电子邮箱: " + mail);
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
    	System.out.println("------查询部门信息表------");
		System.out.println("输入对应数字选择查询功能：");
    	System.out.println("1：全部查找");
    	System.out.println("2：精确查找");
    	System.out.println("请输入数字：");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from department;";
			break;
		}
		case "2": {
			System.out.println("输入部门名称");
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
                // 通过字段检索
		    	String id  = rs.getString("did");
                String name = rs.getString("dname");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 名称: " + name);
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
    	System.out.println("------查询公司职位表------");
		System.out.println("输入对应数字选择查询功能：");
    	System.out.println("1：全部查找");
    	System.out.println("2：精确查找");
    	System.out.println("请输入数字：");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from position;";
			break;
		}
		case "2": {
			System.out.println("输入职位名称");
			String name=input.next();
			sql+="* from position ";
			sql+="where pname='";
			sql+=name;
			sql+="' and ";
			System.out.println("输入部门id");
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
                // 通过字段检索
		    	String pid  = rs.getString("pid");
		    	String did  = rs.getString("did");
                String name = rs.getString("pname");
                String salary = rs.getString("salary");
    
                // 输出数据
                System.out.print(" PID: " + pid);
                System.out.print(" , DID: " + did);
                System.out.print(" , 职位名称: " + name);
                System.out.print(" , 薪水: " + salary);
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
    	System.out.println("------查询职工就职表------");
		System.out.println("输入对应数字选择查询功能：");
    	System.out.println("1：全部查找");
    	System.out.println("2：精确查找");
    	System.out.println("请输入数字：");
    	Scanner input=new Scanner(System.in);
    	String func=input.next();
    	String sql="SELECT ";
    	switch (func) {
		case "1": {
			sql+="* from employment;";
			break;
		}
		case "2": {
			System.out.println("输入员工id");
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
                // 通过字段检索
		    	String eid  = rs.getString("eid");
		    	String pid  = rs.getString("pid");
                String experience = rs.getString("experience");
    
                // 输出数据
                System.out.print("EID: " + eid);
                System.out.print(" , PID: " + pid);
                System.out.print(" , 经历: " + experience);
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
    	System.out.println("------查询记录------");
		System.out.println("输入对应数字选择查询表格：");
    	System.out.println("1：employee");
    	System.out.println("2：department");
    	System.out.println("3：position");
    	System.out.println("4：employment");
    	System.out.println("请输入数字：");
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
			System.out.println("输入错误");
			break;
		}
    }
    
    //insert
	public static void insert_employee() {
		System.out.println("------添加职工信息------");
		System.out.println("请输入职工编号：");
		Scanner input=new Scanner(System.in);
		String eid=input.next();
		System.out.println("请输入职工姓名：");
		String ename=input.next();
		System.out.println("请输入职工生日：");
		String birth=input.next();
		System.out.println("请输入职工性别：");
		String gender=input.next();
		System.out.println("请输入职工电话号码：");
		String phone=input.next();
		System.out.println("请输入职工电子邮箱：");
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
				System.out.println("记录添加成功");
			}
			else {
				System.out.println("记录添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert_department() {
		System.out.println("------添加部门信息------");
    	System.out.println("请输入部门编号：");
    	Scanner input=new Scanner(System.in);
    	String did=input.next();
    	System.out.println("请输入部门名称：");
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
            	System.out.println("记录添加成功");
            }
            else {
            	System.out.println("记录添加失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert_position() {
		System.out.println("------添加职位信息------");
    	System.out.println("请输入职位id：");
    	Scanner input=new Scanner(System.in);
    	String pid=input.next();
    	System.out.println("请输入部门id：");
    	String did=input.next();
    	System.out.println("请输入职位名称：");
    	String pname=input.next();
    	System.out.println("请输入薪水：");
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
            	System.out.println("记录添加成功");
            }
            else {
            	System.out.println("记录添加失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert_employment() {
		System.out.println("------添加就职信息------");
    	System.out.println("请输入职工id：");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	System.out.println("请输入职位id：");
    	String pid=input.next();
    	System.out.println("请输入经历：");
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
            	System.out.println("记录添加成功");
            }
            else {
            	System.out.println("记录添加失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void insert_menu() {
    	System.out.println("------添加记录------");
		System.out.println("输入对应数字选择添加表格：");
    	System.out.println("1：employee");
    	System.out.println("2：department");
    	System.out.println("3：position");
    	System.out.println("4：employment");
    	System.out.println("请输入数字：");
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
			System.out.println("输入错误");
			break;
		}
    }
    
    //update
    public static void update_employee() {
    	String sql="update employee set ";
    	System.out.println("------更新职工信息------");
    	System.out.println("请输入职工编号：");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	System.out.println("是否更新名字：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c1=input.next();
    	System.out.println(c1);
    	switch(c1) {
    		case "1":{
    			System.out.println("请输入姓名：");
        		String ename=input.next();
        		sql+="ename='"+ename+
        		"',";
        		break;
    		}
        	default:{
        		break;
        	}
    	}		
    	System.out.println("是否更新生日：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c2=input.next();
    	switch(c2) {
		case "1":{
			System.out.println("请输入生日：");
    		String birth=input.next();
    		sql+="birth='"+birth+
    		"',";
    		break;
		}
    	default:
    		break;
    	}
    	System.out.println("是否更新性别：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c3=input.next();
    	switch (c3) {
		case "1": {
			System.out.println("请输入性别：");
    		String gender=input.next();
    		sql+="gender='"+gender+
    				"',";
    		break;
		}
		default:
			break;
		}
    	System.out.println("是否更新电话号码：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c4=input.next();
    	switch (c4) {
		case "1": {
			
			System.out.println("请输入电话号码：");
    		String phone=input.next();
    		sql+="phone='"+phone+
    				"',";
    		break;
		}
		default:
			break;
		}
    	System.out.println("是否更新电子邮箱：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c5=input.next();
    	switch (c5) {
		case "1": {
			System.out.println("请输入电子邮箱：");
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
            	System.out.println("记录更新成功");
            }
            else {
            	System.out.println("记录更新失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	public static void update_department() {
		
    	System.out.println("------更新部门信息------");
    	System.out.println("请输入部门id：");
    	Scanner input=new Scanner(System.in);
    	String did=input.next();
    	System.out.println("请输入新的部门名称：");
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
            	System.out.println("记录更新成功");
            }
            else {
            	System.out.println("记录更新失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update_position() {
		String sql="update position set ";
    	System.out.println("------更新职位信息------");
    	System.out.println("请输入职位id：");
    	Scanner input=new Scanner(System.in);
    	String pid=input.next();
    	System.out.println("是否更新部门id：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c1=input.next();
    	System.out.println(c1);
    	switch(c1) {
    		case "1":{
    			System.out.println("请输入部门id：");
        		String did=input.next();
        		sql+="did='"+did+
        		"',";
        		break;
    		}
        	default:{
        		break;
        	}
    	}		
    	System.out.println("是否职位名称：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c2=input.next();
    	switch(c2) {
		case "1":{
			System.out.println("请输入职位名称：");
    		String pname=input.next();
    		sql+="pname='"+pname+
    		"',";
    		break;
		}
    	default:
    		break;
    	}
    	System.out.println("是否更新薪水：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c3=input.next();
    	switch (c3) {
		case "1": {
			System.out.println("请输入薪水：");
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
            	System.out.println("记录更新成功");
            }
            else {
            	System.out.println("记录更新失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update_employment() {
		String sql="update employment set ";
    	System.out.println("------更新就职信息------");
    	System.out.println("请输入职工id：");
    	Scanner input=new Scanner(System.in);
    	String eid=input.next();
    	System.out.println("是否更新职位id：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c1=input.next();
    	System.out.println(c1);
    	switch(c1) {
    		case "1":{
    			System.out.println("请输入职位id：");
        		String pid=input.next();
        		sql+="pid='"+pid+
        		"',";
        		break;
    		}
        	default:{
        		break;
        	}
    	}		
    	System.out.println("是否更新经历：");
    	System.out.println("1：是");
    	System.out.println("2：否");
    	String c2=input.next();
    	switch(c2) {
		case "1":{
			System.out.println("请输入经历：");
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
            	System.out.println("记录更新成功");
            }
            else {
            	System.out.println("记录更新失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static void update_menu() {
    	System.out.println("------更新记录------");
		System.out.println("输入对应数字选择更新表格：");
    	System.out.println("1：employee");
    	System.out.println("2：department");
    	System.out.println("3：position");
    	System.out.println("4：employment");
    	System.out.println("请输入数字：");
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
			System.out.println("输入错误");
			break;
		}
    }
    
    //delete
    public static void delete_employee() {
    	System.out.println("请输入职工id：");
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
            	System.out.println("记录删除成功");
            }
            else {
            	System.out.println("记录删除失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_department() {
    	System.out.println("请输入部门id：");
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
            	System.out.println("记录删除成功");
            }
            else {
            	System.out.println("记录删除失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_position() {
    	System.out.println("请输入职位id：");
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
            	System.out.println("记录删除成功");
            }
            else {
            	System.out.println("记录删除失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_employment() {
    	System.out.println("请输入职工id：");
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
            	System.out.println("记录删除成功");
            }
            else {
            	System.out.println("记录删除失败");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void delete_menu() {
    	System.out.println("------删除记录------");
		System.out.println("输入对应数字选择表格：");
    	System.out.println("1：employee");
    	System.out.println("2：department");
    	System.out.println("3：position");
    	System.out.println("4：employment");
    	System.out.println("请输入数字：");
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
			System.out.println("输入错误");
			break;
		}
    }
    
	public static void menu() {
		System.out.println("------员工管理系统------");
		System.out.println("输入对应数字选择功能：");
		System.out.println("1：添加记录");
		System.out.println("2：删除记录");
		System.out.println("3：修改记录");
		System.out.println("4：查询记录");
		System.out.println("请输入数字：");
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
			System.out.println("输入错误");
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
