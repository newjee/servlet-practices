package com.poscodx.guestbook02.dao;

import com.poscodx.emaillist01.vo.GuestBookVo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GuestBookDao {

    public List<GuestBookVo> findAll() {
        List<GuestBookVo> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            //3. SQL 준비
            String sql = "select no, name, password, contents, reg_date from guestbook order by no desc";
            pstmt = conn.prepareStatement(sql);

            //4. binding

            //5. SQL 실행
            rs = pstmt.executeQuery();

            //6. 결과 처리
            while(rs.next()) {

                Long no = rs.getLong(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String contents = rs.getString(4);
                String regDate = rs.getString(5);

                GuestBookVo vo = new GuestBookVo();

                vo.setNo(no);
                vo.setName(name);
                vo.setPassword(password);
                vo.setContents(contents);
                vo.setRegDate(regDate);

                result.add(vo);
            }

        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                // 7. 자원정리
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public void insert(GuestBookVo vo) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "insert into guestbook values(null, ?, ?, ?, now())";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getContents());

            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(GuestBookVo vo) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "delete from guestbook where no=? and password=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, vo.getNo());
            pstmt.setString(2,vo.getPassword());

            pstmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/shopping_db?charset=utf8";
            conn = DriverManager.getConnection(url, "shopping", "shopping");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패:" + e);
        }

        return conn;
    }
}