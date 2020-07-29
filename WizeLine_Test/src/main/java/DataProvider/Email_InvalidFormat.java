package DataProvider;

import org.testng.annotations.DataProvider;

public class Email_InvalidFormat {
    @DataProvider(name = "InvalidEmailFormat")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"plainaddress"},
                {"#@%^%#$@#$@#.com"},
                {"@example.com"},
                {"Joe Smith <email@example.com>"},
                {"email.example.com"},
                {"email@example@example.com"},
                {".email@example.com"},
                {"email.@example.com"},
                {"email..email@example.com"},
                {"あいうえお@example.com"},
                {"email@example.com (Joe Smith)"},
                {"email@example"},
                {"email@-example.com"},
                {"email@111.222.333.44444"},
                {"email@example..com"},
                {"Abc..123@example.com"},
        };
    }

}
