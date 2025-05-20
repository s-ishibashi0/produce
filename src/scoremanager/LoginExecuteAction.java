package scoremanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

public class LoginExecuteAction implements Action {
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        try {
            // フォームから送られたパラメータを取得
            int id = Integer.parseInt(req.getParameter("id"));
            String password = req.getParameter("password");

            // DAOで認証チェック
            TeacherDAO dao = new TeacherDAO();
            Teacher teacher = dao.search(id, password);

            if (teacher != null) {
                // 認証成功 → セッションに保存してホームへ
                HttpSession session = req.getSession();
                session.setAttribute("teacher", teacher);
                return "/index.jsp";
            } else {
                // 認証失敗 → エラーメッセージ設定してエラーページへ
                req.setAttribute("error", "ログインIDまたはパスワードが違います。");
                return "/error.jsp";
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "IDの形式が不正です。");
            return "/error.jsp";
        }
    }
}