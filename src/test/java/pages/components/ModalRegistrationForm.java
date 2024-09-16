package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ModalRegistrationForm {

    private SelenideElement titleModalFormLocator = $x("//div[text()='Thanks for submitting the form']");
    private String anyLabelOnTableLocator = "//td[text()='%s']/preceding-sibling::td";
    private SelenideElement btnCloseLocator = $x("//button[text()='Close']");

    public void assertTitle(String titleString) {
        titleModalFormLocator.shouldHave(Condition.text(titleString));
    }

    public void assertLabelAndValues(String label, String values){
        $x(String.format(anyLabelOnTableLocator, values)).shouldHave(Condition.text(label));
    }

    public void closeModalForm(){
        btnCloseLocator.click();
    }
}

