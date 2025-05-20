package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDAO extends DAO {

    // 1件取得
    public Teacher get(String id) throws Exception {
        Teacher teacher = null;
        String sql = "SELECT id, name, password FROM teacher WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
            }
        }

        return teacher;
    }

    // ログイン認証
    public Teacher login(String id, String password) throws Exception {
        Teacher teacher = null;
        String sql = "SELECT id, name, password FROM teacher WHERE id = ? AND password = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setName(rs.getString("name"));
                teacher.setPassword(rs.getString("password"));
            }
        }

        return teacher;
    }
}
