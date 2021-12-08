package steps;

import env.ApplicationProperties;
import env.Environment;

public class Test {
    public static void main(String[] args) {
        ApplicationProperties appProps = Environment.INSTANCE.getApplicationProperties();
        System.out.println(appProps.getBaseURL());
        System.out.println(appProps.getPropertyValue("git_hub"));
    }
}
