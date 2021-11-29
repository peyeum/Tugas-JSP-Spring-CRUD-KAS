// package
package kasapp.webcontroller;

// Dependency
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kasapp.dao.KasDAO;
import kasapp.dao.KasDAOProcess;
import kasapp.model.LoginModel;
import kasapp.model.UserLogin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// class
public class LoginController {

    // Data Access Object for user
    KasDAO userDao = null;

    public LoginController() {
        userDao = new KasDAOProcess();
    }

    // Mapping for login page load
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", "<label class='w-100 my-2 alert alert-danger'>" + req.getParameter("message") + "</label>");
            return modelAndView;
        }
        return new ModelAndView();
    }

    // Mapping for submitted login form using POST method
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("emp") LoginModel emp, HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login.page");
        if (emp.getUsername() != null && emp.getPassword() != null) {
            UserLogin user = userDao.getLogin(emp.getUsername(), emp.getPassword());
            if (user != null) {
                modelAndView.addObject("user", user);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30 * 60);

                if (user.getRole().equalsIgnoreCase("admin")) {
                    return new ModelAndView("redirect:/home.page");
                } else {
                    return new ModelAndView("redirect:/member.page");
                }

            } else {
                modelAndView.addObject("message", "Username atau Password Salah!");
            }
        } else {
            modelAndView.addObject("message", "Username dan Password Tidak Boleh Kosong!");
        }
        return modelAndView;
    }
}
