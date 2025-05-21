package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDAO extends DAO {
    public Teacher search(String id, String password) throws Exception {
        Teacher teacher = null;

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
            "select * from teacher where id=? and password=?");
        st.setString(1, id);
        st.setString(2, password);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            teacher = new Teacher();
            teacher.setID(rs.getString("id"));  // Stringとして受け取る
            // teacher.setLogin(rs.getString("login")); // もしloginフィールドがあれば。無ければ削除
            teacher.setPassword(rs.getString("password"));
            teacher.setName(rs.getString("name"));  // もしTeacherクラスにnameフィールドがあればセット
            teacher.setSchoolCd(rs.getString("school_cd")); // 同様に必要なら
        }

        rs.close();
        st.close();
        con.close();

        return teacher;
    }
}
