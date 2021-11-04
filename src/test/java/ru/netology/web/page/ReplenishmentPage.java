package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Selenide.page;

@Name("Пополнение")
public class ReplenishmentPage extends AkitaPage {

    @Name("Пополнить первую карту")
    @FindBy(css = "[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"] .button__text")
    private SelenideElement replenishmentButtonBefore1;
    @Name("Пополнить вторую карту")
    @FindBy(css = "[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] .button__text")
    private SelenideElement replenishmentButtonBefore2;
    @Name("Сумма")
    @FindBy(css = "[data-test-id=amount] .input__control")
    private SelenideElement amount;
    @Name("Откуда")
    @FindBy(css = "[data-test-id=from] .input__control")
    private SelenideElement from;
    @Name("Пополнить")
    @FindBy(css = "[data-test-id=action-transfer]")
    private SelenideElement replenishmentButtonAfter;


    public void setAmountValue(String amountValue) {

    }

    private String firstCardNumber = DataHelper.getCard1Info().getNumber();
    private String secondCardNumber = DataHelper.getCard2Info().getNumber();


    public DashboardPage replenishment(String from1To2OrFrom2to1, String amountValue) {
        if (from1To2OrFrom2to1 == "from1To2") {
            replenishmentButtonBefore2.click();
            amount.setValue(amountValue);
            from.setValue(firstCardNumber);
            replenishmentButtonAfter.click();
        }
        if (from1To2OrFrom2to1 == "from2To1") {
            replenishmentButtonBefore1.click();
            amount.setValue(amountValue);
            from.setValue(secondCardNumber);
            replenishmentButtonAfter.click();
        }
        return page(DashboardPage.class);
    }

}
