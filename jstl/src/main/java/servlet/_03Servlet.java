package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/03")
public class _03Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserVo> list = new ArrayList<>();

        UserVo vo1 = new UserVo();
        vo1.setNo(1L);
        vo1.setName("세균맨");
        list.add(vo1);

        //session
        UserVo vo2 = new UserVo();
        vo1.setNo(2L);
        vo1.setName("세균맨2");
        list.add(vo2);

        //application
        UserVo vo3 = new UserVo();
        vo1.setNo(3L);
        vo1.setName("세균맨3");
        list.add(vo3);


        request.setAttribute("list", list);
        request
                .getRequestDispatcher("/WEB-INF/views/03.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}