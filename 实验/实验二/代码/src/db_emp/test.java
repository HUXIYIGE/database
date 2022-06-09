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