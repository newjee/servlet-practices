package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/02")
public class _02Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 객체의 scope
        // 2. 객체가 오래 지속되는 순서
        //application(context) >> Session>> request>>page

        //3. el이 이름으로 객체를 찾는 순서 : 2번 반대

        //4. 주의 : 같은 이름으로 여러 범위의 객체를 저장하는 경우 주의가 필요함\

        // request scope
        UserVo vo1 = new UserVo();
        vo1.setNo(1L);
        vo1.setName("세균맨");

        request.setAttribute("vo", vo1);

        //session
        UserVo vo2 = new UserVo();
        vo1.setNo(2L);
        vo1.setName("세균맨2");

        request.getSession(true).setAttribute("vo", vo2);

        //application
        UserVo vo3 = new UserVo();
        vo1.setNo(3L);
        vo1.setName("세균맨3");

        request.getServletContext().setAttribute("vo", vo3);


        request
                .getRequestDispatcher("/WEB-INF/views/02.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}