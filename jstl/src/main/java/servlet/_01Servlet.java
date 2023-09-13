package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/01")
public class _01Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 값
        int iVal = 10;
        long lVal = 10L;
        float fVal = 3.14f;
        double dVal = 3.14;
        boolean bVal = true;
        String sVal = "가나다라마바사";


        //객체
        UserVo userVo = new UserVo();
        userVo.setName("흰둥이");

//        request.setAttribute("obj", o);
        request.setAttribute("vo", userVo);
        //맵
        Map<String, Object> m = new HashMap<>();
        m.put("ival", iVal);
        m.put("fval", fVal);
        m.put("sval", sVal);

        request.setAttribute("vo", userVo);

        request.setAttribute("ival", iVal);
        request.setAttribute("lval", iVal);
        request.setAttribute("fval", iVal);
        request.setAttribute("dval", iVal);
        request.setAttribute("bval", iVal);
        request.setAttribute("sval", iVal);
        request
                .getRequestDispatcher("/WEB-INF/views/01.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}