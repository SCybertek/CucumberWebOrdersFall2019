package com.weborders.step_definitions;


import com.weborders.pages.OrdersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddOrderStepDefinitions {

    OrdersPage orderPage = new OrdersPage();

    //      | Product     | Quantity | Price per unit | Discount |
    @When("user enters product information:")
    public void user_enters_product_information(List<Map< String, String>> dataTable) {
        Map<String, String> values = dataTable.get(0);
        orderPage.setProductType(values.get("Product"));
        orderPage.enterQuantity(values.get("Quantity"));
        orderPage.enterPricePerUnit(values.get("Price per unit"));
        orderPage.enterDiscount(values.get("Discount" ));
    }



    @When("user enters address information:")
    public void user_enters_address_information(List<Map<String, String>> dataTable) {
        Map<String, String> values = dataTable.get(0);
        orderPage.enterAddressInformation(values.get("Customer name"),
                values.get("String"),
                values.get("City"),
                values.get("State"),
                values.get("Zip")
                );
    }

    // | Card | Card Nr:    | Expire date (mm/yy) | = keys
    //      | Visa | 12345667890 | 04/25               | = value
    @When("user enters payment information:")
    public void user_enters_payment_information(List <Map<String, String >> dataTable) {

        Map<String, String> paymentInfo = dataTable.get(0); // excluding first row - where keys are located
        orderPage.enterPaymentInformation(paymentInfo.get("Card"),
                paymentInfo.get("Card Nr:"),
                paymentInfo.get("Expire date (mm/yy)"));

    }

    @When("user click on process button")
    public void user_click_on_process_button() {
        orderPage.clickOnProcessButton();
    }



    @Then("user verifies that order is displayed")
    public void user_verifies_that_order_is_displayed(List<Map<String, String>> dataTable){

    }

    @When("user click on calculate button")
    public void user_click_on_calculate_button() {
        orderPage.clickToCalculate();
    }

    @Then("user should verify that total {int} is displayed")
    public void user_should_verify_that_total_is_displayed(Integer int1) {
        Assert.assertEquals(String.valueOf(int1), orderPage.getTotal());
    }
}
