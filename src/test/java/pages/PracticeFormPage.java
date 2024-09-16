package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalRegistrationForm;

import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    ModalRegistrationForm modalRegistrationForm = new ModalRegistrationForm();

    private SelenideElement firstNameLocator = $x("//input[@placeholder='First Name']");
    private SelenideElement lastNameLocator = $x("//input[@placeholder='Last Name']");
    private SelenideElement emailLocator =  $x("//input[@placeholder='name@example.com']");
    private String genderLocator = "//label[text()='%s']";
    private SelenideElement mobilePhoneLocator =  $x("//input[@placeholder='Mobile Number']");
    private SelenideElement subjectLocator = $x("//input[@id='subjectsInput']");
    private String subjectOptionLocator = "//div[@tabindex='-1'][text()='%s']";
    private String hobbiesLocator = "//label[text()='%s']";
    private SelenideElement pictureLocator = $x("//input[@type='file']");
    private SelenideElement addressLocator =  $x("//textarea[@placeholder='Current Address']");
    private String selectStateOptionLocator =  "//div[text()='%s']";
    private SelenideElement selectStateLocator =  $x("//div[text()='Select State']");
    private String selectCityOptionLocator =  "//div[text()='%s']";
    private SelenideElement selectCityLocator =  $x("//div[text()='Select City']");
    private SelenideElement btnSubmitLocator =  $x("//button[@id='submit']");
    private SelenideElement dateOfBirthLocator = $x("//input[@id='dateOfBirthInput']");

    public PracticeFormPage setFirstName(String firstName){
        firstNameLocator.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName){
        lastNameLocator.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email){
        emailLocator.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender){
        $x(String.format(genderLocator, gender)).click();
        return this;
    }

    public PracticeFormPage setMobilePhone(String mobPhone){
        mobilePhoneLocator.setValue(mobPhone);
        return this;
    }

    public PracticeFormPage setSubject(String subject){
        subjectLocator.setValue(subject);
        $x(String.format(subjectOptionLocator, subject)).click();
        return this;
    }

    public PracticeFormPage setHobby(String hobby){
        $x(String.format(hobbiesLocator, hobby)).click();
        return this;
    }

    public PracticeFormPage setPicture(String file){
        pictureLocator.uploadFromClasspath(file);
        return this;
    }

    public PracticeFormPage setAddress(String address){
        addressLocator.setValue(address);
        return this;
    }

    public PracticeFormPage setState(String stateName){
        selectStateLocator.click();
        $x(String.format(selectStateOptionLocator, stateName)).click();
        return this;
    }

    public PracticeFormPage setCity(String cityName){
        selectCityLocator.click();
        $x(String.format(selectCityOptionLocator, cityName)).click();
        return this;
    }

    public PracticeFormPage btnSubmitClick() {
        btnSubmitLocator.click();
        return this;
    }

    public PracticeFormPage setDateOfBirth(String year, String month, String day){
        dateOfBirthLocator.click();
        calendarComponent.setYear(year);
        calendarComponent.setMonth(month);
        calendarComponent.setDay(day);
        return this;
    }

    public PracticeFormPage assertTitleModalForm(String titleModal){
        modalRegistrationForm.assertTitle(titleModal);
        return this;
    }

    public PracticeFormPage assertTableModalForm(String label, String values){
        modalRegistrationForm.assertLabelAndValues(label, values);
        return this;
    }

    public PracticeFormPage closeModalForm(){
        modalRegistrationForm.closeModalForm();
        return this;
    }


}
