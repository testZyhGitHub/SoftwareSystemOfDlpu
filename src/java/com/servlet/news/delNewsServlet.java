/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet.news;

import com.yt.connectdb.dbOperator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 挺
 */
public class delNewsServlet extends HttpServlet {
    private dbOperator db = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        db = new dbOperator();
        String data="";
        PrintWriter out = response.getWriter();
        int nid = Integer.parseInt(request.getParameter("nid"));
        String sql = "delete from news where news_id='"+nid+"'";
        if(db.SqlQuery(sql)!=0){
            data="{\"data\":\"1\"}";
        }else{
            data="{\"data\":\"0\"}";
        }
        out.println(data);
    }
    
}
