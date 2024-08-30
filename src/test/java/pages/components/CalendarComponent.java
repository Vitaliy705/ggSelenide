package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    private SelenideElement yearLocator = $x("//select[@class='react-datepicker__year-select']");
    private String yearOptionLocator= "//option[@value='%s']";
    private SelenideElement monthLocator = $x("//select[@class='react-datepicker__month-select']");
    private String monthOptionLocator= "//option[@value='%s']";
    private String dayOptionLocator= "//div[@class='react-datepicker__day react-datepicker__day--%s']";


    public void setYear(String year){
        yearLocator.click();
        $x(String.format(yearOptionLocator, year)).click();
    }

    public void setMonth(String month){
        monthLocator.click();
        $x(String.format(monthOptionLocator, month)).click();
    }

    public void setDay(String day){
        $x(String.format(dayOptionLocator, day)).click();
    }
}
