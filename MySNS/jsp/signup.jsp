<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ page import="dao.UserDAO" %>
<%
request.setCharacterEncoding("utf-8");
String uid = request.getParameter("id");
String upass = request.getParameter("ps");
String upassCheck = request.getParameter("psCheck");
String uname = request.getParameter("name");
UserDAO dao = new UserDAO();
if (dao.exists(uid)) {
out.print("이미 가입한 회원입니다.");
return;
}
if(upass==upassCheck){
	if (dao.insert(uid, upass, uname)) {
			out.print("회원 가입이 완료되었습니다.");
		}
		else{
			out.print("회원 가입 중 오류가 발생하였습니다.");
		}	
}
else{
	out.print("비밀번호가 일치하지 않습니다.");
}

%>