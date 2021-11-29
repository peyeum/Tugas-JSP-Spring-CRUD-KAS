// Package
package kasapp.dao;

// Dependency
import java.util.List;
import kasapp.model.UserLogin;
import kasapp.model.Kas;

// Interface
public interface KasDAO {

    // login
    UserLogin getLogin(String username, String password);

    // Kas Masuk
    List<Kas> getKasIn();

    Kas getaKasIn(int id);

    boolean kasInEntry(Kas kasIn);

    boolean kasInUpdate(Kas kasIn);

    boolean kasInDelete(int id);

    // Kas Keluar
    List<Kas> getKasOut();

    Kas getaKasOut(int id);

    boolean kasOutEntry(Kas kasOut);

    boolean kasOutUpdate(Kas kasOut);

    boolean kasOutDelete(int id);

    // Sum data from kas_in and kas_out
    int sumIn();

    int sumOut();

}
