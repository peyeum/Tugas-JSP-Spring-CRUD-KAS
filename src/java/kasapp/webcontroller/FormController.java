// Package
package kasapp.webcontroller;

// Dependency
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kasapp.dao.KasDAO;
import kasapp.dao.KasDAOProcess;
import kasapp.model.CurrentDate;
import kasapp.model.Kas;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// Class
public class FormController {

    KasDAO kasDao = null;

    public FormController() {
        kasDao = new KasDAOProcess();
    }

    // private method untuk kas masuk
    private ModelAndView kasInEntry(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("act", "Entry");
        modelAndView.addObject("date", CurrentDate.getDate());
        if (req.getParameter("message") != null) {
            modelAndView.addObject("message", req.getParameter("message"));
            return modelAndView;
        }
        return modelAndView;
    }

    private ModelAndView kasInEdit(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        Kas kasMasuk = kasDao.getaKasIn(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("act", "Edit");
        modelAndView.addObject("kasMasuk", kasMasuk);
        return modelAndView;
    }

    private ModelAndView kasInDelete(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        if (kasDao.kasInDelete(Integer.parseInt(id))) {
            return new ModelAndView("redirect:/inkas.page");
        } else {
            req.setAttribute("message", "Gagal Delete!");
            return kasInEntry(req, res);
        }
    }

    // mapping untuk kas masuk
    @RequestMapping(value = "/inkas/form")
    public ModelAndView indexKasMasuk(HttpServletRequest req, HttpServletResponse res) {
        String action = req.getParameter("action");
        ModelAndView modelAndView;
        if (action == null) {
            action = "add";
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            return new ModelAndView("redirect:/login.page");
        }

        switch (action.toUpperCase()) {
            case "EDIT":
                modelAndView = kasInEdit(req, res);
                break;
            case "DELETE":
                modelAndView = kasInDelete(req, res);
                break;
            default:
                modelAndView = kasInEntry(req, res);
                break;
        }

        return modelAndView;

    }

    @RequestMapping(value = "/inkas/form", method = RequestMethod.POST)
    public ModelAndView kasInSave(@ModelAttribute("kasin") Kas kasin) {
        ModelAndView modelAndView = new ModelAndView("redirect:/inkas/form.page");
        if (kasin.getId() != 0) {
            if (kasDao.kasInUpdate(kasin)) {
                return new ModelAndView("redirect:/inkas.page");
            } else {
                modelAndView.addObject("message", "Error Save");
            }
        } else {
            if (kasDao.kasInEntry(kasin)) {
                return new ModelAndView("redirect:/inkas.page");
            } else {
                modelAndView.addObject("message", "Error Save");
            }
        }
        return modelAndView;
    }

    // private method untuk kas keluar
    private ModelAndView kasOutEntry(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("act", "Entry");
        modelAndView.addObject("date", CurrentDate.getDate());
        if (req.getParameter("message") != null) {
            modelAndView.addObject("message", req.getParameter("message"));
            return modelAndView;
        }
        return modelAndView;
    }

    private ModelAndView kasOutEdit(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        Kas kasKeluar = kasDao.getaKasOut(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("act", "Edit");
        modelAndView.addObject("kasKeluar", kasKeluar);
        return modelAndView;
    }

    private ModelAndView kasOutDelete(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        if (kasDao.kasOutDelete(Integer.parseInt(id))) {
            return new ModelAndView("redirect:/outkas.page");
        } else {
            req.setAttribute("message", "Gagal Delete!");
            return kasOutEntry(req, res);
        }
    }

    // mapping untuk kas keluar
    @RequestMapping(value = "/outkas/form")
    public ModelAndView indexKasKeluar(HttpServletRequest req, HttpServletResponse res) {
        String action = req.getParameter("action");
        ModelAndView modelAndView;
        if (action == null) {
            action = "add";
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            return new ModelAndView("redirect:/login.page");
        }

        switch (action.toUpperCase()) {
            case "EDIT":
                modelAndView = kasOutEdit(req, res);
                break;
            case "DELETE":
                modelAndView = kasOutDelete(req, res);
                break;
            default:
                modelAndView = kasOutEntry(req, res);
                break;
        }

        return modelAndView;

    }

    @RequestMapping(value = "/outkas/form", method = RequestMethod.POST)
    public ModelAndView kasOutSave(@ModelAttribute("kasout") Kas kasout) {
        ModelAndView modelAndView = new ModelAndView("redirect:/outkas/form.page");
        if (kasout.getId() != 0) {
            if (kasDao.kasOutUpdate(kasout)) {
                return new ModelAndView("redirect:/outkas.page");
            } else {
                modelAndView.addObject("message", "Error Save");
            }
        } else {
            if (kasDao.kasOutEntry(kasout)) {
                return new ModelAndView("redirect:/outkas.page");
            } else {
                modelAndView.addObject("message", "Error Save");
            }
        }
        return modelAndView;
    }
}
