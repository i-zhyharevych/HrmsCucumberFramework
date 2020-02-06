package com.hrms.steps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
public class TestSteps {
    @Given("I do something before every Scenario in this feature file")
    public void backgroundMethod() {
        System.out.println("Background is running!!!");
    }
    @When("I do some step")
    public void i_do_some_step() {
        System.out.println("I do some step");
    }
    @When("another step")
    public void another_step(DataTable table) {
        System.out.println("another step");
        System.out.println(table);
        System.out.println("asList");
        System.out.println(table.asList());
        System.out.println("asLists");
        System.out.println(table.asLists());
        for (List<String> row : table.asLists()) {
//          System.out.println(row);
            for (String cell : row) {
                System.out.print(cell + ", ");
            }
            System.out.println();
        }
        System.out.println("asMaps");
        System.out.println(table.asMaps());
        List<Map<String, String>> mapList = table.asMaps();
        for (Map<String, String> map : mapList) {
            System.out.println();
            System.out.println(map);
            Set<String> keys = map.keySet();
            System.out.println("keys: " + keys);
            Collection<String> values = map.values();
            System.out.println("values: " + values);
            for (String key : keys) {
                System.out.println(key + " -> " + map.get(key));
            }
        }
        System.out.println("rows(0, 2)");
        System.out.println(table.rows(0, 2));
        System.out.println("row(1)");
        System.out.println(table.row(1));
    }
    @Then("I validate the outcomes")
    public void i_validate_the_outcomes(DataTable table2) {
        System.out.println("I validate the outcomes");
        System.out.println(table2);
        // HW
        // Try asList, asLists, asMaps
        // Extra credit: Iterate them
    }
    @When("I check for the {int} in step")
    public void i_check_for_the_in_step(Integer value) {
        System.out.println("I check for the {int} in step");
        System.out.println(value);
    }
    @Then("I verify that for value {int}, the result {string}")
    public void i_verify_that_for_value_the_result(Integer value, String result) {
        System.out.println("I verify that for value {int}, the result {string}");
        System.out.println(value + " " + result);
        System.out.println();
        String expected = "Success";
        Assert.assertEquals(expected, result);
    }
}