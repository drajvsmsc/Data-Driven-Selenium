package com.framework1;

import com.framework1.TestComponents.Intializedr;
import com.framework1.pageobject.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test1 extends Intializedr {




    @Test(dataProvider = "streamData")
    public void SubmitOrder(HashMap<String, String> map) throws IOException, InterruptedException {

        LoginPage lpage = Landingpg();
        CatalogePage catpg = lpage.login(map.get("email"),map.get("password"));
        Viewcartpage vcpg= catpg.addproducttocart(map.get("productname"));
        Checkoutpage cpg= vcpg.checkout(map.get("productname"));
        cpg.place_or(map.get("Contry"));
       // Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] streamData() throws IOException {

        List<HashMap<String, String>> data= readJSON();

        return new Object[][] {{data.get(0)}};
                //{{"Zara coat 3"},{"adidas original"},{"iphone 13 pro"}}

    }


}
