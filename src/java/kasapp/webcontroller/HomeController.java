// Package
package kasapp.webcontroller;

// Dependency
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kasapp.dao.KasDAO;
import kasapp.dao.KasDAOProcess;
import kasapp.model.UserLogin;
import kasapp.model.CurrentDate;
import kasapp.model.Kas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// class
public class HomeController {

    KasDAO kasDAO = null;

    public HomeController() {
        kasDAO = new KasDAOProcess();
    }

    private int getSumIn() {
        return kasDAO.sumIn();
    }

    private int getSumOut() {
        return kasDAO.sumOut();
    }

    private int getSum() {
        return kasDAO.sumIn() - kasDAO.sumOut();
    }

    private String tanggal() {
        return CurrentDate.getTanggal();
    }

    // private method menampilkan list 5 transaksi kas masuk dan keluar pada home
    private ModelAndView listKasFlow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        List<Kas> in = kasDAO.getKasIn(); // get kas masuk list
        List<Kas> out = kasDAO.getKasOut(); // get kas keluar list
        List<Kas> latestIn = new ArrayList<>();
        List<Kas> latestOut = new ArrayList<>();

        // add just 5 or less kas data to new list
        for (int i = 1; i <= 5; i++) {
            if (!in.isEmpty() && i <= in.size()) {
                latestIn.add(in.get(in.size() - i));
            }
            if (!out.isEmpty() && i <= out.size()) {
                latestOut.add(out.get(out.size() - i));
            }
        }

//        for (int j = 0; j < latestIn.size(); j++) {
//            latestIn.get(j).setId(in.size() - j); // change the id to number
//        }
//
//        for (int j = 0; j < latestOut.size(); j++) {
//            latestOut.get(j).setId(out.size() - j); // change the id to number
//        }
        modelAndView.addObject("listKasMasuk", latestIn);
        modelAndView.addObject("listKasKeluar", latestOut);
        modelAndView.addObject("tanggal", tanggal());
        modelAndView.addObject("totalKasM", getSumIn());
        modelAndView.addObject("totalKasK", getSumOut());
        modelAndView.addObject("totalSaldo", getSum());
        modelAndView.addObject("home", "bg-secondary");
        return modelAndView;
    }

    // private method menampilkan list kas masuk
    private ModelAndView listKasMasuk(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Kas> thelist = kasDAO.getKasIn();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listKasMasuk", thelist);
        modelAndView.addObject("tanggal", tanggal());
        modelAndView.addObject("totalKasM", getSumIn());
        modelAndView.addObject("totalKasK", getSumOut());
        modelAndView.addObject("totalSaldo", getSum());
        modelAndView.addObject("inkas", "bg-secondary");
        return modelAndView;
    }

    // private method menampilkan list kas keluar
    private ModelAndView listKasKeluar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Kas> thelist = kasDAO.getKasOut();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listKasKeluar", thelist);
        modelAndView.addObject("tanggal", tanggal());
        modelAndView.addObject("totalKasM", getSumIn());
        modelAndView.addObject("totalKasK", getSumOut());
        modelAndView.addObject("totalSaldo", getSum());
        modelAndView.addObject("outkas", "bg-secondary");
        return modelAndView;
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ModelAndView loginPage = new ModelAndView("redirect:/login.page");

        if (session == null) {
            return loginPage;
        } else {
            UserLogin user = (UserLogin) session.getAttribute("user");
            if (user.getRole().equalsIgnoreCase("admin")) {
                return listKasFlow(req, res);
            } else {
                return new ModelAndView("redirect:/member.page");
            }
        }
    }

    @RequestMapping(value = "/inkas")
    public ModelAndView kasmasuk(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return new ModelAndView("redirect:/login.page");
        }
        return listKasMasuk(req, res);
    }

    @RequestMapping(value = "/outkas")
    public ModelAndView kaskeluar(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return new ModelAndView("redirect:/login.page");
        }
        return listKasKeluar(req, res);

    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);
        ModelAndView loginPage = new ModelAndView("redirect:/login.page");
        if (session == null) {
            return loginPage;
        } else {
            session.invalidate();
            return loginPage;
        }
    }
}
