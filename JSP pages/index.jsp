<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="java.sql.*" %>
    <%@ page import ="java.util.Date" %>  
    <%@ page import ="java.io.*" %>  
    <%@ page import ="java.io.FileNotFoundException" %>  
    <%@ page import ="java.io.IOException" %>  
    <%@ page import ="java.util.Iterator" %>  
    <%@ page import ="java.util.ArrayList" %> 
    <%@ page import="org.apache.poi.xssf.usermodel.*" %>
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFCell" %>  
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFRow" %>  
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFSheet" %>  
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>  
    <%@ page import ="org.apache.poi.poifs.filesystem.POIFSFileSystem" %>
    <%@ page import="org.apache.poi.ss.usermodel.Cell" %>
    <%@ page import ="org.apache.poi.ss.usermodel.Row"%>
    <%@ page import="org.apache.poi.ss.usermodel.Sheet" %>
    <%@ page import="org.apache.poi.ss.usermodel.Workbook" %>
    <%@ page import ="org.apache.poi.xssf.usermodel.XSSFWorkbook" %>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <%

    ArrayList cellArrayListHolder = new ArrayList (); 

    try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/my_manager","AkramYOUBI","AkramYOUBI1997");  
        String Path="upload";
        String absolutepath=getServletContext().getRealPath(Path);
        MultipartRequest   mr=new MultipartRequest(request,absolutepath);
        String filename=mr.getOriginalFileName("filename");
        FileInputStream myinput = new FileInputStream(new File(absolutepath+"/"+filename));
        Workbook workbook = new XSSFWorkbook(myinput);
        /*Create a workbook using myfilesystem  */
        /* Get the first sheet from workbook */
         Sheet firstSheet = workbook.getSheetAt(0);
        /*We need to something to iterate through the cell  */
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) 
        {
            XSSFRow nextRow =(XSSFRow)iterator.next();
            ArrayList rowarrylist=new ArrayList();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

             while (cellIterator.hasNext()) {
                 XSSFCell cell = (XSSFCell)cellIterator.next();
                 rowarrylist.add(cell);    
             }    
             cellArrayListHolder.add(rowarrylist);
        }
        out.println(cellArrayListHolder);
        ArrayList rowarrylist=null;
        PreparedStatement st=con.prepareStatement("INSERT INTO  export VALUES (?,?,?,?)");
        for(int i=1;i<cellArrayListHolder.size();i++)
        {  
                rowarrylist=(ArrayList)cellArrayListHolder.get(i);
                st.setString(1,rowarrylist.get(0)

.toString());
            st.setString(2,rowarrylist.get(1).toString());
            st.setString(3,rowarrylist.get(2).toString());
            st.setString(4,rowarrylist.get(3).toString());
            st.executeUpdate(); 
            } 
}
catch(Exception e)
{
    e.getMessage();
    out.println(e.getMessage());
}
%>
  
  
</body>
</html>