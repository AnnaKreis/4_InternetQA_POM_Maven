package internet.utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> invalidLoginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"tomsmith", "Password", "Your password is invalid!"});
        list.add(new Object[]{"", "", "Your username is invalid!"});
        return list.iterator();
    }
}
