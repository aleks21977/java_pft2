package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ResetPasswordHelper extends HelperBase {

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void start() {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), app.getProperty("web.adminLogin"));
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.cssSelector("input[type='submit']"));
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        click(By.xpath("//a[text()='234']"));
        click(By.xpath("//input[@value='—бросить пароль']"));
    }

}
