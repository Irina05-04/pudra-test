package by.bsu.fsc.Derecha.steps;

import by.bsu.fsc.Derecha.pages.PudraPage;
import org.openqa.selenium.WebDriver;

public class PudraStep extends PudraPage {

    public PudraStep(WebDriver driver) {
        super(driver);
    }

    public void goLogIn() {
        clickProfileBtn();
        clickEnterBtn();
    }
    public void checkEmptyFields() {
        goLogIn();
        clickEnterSubmit();
    }

    public void SubmitDate(String login, String password) {
        goLogIn();
        printLogin(login);
        printPsw(password);
        clickEnterSubmit();
    }
}
