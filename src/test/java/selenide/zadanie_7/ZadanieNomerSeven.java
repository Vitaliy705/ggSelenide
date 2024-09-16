package selenide.zadanie_7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

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
    String subject = "Biology";
    String address = "Bruklin 89";
    String gender = "Male";
    String a = "ff";
    String hobby = "Sports";
    String fileName = "Penguins.jpg";
    String stateName = "NCR";
    String cityName = "Delhi";
    String year = "1999";
    String month = "8";
    String day = "029";
    String titleModalText = "Thanks for submitting the form";

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    practiceFormPage
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setMobilePhone(mobPhone)
            .setSubject(subject)
            .setHobby(hobby)
            .setPicture(fileName)
            .setAddress(address)
            .setState(stateName)
            .setCity(cityName)
            .setDateOfBirth(year, month, day)
            .btnSubmitClick()
            .assertTitleModalForm(titleModalText)
            .assertTableModalForm("Mobile", mobPhone)
            .assertTableModalForm("Gender", gender)
            .closeModalForm();

    // String extEmail = $x("//td[text()='Student Email']//following-sibling::td").getText();
    // Assertions.assertEquals(email, extEmail);
  }
}
