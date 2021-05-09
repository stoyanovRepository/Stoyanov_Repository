
import java.util.ArrayList;
import java.util.List;

public class SalesPersonRepository implements Repository{
      private  List<SalesPerson> salesPeople;

    protected SalesPersonRepository() {
        this.salesPeople = new ArrayList<>();
    }

    @Override
    public SalesPerson getByName(String name) {
        SalesPerson salesPerson = null;
        for(SalesPerson out: this.salesPeople){
            if(out.getName().equals(name)){
                salesPerson = out;
            }
        }
        return salesPerson;
    }

    @Override
    public List<SalesPerson> getAll() {
        return this.salesPeople;
    }

    @Override
    public void add(SalesPerson salesPerson) {
        salesPeople.add(salesPerson);
    }

    @Override
    public boolean removeByName(String name) {
        return this.salesPeople.removeIf(f -> f.getName().equals(name));
    }
}
