package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.BasePage;
import pages.RecruitmentPage;
import utils.Generator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CandidateFormTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        BasePage basePage = new BasePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        basePage.login();
        basePage.clickSidePanel("Recruitment");
        recruitmentPage.clickAddButton();
    }

    @Test
    public void navigationToAddCandidateFormTest() {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

        //Verifying the user is navigated to the "Add Candidate" form
        Assertions.assertTrue(recruitmentPage.isCurrentURLContains("recruitment/addCandidate"));
    }


    @Test
    public void emptyFieldsTest() {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.scrollTo(("//button[text()=\" Save \"]"));
        recruitmentPage.clickSaveButton();

        //Verifying that error messages contain the expected text
        List<String> actualErrorMessages = recruitmentPage.getErrorMessagesList();
        assertThat(actualErrorMessages).allSatisfy(item -> assertThat(item).contains("Required"));

        //Ensuring error messages are displayed in the appropriate locations
        Assertions.assertTrue(recruitmentPage.areErrorsUnderTheRightFields());
    }


    @Test
    public void cancelAddCandidateFormTest() {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.scrollTo(("//button[text()=\" Cancel \"]"));
        recruitmentPage.clickCancelButton();

        Assertions.assertTrue(recruitmentPage.isCurrentURLContains("/web/index.php/recruitment/viewCandidates"));
    }


    @ParameterizedTest
    @ValueSource(strings = {"myemail.com", "wrong@email@com", "emailcom"})
    public void emailFormatValidationTest(String wrongEmail) {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.typeEmail(wrongEmail);
        recruitmentPage.clickSaveButton();

        Assertions.assertEquals("Expected format: admin@example.com", recruitmentPage.getEmailErrorMessageText());
        Assertions.assertTrue(recruitmentPage.isErrorUnderEmailField());
    }


    @Test
    public void savingCandidateInformationTest() {
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.typeFirstName(Generator.generateFirstName());
        recruitmentPage.typeLastName(Generator.generateLastName());
        recruitmentPage.selectVacancy();
        recruitmentPage.typeEmail(Generator.generateEmail());
        recruitmentPage.typePhoneNumber(Generator.generatePhoneNumber());
        recruitmentPage.addFile();
        recruitmentPage.scrollTo(("//button[text()=\" Cancel \"]"));
        recruitmentPage.typeKeywords(Generator.generateKeywords());
        recruitmentPage.selectDate();
        recruitmentPage.typeNotes(Generator.generateNotes());
        recruitmentPage.giveConsentToKeepData();
        recruitmentPage.clickSaveButton();

        

    }

    // 6-ame teste assertus galima rasyti naudojant isEnabled()



}

