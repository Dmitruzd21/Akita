package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Selenide.page;


@Name("Страница Логин")
public class LoginPageV2 extends AkitaPage {
    @Name("Логин")
    @FindBy(css = "[data-test-id=login] input")
    private SelenideElement loginField;
    @Name("Пароль")
    @FindBy(css = "[data-test-id=password] input")
    private SelenideElement passwordField;
    @Name("Продолжить")
    @FindBy(css = "[data-test-id=action-login]")
    private SelenideElement loginButton;

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }
}