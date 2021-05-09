import java.util.Collection;
import java.util.List;

public interface Repository {
    SalesPerson getByName(String name);

    List<SalesPerson> getAll();

    void add(SalesPerson salesPerson);

    boolean removeByName(String name);
}
