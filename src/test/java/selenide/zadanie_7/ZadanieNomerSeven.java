package selenide.zadanie_7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ZadanieNomerSeven {

  @BeforeEach
  public void setUp(){

    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadTimeout = 800000;
    open("https://demoqa.com/automation-practice-form");


  }

  @Test
  public void positiveSelenideTest(){

    String firstName = "Alex";
    String lastName = "Coruzo";
    String email = "coruzo@gmail.com";
    String mobPhone = "9056587887";
    String subject = "b";
    String adress = "Bruklin 89";

    $x("//input[@placeholder='First Name']").setValue(firstName);
    $x("//input[@placeholder='Last Name']").setValue(lastName);
    $x("//input[@placeholder='name@example.com']").setValue(email);
    $x("//label[@for='gender-radio-1']").click();
    $x("//input[@placeholder='Mobile Number']").setValue(mobPhone);

    $x("//input[@id='dateOfBirthInput']").click();
    $x("//select[@class=\"react-datepicker__year-select\"]").click();
    $x("//option[@value='1999']").click();
    $x("//select[@class='react-datepicker__month-select']").click();
    $x("//option[@value='8']").click();
    $x("//div[@class='react-datepicker__day react-datepicker__day--023']").click();
    $x("//input[@id='subjectsInput']").setValue(subject);
    $x("//div[text()='Biology']").click();
    $x("//label[text()='Sports']").click();
    $x("//input[@type='file']").uploadFromClasspath("Penguins.jpg");
    $x("//textarea[@placeholder='Current Address']").setValue(adress);
    $x("//div[text()='Select State']").click();
    $x("//div[text()='NCR']").click();
    $x("//div[text()='Select City']").click();
    $x("//div[text()='Delhi']").click();
    $x("//button[@id='submit']").click();

    String extEmail = $x("//td[text()='Student Email']//following-sibling::td").getText();

    Assertions.assertEquals(email, extEmail);
  }
}
